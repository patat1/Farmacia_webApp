package farmacia_webapp

import farmacia_webapp.UtenteTF

class SubscriberMasterController {

    def subscribeTF() {
        if (session.user != "regione"){
            flash.message="Errore: login come Regione non effettuato"
            redirect (action: "login", controller: "login")
        }
    }
    def confirmation() {}

    def subTF = {
        flash.message=""
        if (params.nome=="" || params.cognome=="" || params.passworda=="" || params.passwordb=="" || params.email==""){
            flash.message= flash.message + "Errore: Riempire tutti i campi"
            redirect(action: "subscribeTF")
        }
        if (params.passworda!=params.passwordb){
            flash.message= flash.message + "Errore: le password non coincidono"
            redirect(action: "subscribeTF")
        }
        if (UtenteTF.executeQuery("from UtenteTF where email = ?", [params.email])){
            flash.message= flash.message + "Errore: l'email risulta già associata ad un account"
            redirect(action: "subscribeTF")
        }

        if (flash.message==""){
            session.newuser = params.nome + " " + params.cognome
            new UtenteTF(nome: params.nome, password: params.passworda, cognome: params.cognome, email: params.email).save()
            redirect(action: "confirmation")
        }

    }

}
