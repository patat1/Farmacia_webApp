package farmacia_webapp.carrello

import farmacia_webapp.Acquisto
import farmacia_webapp.Confezione
import farmacia_webapp.InScontrino
import farmacia_webapp.Paziente
import farmacia_webapp.Ricetta

import java.text.SimpleDateFormat

class CarrelloController {

    def index() { }

    def deleteFromCart(int code, int quantity) {
        Confezione.executeUpdate("update Confezione set quantità = quantità + ? where idProdotto = ? AND idFarmacia = ?", [quantity, code, session.farmacia])
    }

    def deleteFromRecipe(int code) {
        def delete
        if (session.recipe!=null){
            for (def rec : session.recipe)
                if (rec.getIdProd()==code){
                    delete = rec
                }
            session.recipe.remove(delete)
        }
    }

    def emptyCart = {
        if (session.cart!=null){
            for (def prodotto : session.cart){
                deleteFromCart(prodotto.getId(), prodotto.getQuantity())
            }
            session.cart.clear()
            if (session.recipe!=null){
                session.recipe.clear()
                session.recipe=null
                session.customer=null
            }
            flash.message="Carrello svuotato"
        }
        redirect(action: "index")
    }

    def deletePROD = {
        def deleteMe
        for (def product : session.cart){
            if (product.getId()==Integer.parseInt(params.id)){
                deleteFromCart(product.getId(), product.getQuantity())
                deleteFromRecipe(product.getId())
                deleteMe=product
            }
        }
        session.cart.remove(deleteMe)
        if (session.cart.size()==0)
            session.customer=null
        flash.message="Prodotto eliminato"
        redirect(action: "index")
    }

    def buyPROD = {
        boolean warning = false
        if (session.cart!=null){
            for (def prodotto : session.cart) {
                if (prodotto.getRecipe()) {
                    warning = true
                }
            }
            if (warning){
                flash.message="Attenzione: Ricetta non registrata per alcuni prodotti"
                redirect(action: "index")
            } else
                redirect(action: "completePurchase")
        }
    }

    def completePurchase = {
        Date dt = new Date()
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd")
        String currentTime = sdf.format(dt)
        def customer
        if (session.customer!=null)
            customer = session.customer
        else
            customer = Paziente.executeQuery("from Paziente where codiceFiscale=?", ["X"]).get(0).getId()
        int id_acquisto = new Acquisto(
                data: currentTime,
                idUtente: session.user,
                idPaziente: customer
        ).save().getId()
        for (def prodotto : session.cart){
            new InScontrino(
                    idAcquisto: id_acquisto,
                    idProdotto: prodotto.getId(),
                    quantità: prodotto.getQuantity()
            ).save()
        }
        if (session.recipe!=null){
            for (def rec : session.recipe){
                def idInScontrino = InScontrino.executeQuery("from InScontrino where idProdotto = ? and idAcquisto = ?", [rec.getIdProd(), id_acquisto]).get(0).getId()
                new Ricetta(
                        idScontrino: idInScontrino,
                        idMedico: rec.getIdMedico(),
                        data: rec.getData(),
                        codiceRicetta: rec.getCodice()
                ).save()
            }
            session.recipe.clear()
            session.recipe=null
        }
        session.cart.clear()
        session.customer=null
        flash.message="Acquisto completato!"
        redirect(action: "index")
    }
}
