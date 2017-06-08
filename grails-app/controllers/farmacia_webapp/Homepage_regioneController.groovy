package farmacia_webapp

class Homepage_regioneController {

    def index() {
        if (session.usertype != "REG"){
            flash.message="Errore: login come Regione non effettuato"
            session.user=null
            session.usertype=null
            redirect (action: "login", controller: "login")
        }
    }

}
