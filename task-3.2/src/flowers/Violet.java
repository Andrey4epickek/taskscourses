package flowers;

public class Violet extends Flower{
    public Violet(String color,int price){
        setColor(color);
        setPrice(price);
    }

    @Override
    public String toString() {
        return "Violet{"+"price="+getPrice()+ ", color='"+getColor()+'}';
    }
}
