package com.baz.app.dps.Template;

public class TemplateDemo {

    public static void test() {
        Game game = new Cricket();
        game.play();
        System.out.println();
        game = new Football();
        game.play();
    }

}
