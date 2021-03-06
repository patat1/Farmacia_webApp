package farmacia_webapp.ricetta

import farmacia_webapp.Medico
import farmacia_webapp.Paziente
import farmacia_webapp.Utente
import farmacia_webapp.utility.recipeElement

class RecipeController {

    def index() { check() }

    def check(){
        if (session.usertype == null || session.user == null){
            flash.message="Errore: login non effettuato correttamente"
            session.user=null
            session.usertype=null
            redirect (action: "login", controller: "login")
        }
    }

    def addRecipe = {
        //Il cliente viene registrato solo la prima volta, fino al termine dell'aquisto
        if (session.customer==null){
            if (params.nome=="" || params.cognome=="" || params.data=="" || params.codfisc==""){
                flash.message="Errore: campi dell'utente incompleti"
                redirect (action: "index")
            }
            def pazienti = Paziente.executeQuery("from Paziente where codiceFiscale = ?", [params.codfisc])
            if (pazienti.size()!=0)
                session.customer=pazienti.get(0).getId()
            else{
                new Paziente(
                        nome: params.nome,
                        cognome: params.cognome,
                        dataNascita: params.data,
                        codiceFiscale: params.codfisc,
                        idUtente: session.user
                ).save()
                session.customer=Paziente.executeQuery("from Paziente where codiceFiscale = ?", [params.codfisc]).get(0).getId()
            }
        }
        //controllo medico+ricetta
        if (params.dataR=="" || params.codiceReg==""){
            flash.message="Errore: campi della ricetta incompleti"
            redirect (action: "index")
        }
        if (session.recipe==null){
            session.recipe = new ArrayList<recipeElement>()
        }
        def medico = Medico.executeQuery("from Medico where codiceRegionale=?", [params.codiceReg])
        if(medico.size()>0 || medico!=null){
            session.recipe.add(new recipeElement(
                    Integer.parseInt(params.idRecipeProd),
                    medico.get(0).getId(),
                    params.dataR, params.numRec))
            for (def c : session.cart)
                if(c.getId()==Integer.parseInt(params.idRecipeProd))
                    c.setRecipe(false)
            flash.message="Ricetta registrata"
            redirect (controller: "carrello", action: "index")
        }else {
            flash.message="Errore: il medico inserito non risulta registrato"
            redirect (action: "index")
        }
    }
}
