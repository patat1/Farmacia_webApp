package farmacia_webapp.carrello

import farmacia_webapp.Prodotto
import farmacia_webapp.prodotti.ProductEditorController

class CarrelloController {

    def index() { }

    def deleteFromCart(String code, int quantity) {
        Prodotto.executeUpdate("update Prodotto set dispon = dispon + ? where codice = ? AND utenteTF_FK = ?", [quantity, code, session.farmacia])
    }

    def emptyCart = {
        if (session.cart!=null){
            for (def prodotto : session.cart){
                deleteFromCart(prodotto.getBarcode(), prodotto.getQuantity())
                session.cart.remove(prodotto)
            }
            session.cart=null
            flash.message="Carrello svuotato"
        }
        redirect(action: "index")
    }

    def deletePROD = {
        for (def prodotto : session.cart){
            if (prodotto.getBarcode()==params.barcode){
                deleteFromCart(params.barcode, prodotto.getQuantity())
                session.cart.remove(prodotto)
            }
        }
        flash.message="Prodotto eliminato"
        redirect(action: "index")
    }
}
