package farmacia_webapp

class TableProductsTagLib {
    static defaultEncodeAs = "raw"
    def prodtable = {
        def listaProdotti = Prodotto.executeQuery("from Prodotto where utenteTF_FK = ?", [session.user])
        for (def prodotto : listaProdotti){
            out << "<tr><td>"+ prodotto.getNome() + "</td>" +
                    "<td>"+ prodotto.getCodice() + "</td>" +
                    "<td>"+ prodotto.getPrezzo() + "€</td>" +
                    "<td>"+ prodotto.getDispon() + "</td>" +
                    "<td><a class=\"btn btn-primary\">Click me</a></td></tr>"
        }
    }
}
