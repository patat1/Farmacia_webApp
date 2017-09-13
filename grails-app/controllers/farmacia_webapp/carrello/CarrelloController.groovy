package farmacia_webapp.carrello

import farmacia_webapp.Prodotto
import farmacia_webapp.utility.cartElement

class CarrelloController {

    def index() { }

    def deleteFromCart(String code, int quantity) {
        Prodotto.executeUpdate("update Prodotto set dispon = dispon + ? where codice = ? AND utenteTF_FK = ?", [quantity, code, session.farmacia])
    }

    def emptyCart = {
        if (session.cart!=null){
            for (def prodotto : session.cart){
                deleteFromCart(prodotto.getBarcode(), prodotto.getQuantity())
            }
            session.cart.clear()
            flash.message="Carrello svuotato"
        }
        redirect(action: "index")
    }

    def deletePROD = {
        def deleteMe
        for (def product : session.cart){
            if (product.getBarcode()==params.barcode){
                deleteFromCart(params.barcode, product.getQuantity())
                deleteMe=product
            }
        }
        session.cart.remove(deleteMe)
        flash.message="Prodotto eliminato"
        redirect(action: "index")
    }
}
