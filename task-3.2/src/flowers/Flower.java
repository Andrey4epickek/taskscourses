package flowers;

public abstract class Flower {
    private Integer price;
    private String color;

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString(){
        return "Flower{"+"price="+price+ ", color='"+color+'}';
    }
}
