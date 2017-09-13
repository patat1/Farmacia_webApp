package farmacia_webapp.utility

class cartElement{
    int quantity
    float price
    String barcode

    String getBarcode() {
        return barcode
    }

    void setBarcode(String barcode) {
        this.barcode = barcode
    }

    cartElement(String barcode, int quantity, float price){
        this.barcode=barcode
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