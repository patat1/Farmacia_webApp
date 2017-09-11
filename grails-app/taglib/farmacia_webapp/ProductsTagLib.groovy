package farmacia_webapp

class ProductsTagLib {
    static defaultEncodeAs = "raw"
    def prodtable = {
        def listaProdotti = Prodotto.executeQuery("from Prodotto where utenteTF_FK = ?", [session.user])
        if (listaProdotti!=null)
            for (def prodotto : listaProdotti){
            out << "<tr><td>"+ prodotto.getNome() + "</td>" +
                    "<td>"+ prodotto.getCodice() + "</td>" +
                    "<td>"+ prodotto.getPrezzo() + "€</td>" +
                    "<td>"+ prodotto.getDispon() + "</td>" +
                    "<td>" +
                    "<form action=\"orderPROD\" controller=\"ProductEditorController.groovy\">\n" +
                    "  <input type=\"number\" min=\"0\" value=\"0\" class=\"form-control\" name=\"quantity\"/>\n" +
                    "  <input type=\"hidden\" name=\"barcode\" value=\""+ prodotto.getCodice() +"\"/>\n" +
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
                def p = listaProdotti = Prodotto.executeQuery("from Prodotto where codice = ? and utenteTF_FK = ?", [prodotto[1], session.farmacia]).get(0)
                out << "<tr><td>"+ p.getNome() + "</td>" +
                        "<td>"+ prodotto[1] + "</td>" +
                        "<td>"+ prodotto[2] + "€</td>" +
                        "<td>"+ prodotto[0] + "</td>" +
                        "<td>" +
                        "<form action=\"orderPROD\" controller=\"ProductEditorController.groovy\">\n" +
                        "  <input type=\"number\" min=\"0\" value=\"0\" class=\"form-control\" name=\"quantity\"/>\n" +
                        "  <input type=\"hidden\" name=\"barcode\" value=\""+ prodotto[1] +"\"/>\n" +
                        "  <input class=\"btn btn-primary\" type=\"submit\" value=\"Ordina\">\n" +
                        "</form>" +
                        "</td></tr>"
            }
    }
}