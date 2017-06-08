package farmacia_webapp

import farmacia_webapp.UtenteTF

class SubscriberMasterController {

    def subscribeTF() { }
    def confirmation() {}

    def subTF = {
        flash.message=""
        if (params.nome=="" || params.cognome=="" || params.passworda=="" || params.passwordb==""){
            flash.message= flash.message + "Errore: Riempire tutti i campi"
            redirect(action: "subscribeTF")
        }
        if (params.passworda!=params.passwordb){
            flash.message= flash.message + "Errore: le password non coincidono"
            redirect(action: "subscribeTF")
        }
        if (flash.message==""){
            new UtenteTF(nome: params.nome, password: params.passworda, cognome: params.cognome).save()
            redirect(action: "confirmation")
        }

    }

}
