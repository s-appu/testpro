package com.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

public class PowerSetTest {

    private static List<List<String>> createPowerSet( final LinkedList<String> originalSet ) {

        final List<List<String>> powerset = new LinkedList<>();

        if ( originalSet == null || originalSet.size() == 0 ) {
            final List<String> nullSet = new LinkedList<>();
            powerset.add( nullSet );
        } else {
            final String firstElement = originalSet.removeFirst();
            final List<List<String>> previousPowerset = createPowerSet( originalSet );
            powerset.addAll( previousPowerset );

            for ( final List<String> list : previousPowerset ) {
                final List<String> newSet = new ArrayList<>( list );
                newSet.add( firstElement );
                powerset.add( newSet );
            }
        }
        return powerset;

    }

    @Test
    public void testingPowerset() {
        // final char[] set = { 'a', 'b', 'c'};
        final LinkedList<String> input = new LinkedList<>( Arrays.asList( "a", "b", "c", "d" ) );
        final List<List<String>> powerSet = createPowerSet( input );
        System.out.println( powerSet );
        System.out.println( powerSet.size() );
    }

    @Test
    public void testPowerSet() {
        // final char[] set = { 'a', 'b', 'c'};
        final LinkedList<String> input = new LinkedList<>( Arrays.asList( "a", "b", "c" ) );
        final List<List<String>> powerSet = PowerSet.powerset( input );
        System.out.println( powerSet );
        System.out.println( powerSet.size() );
    }

    @Test
    public void testMyPowerSet() {
        // final char[] set = { 'a', 'b', 'c'};
        final int[] input = {
                1,
                2,
                3
        };
        final List<int[]> powerSet = PowerSet.myPowerSet( input );
        System.out.println( powerSet );
        System.out.println( powerSet.size() );
    }

    @Test
    public void printLeftShift() {
        final String space = " ";
        for ( int count = 0; count < 5; count++ ) {
            final StringBuilder sb = new StringBuilder();
            for ( int i = 1; i <= 10; i++ ) {
                sb.append( i << count );
                sb.append( space );
            }
            System.out.println( " Left Shift By count -- " + sb.toString() );
        }
    }

    @Test
    public void printRightShift() {
        final String space = " ";
        for ( int count = 1; count < 5; count++ ) {
            final StringBuilder sb = new StringBuilder();
            for ( int i = 1; i <= 80; i++ ) {
                sb.append( i >> count );
                sb.append( space );
            }
            System.out.println( " Right Shift By " + count + " -- " + sb.toString() );
        }
    }
}
