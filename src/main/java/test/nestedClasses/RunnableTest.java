package test.nestedClasses;

public class RunnableTest {

    public static void main( final String args[] ) {
        System.out.println( "=========== Runnable Test ===========" );
        final RunnableTest rt = new RunnableTest();

        final Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println( "Hello, m the anonymous runnable" );
            }

        };

        final Runnable r2 = () -> System.out.println( "Hello, m the lamda runnable" );

        r1.run();
        r2.run();
    }
}
