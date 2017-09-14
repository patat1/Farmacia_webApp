
package farmacia_webapp.homepage

class HomepageController {

    def home_DF() { check("DF") }
    def home_TF() { check("TF") }
    def home_OB() { check("OB") }
    def home_REG() { check("REG") }

    def check(String type){
        if (session.usertype != type){
                flash.message="Errore: login non effettuato correttamente"
                session.user=null
                session.usertype=null
                redirect (action: "login", controller: "login")
        }
    }
}
