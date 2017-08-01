package farmacia_webapp

class Prodotto {

    String nome
    int codice
    //codice identificativo(codice a barre)
    String tipo
    //tipo: ricetta(RIC) o no(LIB)
    int dispon
    //disponibilità

    static constraints = {
    }
}
