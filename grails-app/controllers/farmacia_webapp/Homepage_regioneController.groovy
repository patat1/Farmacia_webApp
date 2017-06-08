package farmacia_webapp

class Homepage_regioneController {

    def index() {
        if (session.user != "regione"){
            flash.message="Errore: login come Regione non effettuato"
            redirect (action: "login", controller: "login")
        }
    }

}
