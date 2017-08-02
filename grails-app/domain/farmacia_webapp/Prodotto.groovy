package farmacia_webapp

class Prodotto {

    String nome
    String codice
    //codice identificativo(codice a barre)
    boolean tipo
    //tipo: ricetta=true
    String prezzo
    int dispon
    //disponibilità
    String utenteTF_FK
    //chiave esterna del titolare della farmacia

    static constraints = {
    }
}
