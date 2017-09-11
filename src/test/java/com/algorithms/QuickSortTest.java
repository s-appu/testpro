package com.algorithms;

import java.util.Arrays;

import org.junit.Test;

public class QuickSortTest {

    @Test
    public void testQuickSort() {
        final int[] arr = this.generateRandomArray( 10 );
        System.out.println( "Starting quick sort now " );
        System.out.println( Arrays.toString( arr ) );
        final QuickSort qSort = new QuickSort();
        qSort.sort( arr );
    }

    private int[] generateRandomArray( final int size ) {
        final int[] array = new int[size];
        for ( int i = 0; i < size; i++ ) {
            array[i] = (int) ( Math.random() * 50 ) + 10;
        }
        return array;
    }
}