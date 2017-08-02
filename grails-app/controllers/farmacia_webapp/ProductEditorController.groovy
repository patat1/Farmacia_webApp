package farmacia_webapp

class ProductEditorController {

    def adder() {
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
        if (Prodotto.executeQuery("from Prodotto where codice = ? and utenteTF_FK = ?", [params.codice, session.user])){
            flash.message= flash.message + "Errore: il prodotto inserito esiste già"
            redirect(action: "subscribeTF")
        }
        if (flash.message==""){
            session.newuser= params.nomef//usato per la conferma
            new Prodotto(
                    nome: params.nome,
                    codice: params.codice,
                    prezzo: params.prezzo,
                    dispon: 0,
                    tipo: true,
                    utenteTF_FK: session.user).save()
            flash.message="Prodotto aggiunto: " + params.nome
            redirect(action: "adder")
        }
    }
}
