package farmacia_webapp

import farmacia_webapp.UtenteTF

class SubscriberMasterController {

    def subscribeTF() {
        if (session.usertype != "REG"){
            flash.message="Errore: login come Regione non effettuato"
            session.user=null
            session.usertype=null
            redirect (action: "login", controller: "login")
        }
    }
    def confirmation() {}

    def subTF = {
        flash.message=""
        if (params.nome=="" || params.cognome=="" || params.passworda=="" || params.passwordb=="" || params.email==""
        || params.nomef=="" || params.numero=="" || params.via==""){
            flash.message= flash.message + "Errore: Riempire tutti i campi"
            redirect(action: "subscribeTF")
        }
        if (params.passworda!=params.passwordb){
            flash.message= flash.message + "Errore: le password non coincidono"
            redirect(action: "subscribeTF")
        }
        if (UtenteTF.executeQuery("from UtenteTF where email = ?", [params.email])){
            flash.message= flash.message + "Errore: l'email inserita risulta già associata ad un account"
            redirect(action: "subscribeTF")
        }

        if (flash.message==""){
            session.newuser = params.nome + " " + params.cognome
            new UtenteTF(
                    nome: params.nome,
                    password: params.passworda,
                    cognome: params.cognome,
                    email: params.email).save()
            new Farmacia(
                    nome: params.nomef,
                    via: params.via,
                    numtel: params.numero,
                    nomeTit: params.nome + params.cognome,
                    utenteTF_FK: params.email).save()
            redirect(action: "confirmation")
        }

    }

}
