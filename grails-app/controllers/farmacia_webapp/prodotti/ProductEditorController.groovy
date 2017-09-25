package farmacia_webapp.prodotti

import farmacia_webapp.Confezione
import farmacia_webapp.Prodotto
import farmacia_webapp.utility.cartElement

class ProductEditorController {

    def adder() {
        check("REG")
    }

    def listProducts() {
        check("TF")
    }

    def buyProducts() {}

    def check(String type){
        if (session.usertype != type){
            flash.message="Errore: login non effettuato correttamente"
            session.user=null
            session.usertype=null
            redirect (action: "login", controller: "login")
        }
    }

    def addPROD = {
        flash.message=""
        if (params.nome=="" || params.codice=="" || params.prezzo==""){
            flash.message= "Errore: Riempire tutti i campi"
            redirect(action: "adder")
        }
        else if (Prodotto.executeQuery("from Prodotto where barcode = ?", [params.codice])){
            flash.message= "Errore: il prodotto inserito è già presente nel database"
            redirect(action: "adder")
        }
        else{
            new Prodotto(
                    nome: params.nome,
                    barcode: params.codice,
                    prezzo: params.prezzo,
                    ricetta: params.ricetta,).save()
            flash.message="Prodotto aggiunto: " + params.nome
            redirect(action: "adder")
        }
    }

    def orderPROD = {
        int qt = Integer.parseInt(params.quantity)
        if (Confezione.executeQuery("from Confezione where idProdotto = ? and idFarmacia = ?", [Integer.parseInt(params.prodotto), session.farmacia]).size!=0)
            Confezione.executeUpdate("update Confezione set quantità = quantità + ? where idProdotto = ? AND idFarmacia = ?", [qt, Integer.parseInt(params.prodotto), session.farmacia])
        else {
            new Confezione(
                    idProdotto: Integer.parseInt(params.prodotto),
                    idFarmacia: session.farmacia,
                    quantità: qt
            ).save()
        }
        flash.message="Prodotto ordinato"
        redirect(action: "listProducts")
    }

    def buyPROD = {
        def e, delete
        if (session.cart==null){
            def cart = new ArrayList<cartElement>()
            session.cart=cart
        }
        for (def prod : session.cart)
            if (prod.getId()==Integer.parseInt(params.id)){
                e = new cartElement(prod.getId(), Integer.parseInt(params.quantity) + prod.getQuantity(), prod.getPrice(), prod.getRecipe())
                delete=prod
            }
        if (e==null)
            e = new cartElement(Integer.parseInt(params.id), Integer.parseInt(params.quantity), Float.parseFloat(params.price), Boolean.parseBoolean(params.recipe))
        session.cart.remove(delete)
        session.cart.add(e)
        Confezione.executeUpdate("update Confezione set quantità = quantità - ? where idProdotto = ? AND idFarmacia = ?", [Integer.parseInt(params.quantity), Integer.parseInt(params.id), session.farmacia])
        flash.message="Prodotto aggiunto: " +
                Prodotto.executeQuery("from Prodotto where id = ?", [Integer.parseInt(params.id)]).get(0).getNome()
        redirect(action: "buyProducts")
    }


}
