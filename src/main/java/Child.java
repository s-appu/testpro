
public class Child extends Parent {

    private String address = "address1";

    Child() {
        super();
        this.doAnotherThing1();
        System.out.println( "logging this from child constructor " + this );
    }

    private void doSomething() {
        System.out.println( "Doing something at Child" );
    }

    @Override
    public void doAnotherThing1() {
        System.out.println( "do another 1 child" );
    }

    public void doAnotherThing2() {

    }
}
