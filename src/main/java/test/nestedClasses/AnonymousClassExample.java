package test.nestedClasses;

public class AnonymousClassExample {

    public static void main( final String args[] ) {
        final AnonymousClassExample ex = new AnonymousClassExample();
        ex.runARunnable();

        ex.runMyRunnable();
    }

    public void runARunnable() {

        final Runnable a = new Runnable() {
            @Override
            public void run() {
                System.out.println( "Logging in Runnable" );
            }
        };

        final Thread t = new Thread( a );
        t.start();
    }

    public void runMyRunnable() {
        final AnonymousExample a = new AnonymousExample() {

            private String threadName;

            @Override
            public void run() {
                System.out.println( "Logging in Runnable of the thread - " + this.threadName );
            }

            @Override
            public void setThreadName( final String threadName ) {
                this.threadName = threadName;
            }
        };
        a.setThreadName( "My New Thread" );
        final Thread t = new Thread( a );
        t.start();
    }
}
