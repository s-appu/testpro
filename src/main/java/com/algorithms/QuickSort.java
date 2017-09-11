package com.algorithms;

import java.util.Arrays;

public class QuickSort {

    int[] theArray;
    int arraySize;

    public QuickSort() {

    }

    public void sort( final int arr[] ) {

        this.theArray = arr;

        this.arraySize = this.theArray.length;

        this.quickSort( 0, arr.length - 1 );

        System.out.println( Arrays.toString( arr ) );
    }

    private void quickSort( final int left, final int right ) {
        if ( right - left <= 0 ) {
            return;
        }
        final int pivot = this.theArray[right];

        System.out.println( "Value in the right " + this.theArray[right] + " is made the pivot" );

        System.out.println( "left = " + left + " right = " + right + " pivot = " + pivot + " sent to the partitiion" );

        final int pivotLocation = this.partitionArray( left, right, pivot );

        System.out.println( " Value in the left " + this.theArray[left] + " is made the pivot" );

        this.quickSort( left, pivotLocation - 1 );
        this.quickSort( pivotLocation + 1, right );
    }

    public int partitionArray( final int left, final int right, final int pivot ) {

        int leftPointer = left - 1;
        int rightPointer = right;

        while ( true ) {

            while ( this.theArray[++leftPointer] < pivot ) {
                ;
            }

            QuickSortHelper.printHorzArray( this.theArray, leftPointer, rightPointer );

            System.out.println( this.theArray[leftPointer] + " in index " + leftPointer + " is bigger than the pivot value  " + pivot );

            while ( rightPointer > 0 && this.theArray[--rightPointer] > pivot ) {
                ;
            }

            QuickSortHelper.printHorzArray( this.theArray, leftPointer, rightPointer );

            System.out.println( this.theArray[rightPointer] + " in index " + rightPointer + " is smaller than the pivot value  " + pivot );

            QuickSortHelper.printHorzArray( this.theArray, leftPointer, rightPointer );

            if ( leftPointer >= rightPointer ) {

                System.out.println( "left >= right so start again" );

                break;

            } else {

                QuickSortHelper.swapValues( this.theArray, leftPointer, rightPointer );

                System.out.println( this.theArray[leftPointer] + " was swapped for " + this.theArray[rightPointer] );
            }

        }

        QuickSortHelper.swapValues( this.theArray, leftPointer, right );

        return leftPointer;
    }
}

class Partitioning {

    int arraySize;
    int[] theArray;

    public Partitioning( final int[] theArray ) {
        this.theArray = theArray;
        this.arraySize = theArray.length;
    }

    public void partitionArray( final int pivot ) {

        int leftPointer = -1;
        int rightPointer = this.arraySize;

        while ( true ) {
            while ( leftPointer < this.arraySize - 1 && this.theArray[++leftPointer] < pivot ) {
                ;
            }

            QuickSortHelper.printHorzArray( this.theArray, leftPointer, rightPointer );

            System.out.println( this.theArray[leftPointer] + " in index " + leftPointer + " is bigger than the pivot value  " + pivot );

            while ( rightPointer > 0 && this.theArray[--rightPointer] > pivot ) {
                ;
            }

            QuickSortHelper.printHorzArray( this.theArray, leftPointer, rightPointer );

            System.out.println( this.theArray[rightPointer] + " in index " + rightPointer + " is smaller than the pivot value  " + pivot );

            if ( leftPointer >= rightPointer ) {
                break;
            } else {
                QuickSortHelper.swapValues( this.theArray, leftPointer, rightPointer );

                System.out.println( this.theArray[leftPointer] + " was swapped for " + this.theArray[rightPointer] );
            }

            System.out.println( Arrays.toString( this.theArray ) );
        }
    }

}

class QuickSortHelper {

    public static void swapValues( final int[] array, final int indexOne, final int indexTwo ) {
        final int temp = array[indexOne];
        array[indexOne] = array[indexTwo];
        array[indexTwo] = temp;
    }

    static void printHorzArray( final int[] theArray, final int i, final int j ) {
        final int arraySize = theArray.length;
        for ( int n = 0; n < 61; n++ ) {
            System.out.print( "-" );
        }
        System.out.println();
        for ( int n = 0; n < arraySize; n++ ) {
            System.out.format( "| %2s " + " ", n );
        }
        System.out.println( "|" );
        for ( int n = 0; n < 61; n++ ) {
            System.out.print( "-" );
        }
        System.out.println();
        for ( int n = 0; n < arraySize; n++ ) {
            System.out.print( String.format( "| %2s " + " ", theArray[n] ) );
        }
        System.out.println( "|" );
        for ( int n = 0; n < 61; n++ ) {
            System.out.print( "-" );
        }
        System.out.println();
        if ( i != -1 ) {
            // Number of spaces to put before the F
            final int spacesBeforeFront = 6 * ( i + 1 ) - 5;
            for ( int k = 0; k < spacesBeforeFront; k++ ) {
                System.out.print( " " );
            }
            System.out.print( "L" + i );
            // Number of spaces to put before the R
            final int spacesBeforeRear = 5 * ( j + 1 ) - spacesBeforeFront;
            for ( int l = 0; l < spacesBeforeRear; l++ ) {
                System.out.print( " " );
            }
            System.out.print( "R" + j );
            System.out.println( "\n" );
        }
    }
}
