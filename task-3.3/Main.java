package com.company;

public class Main {

    public static void main(String[] args) {
	AssemblyLine tankline=new AssemblyLine();
	CreatureFirstPart body = new CreatureFirstPart();
	CreatureSecondPart engine =new CreatureSecondPart();
	CreatureThirdPart tower = new CreatureThirdPart();
	tankline.assembleProduct(body.buildProductPart(), engine.buildProductPart(), tower.buildProductPart());
	System.out.println("Work is done");
    }
}
