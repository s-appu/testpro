package test.generics;

public class Node<T extends Integer> {

    T t;

    public Node( final T t ) {
        this.t = t;
    }

    public void setData( final T object ) {
        System.out.println( "Node.setData " );
        this.t = object;

    }

}
