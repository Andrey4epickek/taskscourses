import flowers.Flower;
import flowers.Rose;
import flowers.Tulip;
import flowers.Violet;


public class FlowerShop {
    private static Worker worker=new Worker();

    public static void main(String[] args) {
        Flower rose=new Rose("white",10);
        Flower tulip=new Tulip("yellow",20);
        Flower violet=new Violet("pink",30);

        Bouquet bouquet=worker.createBouquet(rose,tulip,violet);
        worker.printBouquet(bouquet);

        Flower redRose =new Rose("red",10);
        worker.addFlower(bouquet,redRose);
        worker.printBouquet(bouquet);

        worker.removeFlower(bouquet,redRose);
        worker.removeFlower(bouquet,new Rose("white",10));
        worker.printBouquet(bouquet);
    }
}
