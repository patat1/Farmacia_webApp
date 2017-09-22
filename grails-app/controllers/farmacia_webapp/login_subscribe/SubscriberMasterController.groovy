package farmacia_webapp.login_subscribe

import farmacia_webapp.Farmacia
import farmacia_webapp.Medico
import farmacia_webapp.Utente

class SubscriberMasterController {

    def subscribeTF() {
        if (session.usertype != "REG"){
            flash.message="Errore: login come Regione non effettuato"
            session.user=null
            session.usertype=null
            redirect (action: "login", controller: "login")
        }
    }
    def subscribeDF() {
        if (session.usertype != "TF"){
            flash.message="Errore: login come Titolare non effettuato"
            session.user=null
            session.usertype=null
            redirect (action: "login", controller: "login")
        }
    }
    def subscribeOB() {
        if (session.usertype != "TF"){
            flash.message="Errore: login come Titolare non effettuato"
            session.user=null
            session.usertype=null
            redirect (action: "login", controller: "login")
        }
    }

    def subscribeMedico() {
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
        if (params.nome=="" || params.cognome=="" || params.passworda=="" || params.passwordb==""
        || params.nomef=="" || params.numero=="" || params.via==""){
            flash.message= flash.message + "Errore: Riempire tutti i campi"
            redirect(action: "subscribeTF")
        }
        if (params.passworda!=params.passwordb){
            flash.message= flash.message + "Errore: le password non coincidono"
            redirect(action: "subscribeTF")
        }
        if (Utente.executeQuery("from Utente where nome = ? and cognome=?", [params.nome, params.cognome])){
            flash.message= flash.message + "Errore: l'utente risulta già iscritto"
            redirect(action: "subscribeTF")
        }

        if (flash.message==""){
            session.newuser= params.nome+" "+params.cognome + ", Titolare di " + params.nomef + " (Nome Utente: " + params.nome+params.cognome+ "@TF)"//usato per la conferma
            new Farmacia(
                    nome: params.nomef,
                    via: params.via,
                    numtel: params.numero).save()
            int farmacia_numero = Farmacia.executeQuery("from Farmacia where nome = ?", [params.nomef]).get(0).getId()
            new Utente(
                    nome: params.nome,
                    password: params.passworda,
                    cognome: params.cognome,
                    username: params.nome+params.cognome+"@TF",
                    tipo: "TF",
                    idFarmacia: farmacia_numero).save()
            redirect(action: "confirmation")
        }

    }

    def subDF = {
        flash.message=""
        if (params.nome=="" || params.cognome==""
            ||params.passworda=="" || params.passwordb==""){
            flash.message= flash.message + "Errore: Riempire tutti i campi"
            redirect(action: "subscribeDF")
        }
        if (params.passworda!=params.passwordb){
            flash.message= flash.message + "Errore: le password non coincidono"
            redirect(action: "subscribeDF")
        }
        if (Utente.executeQuery("from Utente where nome = ? and cognome=?", [params.nome, params.cognome])){
            flash.message= flash.message + "Errore: l'utente risulta già iscritto"
            redirect(action: "subscribeDF")
        }

        if (flash.message==""){
            session.newuser= params.nome+" "+params.cognome + " (Nome Utente: " + params.nome+params.cognome+ "@DF)"//usato per la conferma
            new Utente(
                    nome: params.nome,
                    password: params.passworda,
                    cognome: params.cognome,
                    username: params.nome+params.cognome+"@DF",
                    tipo: "DF",
                    idFarmacia: session.farmacia).save()
            redirect(action: "confirmation")
        }
    }

    def subOB = {
        flash.message=""
        if (params.nome=="" || params.cognome==""
                ||params.passworda=="" || params.passwordb=="" || params.email==""){
            flash.message= flash.message + "Errore: Riempire tutti i campi"
            redirect(action: "subscribeOB")
        }
        if (params.passworda!=params.passwordb){
            flash.message= flash.message + "Errore: le password non coincidono"
            redirect(action: "subscribeOB")
        }
        if (Utente.executeQuery("from Utente where nome = ? and cognome=?", [params.nome, params.cognome])){
            flash.message= flash.message + "Errore: l'utente risulta già iscritto"
            redirect(action: "subscribeOB")
        }

        if (flash.message==""){
            session.newuser= params.nome+" "+params.cognome + " (Nome Utente: " + params.nome+params.cognome+ "@OB)"//usato per la conferma
            new Utente(
                    nome: params.nome,
                    password: params.passworda,
                    cognome: params.cognome,
                    username: params.nome+params.cognome+"@OB",
                    tipo: "OB",
                    idFarmacia: session.farmacia).save()
            redirect(action: "confirmation")
        }
    }

    def subMed = {
        flash.message=""
        if (params.nome=="" || params.cognome==""
                ||params.codereg==""){
            flash.message= flash.message + "Errore: Riempire tutti i campi"
            redirect(action: "subscribeMedico")
        }
        if (Medico.executeQuery("from Medico where codiceRegionale = ?", [params.codereg])){
            flash.message= flash.message + "Errore: il medico risulta già registrato"
            redirect(action: "subscribeMedico")
        }

        if (flash.message==""){
            session.newuser= "Medico " + params.nome+" "+params.cognome//usato per la conferma
            new Medico(
                    nome: params.nome,
                    cognome: params.cognome,
                    codiceRegionale: params.codereg).save()
            redirect(action: "confirmation")
        }
    }
}
