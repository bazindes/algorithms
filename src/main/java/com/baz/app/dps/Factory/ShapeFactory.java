package com.baz.app.dps.Factory;

public class ShapeFactory {

    public Shape getShape(String shape) {

        if("square".equals(shape))
            return new Square();
        if("rectangle".equals(shape))
            return new Rectangle();
        if("circle".equals(shape))
            return new Circle();
        return null;

    }

    public void test(ShapeFactory shapeFactory){

        Shape rec = shapeFactory.getShape("rectangle");
        rec.draw();
        Shape cir = shapeFactory.getShape("circle");
        cir.draw();
        Shape squ = shapeFactory.getShape("square");
        squ.draw();

    }

}
