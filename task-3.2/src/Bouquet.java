import flowers.Flower;

import java.util.ArrayList;
import java.util.List;

public class Bouquet {
    private List<Flower> flowers=new ArrayList<>();
    private Integer price;

    public List<Flower> getFlowers() {
        return flowers;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Bouquet{"+"flowers="+flowers+", total price='"+price+'}';
    }
}
