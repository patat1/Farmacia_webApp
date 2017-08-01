package farmacia_webapp

class Homepage_OBController {

    def index() {
        if (session.usertype != "OB" ){
            flash.message="Errore: login come Operatore non effettuato"
            session.user=null
            session.usertype=null
            redirect (action: "login", controller: "login")
        }
    }
}
