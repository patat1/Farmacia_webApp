package farmacia_webapp.login_subscribe

import farmacia_webapp.Utente


class LoginController {

    def login() { }
    def logout() { }

    def log_in = {
        Object info
        def result = Utente.executeQuery("from Utente where username=? AND password=?", [params.username, params.password])
        if(result.size()!=0) {
            session.user=result.get(0).getId()
            session.usertype=result.get(0).getTipo()
            session.userinfo=result.get(0).getNome()+" "+result.get(0).getCognome()
            if (session.usertype!="REG")
                session.farmacia=result.get(0).getIdFarmacia()
            switch (result.get(0).tipo){
                case "TF":
                    redirect(controller: 'homepage', action:'home_TF')
                    break
                case "DF":
                    redirect(controller: 'homepage', action:'home_DF')
                    break
                case "OB":
                    redirect(controller: 'homepage', action:'home_OB')
                    break
                case "REG":
                    redirect(controller: 'homepage', action:'home_REG')
                    break
            }
        }
        else{
            flash.message="Errore: utente o password errati. Riprovare"
            redirect(action: "login")
        }
    }

    def log_out = {
        session.user=null
        session.usertype=null
        redirect(uri:'/')
    }
}
