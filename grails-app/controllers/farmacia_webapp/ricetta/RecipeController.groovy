package farmacia_webapp.ricetta

import farmacia_webapp.Medico
import farmacia_webapp.Paziente
import farmacia_webapp.Utente
import farmacia_webapp.utility.recipeElement

class RecipeController {

    def index() { }

    def addRecipe = {
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
                        codiceFiscale: params.codfisc
                ).save()
                session.customer=Paziente.executeQuery("from Paziente where codiceFiscale = ?", [params.codfisc]).get(0).getId()
                recipeAdder()
            }
        }else{
            recipeAdder()
        }

    }

    def recipeAdder ={
        if (params.dataR=="" || params.codiceReg==""){
            flash.message="Errore: campi della ricetta incompleti"
            redirect (action: "index")
        }
        if (session.recipe==null){
            def r = new ArrayList<recipeElement>()
            session.recipe=r
        }
        def medico=Medico.executeQuery("from Medico where codiceRegionale=?", [params.codiceReg])
        if(medico.size()==0){
            flash.message="Errore: il medico non risulta registrato"
            redirect (action: "index")
        }
        def rec = new recipeElement(session.idRecipeProd,
                medico.get(0).getId(),
                params.dataR)
        session.recipe.add(rec)
        flash.message="Ricetta registrata"
        for (def c : session.cart)
            if(c.getId()==session.idRecipeProd)
                c.setRecipe(false)
        redirect (controller: "carrello", action: "index")
    }
}
