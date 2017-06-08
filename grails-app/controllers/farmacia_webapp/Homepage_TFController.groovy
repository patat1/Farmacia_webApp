package farmacia_webapp

class Homepage_TFController {

    def index() {
        if (session.usertype != "TF" ){
            flash.message="Errore: login come Titolare non effettuato"
            session.user=null
            session.usertype=null
            redirect (action: "login", controller: "login")
        }
    }
}
