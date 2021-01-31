package com.company;

public class CreatureFirstPart implements ILineStep{
    @Override
    public IProductPart buildProductPart() {
        IProductPart body = new ProductBody("in34","green");
        System.out.println("Body made");
        return body;
    }
}
