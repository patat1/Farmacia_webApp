package farmacia_webapp

class LoginController {

    def login() { }
    def logout() { }
    def subscribe() {}

    def log_in = {
        if (params.username== "PIEMONTE" && params.password== "regionepiemonte"){
            session.user="regione"
            redirect(controller: 'homepage_regione', action:'index')
        }
            /*
        else if() {

        }*/
        else{
            flash.message="Errore: utente o password errati. Riprovare"
            redirect(action: "login")
        }
    }

    def log_out = {
        session.user=null
        redirect(uri:'/')
    }
}
