package com.company;

public class Tank implements IProduct{
   private IProductPart body;
   private IProductPart tower;
   private IProductPart engine;

    @Override
    public void installFirstPart(IProductPart first) {
        if (body instanceof ProductBody){
            setBody(body);
        }
    }

    @Override
    public void installSecondPart(IProductPart second) {
        if (second instanceof ProductEngine){
            setEngine(second);
        }
    }

    @Override
    public void installThirdPart(IProductPart third) {
        if (third instanceof ProductTower){
            setTower(third);
        }
    }

    public IProductPart getBody() {
        return body;
    }

    public void setBody(IProductPart body) {
        this.body = body;
    }

    public IProductPart getTower() {
        return tower;
    }

    public void setTower(IProductPart tower) {
        this.tower = tower;
    }

    public IProductPart getEngine() {
        return engine;
    }

    public void setEngine(IProductPart engine) {
        this.engine = engine;
    }
}
