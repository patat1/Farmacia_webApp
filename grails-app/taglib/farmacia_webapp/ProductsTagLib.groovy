package farmacia_webapp

import farmacia_webapp.utility.cartElement

class ProductsTagLib {
    static defaultEncodeAs = "raw"

    def prodtable = {
        def listaProdotti = Prodotto.executeQuery("from Prodotto order by nome")
        if (listaProdotti!=null)
            for (def prodotto : listaProdotti){
                def listaInMagazzino = Confezione.executeQuery("from Confezione where idProdotto = ? and idFarmacia = ?", [prodotto.getId(), session.farmacia])
                int quantità = 0
                if (listaInMagazzino.size()!=0)
                    quantità=listaInMagazzino.get(0).getQuantità()
                out << "<tr><td>"+ prodotto.getNome() + "</td>" +
                        "<td>"+ prodotto.getBarcode() + "</td>" +
                        "<td>"+ quantità + "</td>" +
                        "<td>" +
                        "<form action=\"orderPROD\" controller=\"ProductEditorController.groovy\">\n" +
                        "  <input type=\"number\" min=\"0\" value=\"0\" class=\"form-control\" name=\"quantity\"/>\n" +
                        "  <input type=\"hidden\" name=\"prodotto\" value=\""+ prodotto.getId() +"\"/>\n" +
                        "  <input class=\"btn btn-primary\" type=\"submit\" value=\"Ordina\">\n" +
                        "</form>" +
                        "</td></tr>"
        }
    }

    def buyProdTable = {
        def listaProdotti
        switch (session.usertype){
            case "TF":
            case "DF":
                listaProdotti = Confezione.executeQuery("select con.idProdotto, prod.nome, prod.barcode, prod.prezzo, con.quantità, prod.ricetta from farmacia_webapp.Confezione as con, farmacia_webapp.Prodotto as prod where con.idProdotto = prod.id and con.idFarmacia = ? and con.quantità>0 order by prod.nome", [session.farmacia])
                break
            case "OB":
                listaProdotti = Confezione.executeQuery("select con.idProdotto, prod.nome, prod.barcode, prod.prezzo, con.quantità, prod.ricetta  from farmacia_webapp.Confezione as con, farmacia_webapp.Prodotto as prod where con.idProdotto = prod.id and con.idFarmacia = ? and con.quantità>0 and prod.ricetta=false order by prod.nome", [session.farmacia])
                break
        }
        if (listaProdotti.size()>0)
            for (def prodotto : listaProdotti){
                /*
                 prodotto:
                 -0= id
                 -1= Nome
                 -2= Codice a Barre
                 -3= Prezzo
                 -4= Quantità
                 -5= Ricetta
                 */
                out << "<tr><td>"+ prodotto.getAt(1) + "</td>" +
                        "<td>"+ prodotto.getAt(2) + "</td>" +
                        "<td>"+ prodotto.getAt(3) + "€</td>" +
                        "<td>"+ prodotto.getAt(4) + "</td>" +
                        "<td>" +
                        "<form action=\"buyPROD\" controller=\"ProductEditorController.groovy\">\n" +
                        "  <input type=\"number\" min=\"1\" max=\""+ prodotto.getAt(4) +"\" value=\"0\" class=\"form-control\" name=\"quantity\"/>\n" +
                        "  <input type=\"hidden\" name=\"id\" value=\""+ prodotto.getAt(0) +"\"/>\n" +
                        "  <input type=\"hidden\" name=\"price\" value=\""+ prodotto.getAt(3) +"\"/>\n" +
                        "  <input type=\"hidden\" name=\"recipe\" value=\""+ prodotto.getAt(5) +"\"/>\n" +
                        "  <input class=\"btn btn-primary\" type=\"submit\" value=\"Ordina\">\n" +
                        "</form>" +
                        "</td></tr>"
            }
    }

    def cartProdTable = {
        def listaProdotti
        if (session.cart!=null)
            for (def prodotto : session.cart){
                def p = listaProdotti = Prodotto.executeQuery("from Prodotto where id = ?", [prodotto.getId()]).get(0)
                if (prodotto.getRecipe())
                    out << "<tr><td class=\"text-info\">"+ p.getNome() + "</td>"
                else
                    out << "<tr><td>"+ p.getNome() + "</td>"
                out << "<td>"+ prodotto.getPrice() + "€</td>" +
                        "<td>"+ prodotto.getQuantity() + "</td>" +
                        "<td>" +
                        "<form action=\"deletePROD\" controller=\"CarrelloController.groovy\">\n" +
                        "  <input type=\"hidden\" name=\"id\" value=\""+ prodotto.getId() +"\"/>\n" +
                        "  <input class=\"btn btn-primary\" type=\"submit\" value=\"Rimuovi Prodotto\">\n" +
                        "</form>"
                if (prodotto.getRecipe()){
                    session.idRecipeProd = prodotto.getId()
                    out << "<a class=\"btn btn-danger\" href=\"../recipe/index.gsp\">Registra ricetta</a>"
                }
                out << "</td></tr>"
            }
    }

    def showCartPrice = {
        float total = 0
        if (session.cart!=null)
            for (def prodotto : session.cart){
                total += prodotto.getPrice()*prodotto.getQuantity()
            }
        out << "<h3>Totale " + total + "€</h3>"
    }
}