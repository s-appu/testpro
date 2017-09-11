package test.some;

public interface TestInterface8 {
    void test1( String name );

    default void test2( final String name ) {
        System.out.println( "Calling Interface test2 with name " + name );
    }
}

class TestClass8 implements TestInterface8 {

    @Override
    public void test1( final String name ) {
        System.out.println( "Calling test1 with name - " + name );
    }

    @Override
    public void test2( final String name ) {
        System.out.println( "Calling Class test2 with name " + name );
    }
}

class TestClassMain {
    public static void main( final String args[] ) {
        final TestInterface8 ti = new TestClass8();

        ti.test1( "test1 name" );
        ti.test2( "test2 name" );
    }
}