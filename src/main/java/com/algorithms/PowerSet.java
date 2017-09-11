package com.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class PowerSet {

    public static void printPowerSets( final char set[] ) {
        final int n = set.length;

        final int i = 2;
        while ( true ) {
            System.out.println( i << n );
        }

        // for(int i=0; i < (i<<n); i++) {
        // System.out.println( i << n );
        // }

    }

    public static void printPowerSetsRecursively( final char set[] ) {

    }

    private static char[] powerSetRecursion( final Set<String> powerSet, final char set[] ) {
        powerSet.add( set.toString() );
        for ( final char element : set ) {
            final char[] subSet = Arrays.copyOfRange( set, 1, set.length );

        }
        return set;
    }

    public static List<List<String>> powerset( final LinkedList<String> originalSet ) {
        final List<List<String>> powerset = new LinkedList<List<String>>();
        // Base case: empty set
        if ( originalSet == null || originalSet.size() == 0 ) {
            final List<String> set = new ArrayList<String>();
            // System.out.println(set);
            powerset.add( set );
        } else {
            // Recursive case:
            final String firstElement = originalSet.removeFirst();
            final List<List<String>> prevPowerset = powerset( originalSet );
            powerset.addAll( prevPowerset );
            // Add firstElement to each of the set of the previuos powerset
            for ( final List<String> prevSet : prevPowerset ) {
                final List<String> newSet = new ArrayList<String>( prevSet );
                newSet.add( firstElement );
                // System.out.println(newSet);
                powerset.add( newSet );
            }
        }
        return powerset;
    }

    public static List<int[]> myPowerSet( final int[] myArr ) {
        final List<int[]> powerset = new LinkedList<>();

        if ( myArr == null || myArr.length == 0 ) {
            powerset.add( new int[0] );
        } else {

            final int firstElement = myArr[0];
            final int[] subsetArr = Arrays.copyOfRange( myArr, 1, myArr.length );
            final List<int[]> previousPowerset = myPowerSet( subsetArr );
            powerset.addAll( previousPowerset );

            for ( final int[] prevSet : previousPowerset ) {
                final int[] newSet = Arrays.copyOf( myArr, prevSet.length + 1 );
                final int newSetLength = newSet.length;
                newSet[newSetLength-1] = firstElement;
            }
        }
        return powerset;
    }

}
