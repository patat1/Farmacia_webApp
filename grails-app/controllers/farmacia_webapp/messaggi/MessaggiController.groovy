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

    def response = {
        if (params.destinatario == "" || params.messaggio == "") {
            flash.message = "Riempire tutti i campi"
            redirect(action: "write")
        } else {
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

    def sendFromReg = {
        if (params.destinatario == "" || params.messaggio == "") {
            flash.message = "Riempire tutti i campi"
            redirect(action: "write")
        } else {
            Date dt = new Date()
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm")
            String currentTime = sdf.format(dt)
            if (params.destinatario == "x") {
                def idDest = Utente.executeQuery("from Utente where tipo = ?", ["TF"])
                for (def titolare : idDest) {
                    new Messaggio(
                            idDestinatario: titolare.getId(),
                            idMittente: session.user,
                            data: currentTime,
                            corpoMessaggio: params.messaggio
                    ).save()
                }

            } else {
                def idDest = Utente.executeQuery("from Utente where idFarmacia = ? and tipo = ?", [Integer.parseInt(params.destinatario), "TF"]).get(0).getId()
                new Messaggio(
                        idDestinatario: idDest,
                        idMittente: session.user,
                        data: currentTime,
                        corpoMessaggio: params.messaggio
                ).save()
            }
            flash.message = "Messaggio inviato!"
            params.destinatario = null
            redirect(action: "inbox")
        }
    }

    def sendFromTf = {
        if (params.destinatario == "" || params.messaggio == "") {
            flash.message = "Riempire tutti i campi"
            redirect(action: "write")
        } else {
            Date dt = new Date()
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm")
            String currentTime = sdf.format(dt)
            if (params.destinatario == "x") {
                def idDest = Utente.executeQuery("from Utente where idFarmacia = ? and tipo != ?", [session.farmacia, "TF"])
                for (def dest : idDest) {
                    new Messaggio(
                            idDestinatario: dest.getId(),
                            idMittente: session.user,
                            data: currentTime,
                            corpoMessaggio: params.messaggio
                    ).save()
                }

            } else if (params.destinatario == "r") {
                def idDest = Utente.executeQuery("from Utente where tipo = ?", ["REG"]).get(0).getId()
                new Messaggio(
                        idDestinatario: idDest,
                        idMittente: session.user,
                        data: currentTime,
                        corpoMessaggio: params.messaggio
                ).save()
            } else {
                def idDest = Utente.executeQuery("from Utente where id = ?", [Integer.parseInt(params.destinatario)]).get(0).getId()
                new Messaggio(
                        idDestinatario: idDest,
                        idMittente: session.user,
                        data: currentTime,
                        corpoMessaggio: params.messaggio
                ).save()
            }
            flash.message = "Messaggio inviato!"
            params.destinatario = null
            redirect(action: "inbox")
        }
    }

    def sendFromAll = {
        if (params.destinatario == "" || params.messaggio == "") {
            flash.message = "Riempire tutti i campi"
            redirect(action: "write")
        } else {
            Date dt = new Date()
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm")
            String currentTime = sdf.format(dt)
            if (params.destinatario == "x") {
                def idDest = Utente.executeQuery("from Utente where idFarmacia = ? and id != ?", [session.farmacia, session.user])
                for (def dest : idDest) {
                    new Messaggio(
                            idDestinatario: dest.getId(),
                            idMittente: session.user,
                            data: currentTime,
                            corpoMessaggio: params.messaggio
                    ).save()
                }

            } else if (params.destinatario == "t") {
                def idDest = Utente.executeQuery("from Utente where tipo = ? and idFarmacia = ?", ["TF", session.farmacia]).get(0).getId()
                new Messaggio(
                        idDestinatario: idDest,
                        idMittente: session.user,
                        data: currentTime,
                        corpoMessaggio: params.messaggio
                ).save()
            } else {
                def idDest = Utente.executeQuery("from Utente where id = ?", [Integer.parseInt(params.destinatario)]).get(0).getId()
                new Messaggio(
                        idDestinatario: idDest,
                        idMittente: session.user,
                        data: currentTime,
                        corpoMessaggio: params.messaggio
                ).save()
            }
            flash.message = "Messaggio inviato!"
            params.destinatario = null
            redirect(action: "inbox")
        }
    }
}