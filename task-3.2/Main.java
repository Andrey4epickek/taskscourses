package com.company;
class  Flower{
    double price;
    String name;
    String color;
    static double total;

    double GetPrice(){
        return price;
    }

    double GetTotal(){
        return total;
    }
}

class Rouse extends Flower{
    Rouse(double price, String name, String color){
        this.price = price;
        this.name = name;
        this.color = color;
        total += price;
    }
}
class Violet extends Flower{
    Violet(double price, String name, String color){
        this.price = price;
        this.name = name;
        this.color = color;
        total += price;
    }
}
class Tulip extends Flower{
    Tulip(double price, String name, String color){
        this.price = price;
        this.name = name;
        this.color = color;
        total += price;
    }
}

public class Main {

    public static void main(String[] args) {
        double total = 0;
        Rouse rouse1 = new Rouse(6, "Роза", "Красная");
        Rouse rouse2 = new Rouse(6.5, "Роза", "Зеленая");
        Violet violet1 = new Violet(7.5, "Фиалка", "Желтая");
        Tulip tulip1 = new Tulip(4.5, "Тюльпан", "Красный");
        Violet violet2 = new Violet(9, "Фиалка", "Белая");
        System.out.println("Цена букета : " + Flower.total + " рублей");
    }
}
