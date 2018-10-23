package com.baz.app.dps.Factory.AbstractFactory;

import com.baz.app.dps.Factory.Rectangle;
import com.baz.app.dps.Factory.Shape;
import com.baz.app.dps.Factory.Square;
import com.baz.app.dps.Factory.Circle;

public class ShapeFactory extends AbstractFactory {

    @Override
    public Shape getShape(String shapeType){

        if(shapeType == null){
            return null;
        }

        if(shapeType.equalsIgnoreCase("CIRCLE")){
            return new Circle();

        }else if(shapeType.equalsIgnoreCase("RECTANGLE")){
            return new Rectangle();

        }else if(shapeType.equalsIgnoreCase("SQUARE")){
            return new Square();
        }

        return null;
    }

    @Override
    Color getColor(String color) {
        return null;
    }

}
