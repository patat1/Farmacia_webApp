package farmacia_webapp.prodotti

import farmacia_webapp.Prodotto

class ProductEditorController {

    def adder() {
        check()
    }

    def listProducts() {
        check()
    }

    def buyProducts() {}

    def check(){
        if (session.usertype != "TF"){
            flash.message="Errore: login come Titolare non effettuato"
            session.user=null
            session.usertype=null
            redirect (action: "login", controller: "login")
        }
    }

    def addPROD = {
        flash.message=""
        if (params.nome=="" || params.codice=="" || params.prezzo==""){
            flash.message= flash.message + "Errore: Riempire tutti i campi"
            redirect(action: "adder")
        }
        if (Prodotto.executeQuery("from Prodotto where codice = ? AND utenteTF_FK = ?", [params.codice, session.user])){
            flash.message= flash.message + "Errore: il prodotto inserito esiste già"
            redirect(action: "adder")
        }
        if (flash.message==""){
            session.newuser= params.nomef//usato per la conferma
            new Prodotto(
                    nome: params.nome,
                    codice: params.codice,
                    prezzo: params.prezzo,
                    dispon: 0,
                    tipo: params.ricetta,
                    utenteTF_FK: session.user).save()
            flash.message="Prodotto aggiunto: " + params.nome
            redirect(action: "adder")
        }
    }

    def orderPROD = {
        int qt = Integer.parseInt(params.quantity)
        Prodotto.executeUpdate("update Prodotto set dispon = dispon + ? where codice = ? AND utenteTF_FK = ?", [qt, params.barcode, session.user])
        flash.message="Prodotto aggiornato: " +
                Prodotto.executeQuery("from Prodotto where codice = ? AND utenteTF_FK = ?", [params.barcode, session.user]).get(0).getNome()
        redirect(action: "listProducts")
    }

    def buyPROD = {
        if (session.cart==null){
            def cart = new ArrayList()
            session.cart=cart
        }
        def elem = new String[3]
        elem[0]=params.quantity
        elem[1]=params.barcode
        elem[2]=params.price
        session.cart.add(elem)
        flash.message="Prodotto aggiunto: " +
                Prodotto.executeQuery("from Prodotto where codice = ? AND utenteTF_FK = ?", [params.barcode, session.farmacia]).get(0).getNome()
        redirect(action: "buyProducts")
    }
}
