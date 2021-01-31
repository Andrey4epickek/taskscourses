package com.company;

public class AssemblyLine implements IAssemblyLine{



    public IProduct assembleProduct(IProductPart buildProductPart, IProductPart buildProductPart1, IProductPart buildProductPart2) {
        IProduct tank =new Tank();
        tank.installFirstPart(buildProductPart);
        System.out.println("Install body");
        tank.installSecondPart(buildProductPart1);
        System.out.println("Install engine");
        tank.installThirdPart(buildProductPart2);
        System.out.println("Install tower");
        System.out.println("This is done");
        return tank;
    }

    @Override
    public IProduct assembleProduct(IProduct product) {
        return null;
    }
}
