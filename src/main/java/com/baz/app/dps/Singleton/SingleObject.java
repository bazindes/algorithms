package com.baz.app.dps.Singleton;

public class SingleObject {

    private static SingleObject ourInstance = new SingleObject();

    public static SingleObject getInstance() {
        return ourInstance;
    }

    private SingleObject() { }

    public void showMessage(){
        System.out.println("Hello World!");
    }
}
