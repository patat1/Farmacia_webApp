package farmacia_webapp

class MessagesTagLib {
    static defaultEncodeAs = "raw"

    def inboxTable = {
        def listaMessaggi = Messaggio.executeQuery("from Messaggio where idDestinatario= ?", [session.user])
        if (listaMessaggi!=null)
            for (def messaggio : listaMessaggi){
                def mittente = Utente.executeQuery("from Utente where id = ?", [messaggio.getIdMittente()]).get(0)
                out << "<tr><td>"+ mittente.getUsername() + "</td>" +
                        "<td>"+ messaggio.getData() + "</td>" +
                        "<td>"+ messaggio.getCorpoMessaggio() + "</td>" +
                        "<td>" +
                        "<form action=\"write\" controller=\"MessaggiController.groovy\">\n" +
                        "  <input type=\"hidden\" name=\"destinatario\" value=\""+ messaggio.getIdMittente() +"\"/>\n" +
                        "  <input class=\"btn btn-primary\" type=\"submit\" value=\"Rispondi\">\n" +
                        "</form>" +
                        "</td></tr>"
            }
    }
}
