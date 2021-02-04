package com.company;

public class Main {

    public static void main(String[] args) {
    IProduct tank=new Tank();
	AssemblyLine tankline=new AssemblyLine();

	tankline.assembleProduct(tank);
	System.out.println("Work is done");
    }
}
