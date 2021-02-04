package flowers;

public class Rose extends Flower{
    public Rose(String color,int price){
        setColor(color);
        setPrice(price);
    }

    @Override
    public String toString() {
        return "Rose{"+"price="+getPrice()+ ", color='"+getColor()+'}';
    }
}
