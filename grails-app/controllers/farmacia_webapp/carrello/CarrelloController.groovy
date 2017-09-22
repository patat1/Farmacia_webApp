package farmacia_webapp.carrello

import farmacia_webapp.Acquisto
import farmacia_webapp.Confezione
import farmacia_webapp.InScontrino

import java.text.SimpleDateFormat

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
            if (product.getId()==Integer.parseInt(params.id)){
                deleteFromCart(product.getId(), product.getQuantity())
                deleteMe=product
            }
        }
        session.cart.remove(deleteMe)
        flash.message="Prodotto eliminato"
        redirect(action: "index")
    }

    def buyPROD = {
        if (session.cart!=null){
            for (def prodotto : session.cart){
                if (prodotto.getRecipe()){
                    flash.message="Attenzione: Ricetta non registrata per alcuni prodotti"
                    redirect(action: "index")
                }
                else
                    redirect(action: "completePurchase")
            }
        }
    }

    def completePurchase = {
        Date dt = new Date()
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm")
        String currentTime = sdf.format(dt)
        new Acquisto(
                data: currentTime,
                idUtente: session.user
        ).save()
        int id_acquisto = Acquisto.executeQuery("from Acquisto where data = ? and idUtente = ?", [currentTime, session.user]).get(0).getId()
        for (def prodotto : session.cart){
            new InScontrino(
                    idAcquisto: id_acquisto,
                    idProdotto: prodotto.getId(),
                    quantità: prodotto.getQuantity()
            ).save()
        }
        session.cart.clear()
        flash.message="Acquisto completato!"
        redirect(action: "index")
    }
}
