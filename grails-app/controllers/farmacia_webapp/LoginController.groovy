package farmacia_webapp

class LoginController {

    def login() { }
    def logout() { }
    def subscribe() {}

    def log_in = {
        if (params.username== "admin" && params.password== "admin"){
            session.user="admin"
            redirect(uri:'/')
        }
        else{
            flash.message="Errore: utente o password errati. Riprovare"
            redirect(action: "login")
        }
    }

    def log_out = {
        session.user=null
        redirect(uri:'/')
    }

    def subscribe_newuser = {

    }
}
