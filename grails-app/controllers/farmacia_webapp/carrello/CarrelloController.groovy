package farmacia_webapp.carrello

class CarrelloController {

    def index() { }

    def emptyCart = {
        session.cart=null
        flash.message="Carrello svuotato"
        redirect(action: "index")
    }
}
