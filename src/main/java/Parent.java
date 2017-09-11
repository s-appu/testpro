public class Parent {

    private String name = "swaroop";

    public Parent() {
        System.out.println( "logging this from parent constructor " + this );
        this.doSomething();
        this.doAnotherThing1();
        System.out.println( this.name );
    }

    private void doSomething() {
        System.out.println( "Doing something at parent - " + this );
    }

    public void doAnotherThing1() {
        System.out.println( "do another 1 parent" );
    }
}
