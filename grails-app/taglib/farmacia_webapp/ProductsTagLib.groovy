package farmacia_webapp

import farmacia_webapp.utility.cartElement

class ProductsTagLib {
    static defaultEncodeAs = "raw"
    def prodtable = {
        def listaProdotti = Prodotto.executeQuery("from Prodotto")
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
/*
    def buyProdTable = {
        def listaProdotti
        switch (session.usertype){
            case "TF":
            case "DF":
                listaProdotti = Prodotto.executeQuery("from Prodotto where utenteTF_FK = ? and dispon>0", [session.farmacia])
                break
            case "OB":
                listaProdotti = Prodotto.executeQuery("from Prodotto where utenteTF_FK = ? and tipo = false and dispon>0", [session.farmacia])
                break
        }
        if (listaProdotti!=null)
            for (def prodotto : listaProdotti){
                out << "<tr><td>"+ prodotto.getNome() + "</td>" +
                        "<td>"+ prodotto.getCodice() + "</td>" +
                        "<td>"+ prodotto.getPrezzo() + "€</td>" +
                        "<td>"+ prodotto.getDispon() + "</td>" +
                        "<td>" +
                        "<form action=\"buyPROD\" controller=\"ProductEditorController.groovy\">\n" +
                        "  <input type=\"number\" min=\"1\" max=\""+ prodotto.getDispon() +"\" value=\"0\" class=\"form-control\" name=\"quantity\"/>\n" +
                        "  <input type=\"hidden\" name=\"barcode\" value=\""+ prodotto.getCodice() +"\"/>\n" +
                        "  <input type=\"hidden\" name=\"price\" value=\""+ prodotto.getPrezzo() +"\"/>\n" +
                        "  <input class=\"btn btn-primary\" type=\"submit\" value=\"Ordina\">\n" +
                        "</form>" +
                        "</td></tr>"
            }
    }

    def cartProdTable = {
        def listaProdotti
        if (session.cart!=null)
            for (def prodotto : session.cart){
                def p = listaProdotti = Prodotto.executeQuery("from Prodotto where codice = ? and utenteTF_FK = ?", [prodotto.getBarcode(), session.farmacia]).get(0)
                out << "<tr><td>"+ p.getNome() + "</td>" +
                        "<td>"+ p.getCodice() + "</td>" +
                        "<td>"+ prodotto.getPrice() + "€</td>" +
                        "<td>"+ prodotto.getQuantity() + "</td>" +
                        "<td>" +
                        "<form action=\"deletePROD\" controller=\"CarrelloController.groovy\">\n" +
                        "  <input type=\"hidden\" name=\"barcode\" value=\""+ p.getCodice() +"\"/>\n" +
                        "  <input class=\"btn btn-primary\" type=\"submit\" value=\"Rimuovi Prodotto\">\n" +
                        "</form>" +
                        "</td></tr>"
            }
    }*/
}