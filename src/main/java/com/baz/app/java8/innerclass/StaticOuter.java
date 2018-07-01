package com.baz.app.java8.innerclass;

class StaticOuter {
    private static int x = 24;
  
    static class StaticInner {
      public void printSomething() {
        System.out.println("The value of x in my outer is " + x);
      }
    }
}