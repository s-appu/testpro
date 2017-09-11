package test.some;

public class TestBooleans {

    public static void main( final String args[] ) {

        final String str = true == false ? "abc" : true == true ? "111" : "123";

        System.out.println( str );

    }
}
