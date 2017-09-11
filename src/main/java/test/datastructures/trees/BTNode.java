package test.datastructures.trees;

public class BTNode<T extends Comparable<T>> {

    private T data;
    private BTNode<T> left;
    private BTNode<T> right;

    public BTNode( final T data ) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public BTNode( final T data, final BTNode<T> left, final BTNode<T> right ) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public T getData() {
        return this.data;
    }

    public void setData( final T data ) {
        this.data = data;
    }

    public BTNode<T> getLeft() {
        return this.left;
    }

    public void setLeft( final BTNode<T> left ) {
        this.left = left;
    }

    public BTNode<T> getRight() {
        return this.right;
    }

    public void setRight( final BTNode<T> right ) {
        this.right = right;
    }

}
