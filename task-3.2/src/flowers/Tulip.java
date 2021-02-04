package flowers;

public class Tulip extends Flower{
    public Tulip(String color,int price){
        setColor(color);
        setPrice(price);
    }

    @Override
    public String toString() {
        return "Tulip{"+"price="+getPrice()+ ", color='"+getColor()+'}';
    }
}
