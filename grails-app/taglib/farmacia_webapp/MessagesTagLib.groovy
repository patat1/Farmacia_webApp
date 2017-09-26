package farmacia_webapp

class MessagesTagLib {
    static defaultEncodeAs = "raw"

    def inboxTable = {
        def listaMessaggi = Messaggio.executeQuery("from Messaggio where idDestinatario= ? order by id desc", [session.user])
        if (listaMessaggi!=null)
            for (def messaggio : listaMessaggi){
                def mittente = Utente.executeQuery("from Utente where id = ?", [messaggio.getIdMittente()]).get(0)
                out << "<tr><td>" + mittente.getNome() + " " + mittente.getCognome() + ", " + mittente.getTipo() + "</td>" +
                        "<td>"+ messaggio.getData() + "</td>" +
                        "<td>"+ messaggio.getCorpoMessaggio() + "</td>" +
                        "<td>" +
                        "<form action=\"write\" controller=\"MessaggiController.groovy\">\n" +
                        "  <input type=\"hidden\" name=\"destinatario\" value=\""+ mittente.getUsername() +"\"/>\n" +
                        "  <input class=\"btn btn-primary\" type=\"submit\" value=\"Rispondi\">\n" +
                        "</form>" +
                        "</td></tr>"
            }
    }

    def sentTable = {
        def listaMessaggi = Messaggio.executeQuery("from Messaggio where idMittente= ? order by id desc", [session.user])
        if (listaMessaggi!=null)
            for (def messaggio : listaMessaggi){
                def dest = Utente.executeQuery("from Utente where id = ?", [messaggio.getIdDestinatario()]).get(0)
                out << "<tr><td>" + dest.getNome() + " " + dest.getCognome() + ", " + dest.getTipo() + "</td>" +
                        "<td>"+ messaggio.getData() + "</td>" +
                        "<td>"+ messaggio.getCorpoMessaggio() + "</td>" +
                        "<td>" +
                        "</td></tr>"
            }
    }

    def writeFromReg = {
        def listaFarmacie = Farmacia.executeQuery("from Farmacia where nome != ?", ["X"])//seleziona tutte le farmacie tranne X, quella della regione
        if (params.destinatario!=null){
            out << "<form class=\"form-horizontal\" role=\"form\" action=\"response\" controller=\"MessaggiController.groovy\">\n" +
                    "                    <div class=\"form-group\">\n" +
                    "                        <div class=\"col-sm-6\">\n" +
                    "<input type=\"text\" class=\"form-control\" value=\"${params.destinatario}\" name=\"destinatario\" placeholder=\"Destinatario\">\n"
        }
        else {
            out << "<form class=\"form-horizontal\" role=\"form\" action=\"sendFromReg\" controller=\"MessaggiController.groovy\">\n" +
                    "                    <div class=\"form-group\">\n" +
                    "                        <div class=\"col-sm-6\">\n" +
                    "<select class=\"btn btn-primary dropdown-toggle\" name=\"destinatario\">\n" +
                    "  <OPTION VALUE=\"x\" SELECTED>Invia a tutti\n"
            for (def farmacia : listaFarmacie){
                out <<"<OPTION VALUE=" + farmacia.getId() + ">" + farmacia.getNome() + "\n"
            }
            out <<  "</select>\n"
        }
        out <<  "                        </div>\n" +
                "                    </div>\n" +
                "                    <div class=\"form-group\">\n" +
                "                        <div class=\"col-sm-12\">\n" +
                "                            <input type=\"text\" class=\"form-control\" cols=\"40\" rows=\"5\" name=\"messaggio\" placeholder=\"Messaggio\">\n" +
                "                        </div>\n" +
                "                    </div>\n" +
                "                    <div class=\"form-group\">\n" +
                "                        <div class=\"col-sm-10\">\n" +
                "                            <button type=\"submit\" class=\"btn btn-success\">Invia</button>\n" +
                "                        </div>\n" +
                "                    </div>\n" +
                "                </form>"
    }

    def writeFromTf = {
        def listaUtenti = Utente.executeQuery("from Utente where idFarmacia = ? and tipo != ?", [session.farmacia, "TF"])
        if (params.destinatario!=null){
            out << "<form class=\"form-horizontal\" role=\"form\" action=\"response\" controller=\"MessaggiController.groovy\">\n" +
                    "                    <div class=\"form-group\">\n" +
                    "                        <div class=\"col-sm-6\">\n" +
                    "<input type=\"text\" class=\"form-control\" value=\"${params.destinatario}\" name=\"destinatario\" placeholder=\"Destinatario\">\n"
        }
        else {
            out << "<form class=\"form-horizontal\" role=\"form\" action=\"sendFromTf\" controller=\"MessaggiController.groovy\">\n" +
                    "                    <div class=\"form-group\">\n" +
                    "                        <div class=\"col-sm-6\">\n" +
                    "<select class=\"btn btn-primary dropdown-toggle\" name=\"destinatario\">\n" +
                    "  <OPTION VALUE=\"r\" SELECTED>Invia alla Regione\n" +
                    "  <OPTION VALUE=\"x\" SELECTED>Invia a tutti i dipendenti\n"
            for (def destinatario : listaUtenti){
                out <<"<OPTION VALUE=" + destinatario.getId() + ">" + destinatario.getNome() + " " + destinatario.getCognome() +  "\n"
            }
            out <<  "</select>\n"
        }
        out <<  "                        </div>\n" +
                "                    </div>\n" +
                "                    <div class=\"form-group\">\n" +
                "                        <div class=\"col-sm-12\">\n" +
                "                            <input type=\"text\" class=\"form-control\" cols=\"40\" rows=\"5\" name=\"messaggio\" placeholder=\"Messaggio\">\n" +
                "                        </div>\n" +
                "                    </div>\n" +
                "                    <div class=\"form-group\">\n" +
                "                        <div class=\"col-sm-10\">\n" +
                "                            <button type=\"submit\" class=\"btn btn-success\">Invia</button>\n" +
                "                        </div>\n" +
                "                    </div>\n" +
                "                </form>"
    }

    def writeFromRandom = {
        def listaUtenti = Utente.executeQuery("from Utente where idFarmacia = ? and tipo != ? and id != ?", [session.farmacia, "TF", session.user])
        if (params.destinatario!=null){
            out << "<form class=\"form-horizontal\" role=\"form\" action=\"response\" controller=\"MessaggiController.groovy\">\n" +
                    "                    <div class=\"form-group\">\n" +
                    "                        <div class=\"col-sm-6\">\n" +
                    "<input type=\"text\" class=\"form-control\" value=\"${params.destinatario}\" name=\"destinatario\" placeholder=\"Destinatario\">\n"
        }
        else {
            out << "<form class=\"form-horizontal\" role=\"form\" action=\"sendFromAll\" controller=\"MessaggiController.groovy\">\n" +
                    "                    <div class=\"form-group\">\n" +
                    "                        <div class=\"col-sm-6\">\n" +
                    "<select class=\"btn btn-primary dropdown-toggle\" name=\"destinatario\">\n" +
                    "  <OPTION VALUE=\"t\" SELECTED>Invia al Titolare\n" +
                    "  <OPTION VALUE=\"x\" SELECTED>Invia a tutti\n"
            for (def destinatario : listaUtenti){
                out <<"<OPTION VALUE=" + destinatario.getId() + ">" + destinatario.getNome() + " " + destinatario.getCognome() +  "\n"
            }
            out <<  "</select>\n"
        }
        out <<  "                        </div>\n" +
                "                    </div>\n" +
                "                    <div class=\"form-group\">\n" +
                "                        <div class=\"col-sm-12\">\n" +
                "                            <input type=\"text\" class=\"form-control\" cols=\"40\" rows=\"5\" name=\"messaggio\" placeholder=\"Messaggio\">\n" +
                "                        </div>\n" +
                "                    </div>\n" +
                "                    <div class=\"form-group\">\n" +
                "                        <div class=\"col-sm-10\">\n" +
                "                            <button type=\"submit\" class=\"btn btn-success\">Invia</button>\n" +
                "                        </div>\n" +
                "                    </div>\n" +
                "                </form>"
    }
}
