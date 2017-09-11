package test.datastructures.trees;

public class BinarySearchTree<T extends Comparable<T>> {

    private BTNode<T> root;

    public void insert( final T data ) {
        if ( data == null ) {
            return;
        }
        final BTNode<T> newNode = this.insert( this.root, data );
        if ( this.root == null ) {
            this.root = newNode;
        }
    }

    public boolean search( final T data ) {
        if ( data == null || this.root == null ) {
            return false;
        }
        return this.search( this.root, data );
    }

    // public boolean delete( final T data ) {
    // if ( data == null || this.root == null ) {
    // return false;
    // }
    // return this.delete( this.root, data );
    // }
    //
    // private BTNode<T> delete( final BTNode<T> node, final T data ) {
    // if ( node == null ) {
    // return node;
    // } else if ( data.compareTo( node.getData() ) <= 0 ) {
    // node.setLeft( this.delete( node.getLeft(), data ) );
    // } else {
    // node.setRight( this.delete( node.getRight(), data ) );
    // }
    //
    // if ( node.getLeft() == null && node.getRight() == null ) {
    // node = null;
    // } else if ( node.getLeft() == null ) {
    //
    // }
    //
    // return false;
    // }

    private boolean search( final BTNode<T> currentNode, final T data ) {
        if ( currentNode == null ) {
            return false;
        } else if ( currentNode.getData().equals( data ) ) {
            return true;
        } else if ( data.compareTo( currentNode.getData() ) <= 0 ) {
            return this.search( currentNode.getLeft(), data );
        } else {
            return this.search( currentNode.getRight(), data );
        }

    }

    private BTNode<T> insert( BTNode<T> currentNode, final T data ) {
        if ( currentNode == null ) {
            currentNode = this.getNewNode( data );
        } else if ( data.compareTo( currentNode.getData() ) <= 0 ) {
            currentNode.setLeft( this.insert( currentNode.getLeft(), data ) );
        } else {
            currentNode.setRight( this.insert( currentNode.getRight(), data ) );
        }

        return currentNode;

    }

    private BTNode<T> getNewNode( final T data ) {
        final BTNode<T> newNode = new BTNode<T>( data );
        return newNode;
    }

    BTNode<T> getNode( final T data ) {
        return null;
    }

    public static void main( final String args[] ) {

        final BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.insert( 15 );
        bst.insert( 10 );
        bst.insert( 20 );
        bst.insert( 25 );

        System.out.println( bst.search( 20 ) ? "FOUND" : "NOT FOUND" );
        System.out.println( bst.search( 21 ) ? "FOUND" : "NOT FOUND" );
    }
}
