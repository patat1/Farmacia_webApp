import farmacia_webapp.Farmacia
import farmacia_webapp.Paziente
import farmacia_webapp.Utente

class BootStrap {

    def init = { servletContext ->
        if (Utente.count() == 0) {
            new Utente(
                    id: 1,
                    nome: "Regione",
                    password: "reg",
                    cognome: "Lombardia",
                    username: "RegioneLombardia@REG",
                    tipo: "REG",
                    idFarmacia: 1).save()
        }
        if (Farmacia.count() == 0) {
            new Farmacia(
                    id: 1,
                    nome: "X",
                    numtel: "X",
                    via: "X").save()
        }
        if (Paziente.count() == 0) {
            new Paziente(
                    id: 1,
                    nome: "X",
                    cognome: "X",
                    codiceFiscale: "X",
                    dataNascita: "X",
                    idUtente: 0).save()
        }
    }
    def destroy = {
    }
}
