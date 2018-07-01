public class InnerClassExamples {
    public static void test() {
      InstanceOuter io = new InstanceOuter(12);
  
      // Is this a compile error?
      InstanceOuter.InstanceInner ii = io.new InstanceInner();
  
      // What does this print?
      ii.printSomething(); // prints 12
  
      // What about this?
      StaticOuter.StaticInner si = new StaticOuter.StaticInner();
      si.printSomething(); // prints 24
    }
    
    public static void testHello() {
        Hello h = new Hello();
        h.r.run();
    }
} 