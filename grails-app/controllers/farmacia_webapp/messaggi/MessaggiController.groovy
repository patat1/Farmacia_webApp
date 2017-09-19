package farmacia_webapp.messaggi

import farmacia_webapp.Messaggio
import farmacia_webapp.Utente

import java.text.SimpleDateFormat

class MessaggiController {

    def inbox() {

    }

    def sent() {

    }

    def write() {

    }

    def send = {
        Date dt = new Date()
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm")
        String currentTime = sdf.format(dt)
        def idDest = Utente.executeQuery("from Utente where username = ?", [params.destinatario]).get(0).getId()
        new Messaggio(
                idDestinatario: idDest,
                idMittente: session.user,
                data: currentTime,
                corpoMessaggio: params.messaggio
        ).save()
        flash.message = "Messaggio per " + params.destinatario + " inviato!"
        redirect(action: "inbox")
    }
}
