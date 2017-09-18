package farmacia_webapp.utility

class cartElement{
    int quantity
    float price
    int id

    String getId() {
        return id
    }

    void setId(int id) {
        this.id = id
    }

    cartElement(int id, int quantity, float price){
        this.id=id
        this.quantity=quantity
        this.price=price
    }

    int getQuantity() {
        return quantity
    }

    void setQuantity(int quantity) {
        this.quantity = quantity
    }

    float getPrice() {
        return price
    }

    void setPrice(float price) {
        this.price = price
    }
}