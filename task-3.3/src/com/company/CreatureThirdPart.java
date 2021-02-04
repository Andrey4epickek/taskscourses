package com.company;

public class CreatureThirdPart implements ILineStep{
    @Override
    public IProductPart buildProductPart() {
        IProductPart tower = new ProductTower("id57","green");
        System.out.println("Tower made");
        return tower;
    }
}