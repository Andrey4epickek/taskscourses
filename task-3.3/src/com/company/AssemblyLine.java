package com.company;

public class AssemblyLine implements IAssemblyLine{

    private ILineStep bodyLineStep;
    private ILineStep engineLineStep;
    private ILineStep towerLineStep;

    public AssemblyLine(){
        innitAssemblyLine();
    }

    @Override
    public IProduct assembleProduct(IProduct product) {
        product.installFirstPart(bodyLineStep.buildProductPart());
        System.out.println("Install body");
        product.installSecondPart(engineLineStep.buildProductPart());
        System.out.println("Install engine");
        product.installThirdPart(towerLineStep.buildProductPart());
        System.out.println("Install tower");
        System.out.println("This is done");
        return product;
    }
private void innitAssemblyLine(){
        bodyLineStep=new CreatureFirstPart();
        engineLineStep=new CreatureSecondPart();
        towerLineStep=new CreatureThirdPart();
}

}
