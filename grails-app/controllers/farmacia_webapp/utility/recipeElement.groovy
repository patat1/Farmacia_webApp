package farmacia_webapp.utility

class recipeElement {
    int idProd, idMedico
    String data

    recipeElement(int idProd, int idMedico, String data) {
        this.idProd = idProd
        this.idMedico = idMedico
        this.data = data
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