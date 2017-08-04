package farmacia_webapp.login_subscribe

import farmacia_webapp.UtenteDF
import farmacia_webapp.UtenteOB
import farmacia_webapp.UtenteTF


class LoginController {

    def login() { }
    def logout() { }

    def log_in = {
        Object info
        if (params.username== "PIEMONTE" && params.password== "regionepiemonte"){
            session.user="regione"
            session.usertype="REG"
            redirect(controller: 'homepage_regione', action:'index')
        }
        else if(UtenteTF.executeQuery("from UtenteTF where email=? AND password=?", [params.username, params.password])) {
            session.userinfo=session.user=params.username
            session.usertype="TF"
            redirect(controller: 'homepage_TF', action:'index')
        }
        else if(UtenteDF.executeQuery("from UtenteDF where email=? AND password=?", [params.username, params.password])) {
            session.userinfo=session.user=params.username
            session.usertype="DF"
            redirect(controller: 'homepage_DF', action:'index')
        }
        else if(UtenteOB.executeQuery("from UtenteOB where email=? AND password=?", [params.username, params.password])) {
            session.userinfo=session.user=params.username
            session.usertype="OB"
            redirect(controller: 'homepage_OB', action:'index')
        }
        else{
            flash.message="Errore: utente o password errati. Riprovare"
            redirect(action: "login")
        }
    }

    def log_out = {
        session.user=null
        session.usertype=null
        redirect(uri:'/')
    }
}
