package farmacia_webapp


class LoginController {

    def login() { }
    def logout() { }
    def subscribe() {}

    def log_in = {
        if (params.username== "PIEMONTE" && params.password== "regionepiemonte"){
            session.user="regione"
            session.usertype="REG"
            redirect(controller: 'homepage_regione', action:'index')
        }
        else if(UtenteTF.executeQuery("from UtenteTF where email=? AND password=?", [params.username, params.password])) {
            session.user=params.username
            session.usertype="TS"
            redirect(controller: 'homepage_ts', action:'index')
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
