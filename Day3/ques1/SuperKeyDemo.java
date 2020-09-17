class A { 
   A() {
       System.out.println("A() constructor");
   }
}
class B extends A {
   
    B(int z) {
        this(); // B()
        System.out.println("B(int) constructor");
    }
    B() {
        System.out.println("B() constructor");
    }
}
class SuperKeyDemo {
    public static void main(String[] args) {
        B b = new B(40);
    }
}
