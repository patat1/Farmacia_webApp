package farmacia_webapp.carrello

import farmacia_webapp.Confezione
import farmacia_webapp.Prodotto
import farmacia_webapp.utility.cartElement

class CarrelloController {

    def index() { }

    def deleteFromCart(int code, int quantity) {
        Confezione.executeUpdate("update Confezione set quantità = quantità + ? where idProdotto = ? AND idFarmacia = ?", [quantity, code, session.farmacia])
    }

    def emptyCart = {
        if (session.cart!=null){
            for (def prodotto : session.cart){
                deleteFromCart(prodotto.getId(), prodotto.getQuantity())
            }
            session.cart.clear()
            flash.message="Carrello svuotato"
        }
        redirect(action: "index")
    }

    def deletePROD = {
        def deleteMe
        for (def product : session.cart){
            if (product.getId()==params.id){
                deleteFromCart(params.id, product.getQuantity())
                deleteMe=product
            }
        }
        session.cart.remove(deleteMe)
        flash.message="Prodotto eliminato"
        redirect(action: "index")
    }
}
