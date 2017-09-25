package farmacia_webapp.utility

class recipeElement {
    private int idProd, idMedico
    private String data, codice

    recipeElement(int idProd, int idMedico, String data, String codice) {
        this.idProd = idProd
        this.idMedico = idMedico
        this.data = data
        this.codice=codice
    }

    String getCodice() {
        return codice
    }

    int getIdProd() {
        return idProd
    }

    int getIdMedico() {
        return idMedico
    }

    String getData() {
        return data
    }
}