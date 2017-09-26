package farmacia_webapp.statistiche

class StatisticController {

    def index() {
        check()
        if(params.start>params.end){
            flash.message="Errore: date inserite in maniera incoerente"
            redirect(action: "index")
        }
    }

    def check(){
        if (session.usertype == null || session.user == null){
            flash.message="Errore: login non effettuato correttamente"
            session.user=null
            session.usertype=null
            redirect (action: "login", controller: "login")
        }
    }
}
