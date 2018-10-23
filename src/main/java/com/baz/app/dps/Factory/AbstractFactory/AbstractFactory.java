package com.baz.app.dps.Factory.AbstractFactory;

import com.baz.app.dps.Factory.Shape;

public abstract class AbstractFactory {

    abstract Color getColor(String color);
    abstract Shape getShape(String shape);

}
