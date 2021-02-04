package com.company;

public class CreatureSecondPart implements ILineStep {
    @Override
    public IProductPart buildProductPart() {
        IProductPart engine = new ProductEngine("is57",350);
        System.out.println("Engine made");
        return engine;
    }
}