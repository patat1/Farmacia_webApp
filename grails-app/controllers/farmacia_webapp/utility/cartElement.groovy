package farmacia_webapp.utility

class cartElement{
    private int quantity
    private float price
    private int id

    boolean getRecipe() {
        return recipe
    }

    void setRecipe(boolean recipe) {
        this.recipe = recipe
    }
    boolean recipe

    int getId() {
        return id
    }

    void setId(int id) {
        this.id = id
    }

    cartElement(int id, int quantity, float price, boolean recipe){
        this.id=id
        this.quantity=quantity
        this.price=price
        this.recipe=recipe
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