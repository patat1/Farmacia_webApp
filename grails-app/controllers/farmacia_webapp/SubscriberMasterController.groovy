package farmacia_webapp

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
            session.newuser= params.nomef//usato per la conferma
            new UtenteTF(
                    nome: params.nome,
                    password: params.passworda,
                    cognome: params.cognome,
                    email: params.email).save()
            new Farmacia(
                    nome: params.nomef,
                    via: params.via,
                    numtel: params.numero,
                    nomeTit: params.nome +" "+ params.cognome,
                    utenteTF_FK: params.email).save()
            redirect(action: "confirmation")
        }

    }

    def subDF = {
        flash.message=""
        if (params.nome=="" || params.cognome==""
            ||params.passworda=="" || params.passwordb=="" || params.email==""){
            flash.message= flash.message + "Errore: Riempire tutti i campi"
            redirect(action: "subscribeDF")
        }
        if (params.passworda!=params.passwordb){
            flash.message= flash.message + "Errore: le password non coincidono"
            redirect(action: "subscribeDF")
        }
        if (UtenteDF.executeQuery("from UtenteDF where email = ?", [params.email])){
            flash.message= flash.message + "Errore: l'email inserita risulta già associata ad un account"
            redirect(action: "subscribeDF")
        }

        if (flash.message==""){
            session.newuser= params.nome+" "+params.cognome//usato per la conferma
            new UtenteDF(
                    nome: params.nome,
                    password: params.passworda,
                    cognome: params.cognome,
                    email: params.email,
                    utenteTF_FK: session.user).save()
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
        if (UtenteDF.executeQuery("from UtenteOB where email = ?", [params.email])){
            flash.message= flash.message + "Errore: l'email inserita risulta già associata ad un account"
            redirect(action: "subscribeOB")
        }

        if (flash.message==""){
            session.newuser= params.nome+" "+params.cognome//usato per la conferma
            new UtenteOB(
                    nome: params.nome,
                    password: params.passworda,
                    cognome: params.cognome,
                    email: params.email,
                    utenteTF_FK: session.user).save()
            redirect(action: "confirmation")
        }
    }

}
