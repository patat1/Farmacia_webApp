package farmacia_webapp

class Homepage_TSController {

    def index() {
        if (session.usertype != "TS" ){
            flash.message="Errore: login come Titolare non effettuato"
            session.user=null
            session.usertype=null
            redirect (action: "login", controller: "login")
        }
    }
}
