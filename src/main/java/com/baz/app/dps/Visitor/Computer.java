package com.baz.app.dps.Visitor;

public class Computer implements ComputerPart {

    ComputerPart[] parts;

    public Computer(){
        parts  = new ComputerPart[]{
                new Keyboard(),
                new Monitor(),
                new Mouse()
        };
    }

    @Override
    public void accept(ComputerPartVisitor computerPartVisitor) {
        for (ComputerPart p : parts){
            p.accept(computerPartVisitor);
        }
        computerPartVisitor.visit(this);
    }
}
