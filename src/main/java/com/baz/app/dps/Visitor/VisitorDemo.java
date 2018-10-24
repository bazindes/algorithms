package com.baz.app.dps.Visitor;

public class VisitorDemo {

    public static void test(){
        ComputerPart computer = new Computer();
        computer.accept(new ComputerPartDisplayVisitor());
    }

}
