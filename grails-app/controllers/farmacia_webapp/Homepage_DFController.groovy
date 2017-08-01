package farmacia_webapp

class Homepage_DFController {

    def index() {
        if (session.usertype != "DF" ){
            flash.message="Errore: login come Dottore non effettuato"
            session.user=null
            session.usertype=null
            redirect (action: "login", controller: "login")
        }
    }
}
