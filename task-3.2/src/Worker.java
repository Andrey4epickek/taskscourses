import flowers.Flower;

import java.util.Collection;
import java.util.Collections;

public class Worker {
    public Bouquet createBouquet(Flower...flowers){
        Bouquet bouquet=new Bouquet();
        Collections.addAll(bouquet.getFlowers(),flowers);
        bouquet.setPrice(calculatePrice(bouquet));
        return bouquet;
    }

    public void addFlower(Bouquet bouquet,Flower flower){
        bouquet.getFlowers().add(flower);
        int price =bouquet.getPrice()+ flower.getPrice();
        bouquet.setPrice(price);
    }

    public void removeFlower(Bouquet bouquet,Flower flower){
        bouquet.getFlowers().remove(flower);
        int price=bouquet.getPrice()-flower.getPrice();
        bouquet.setPrice(price);
    }

    private int calculatePrice(Bouquet bouquet){
        return bouquet.getFlowers().stream()
                .map(Flower::getPrice)
                .mapToInt(x->x)
                .sum();
    }

    public void printBouquet(Bouquet bouquet){
        System.out.println(bouquet);
        System.out.println("Количество цветов в букете - "+bouquet.getFlowers().size());
        System.out.println("Стоимость букета - "+bouquet.getPrice());
    }
}
