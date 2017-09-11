package interview;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class CodeTest {

    public static String findPairsWithSum( final int arr[], final int x ) {

        final StringBuilder sb = new StringBuilder();

        Arrays.sort( arr ); // Sort the array
        int left = 0;
        int right = arr.length - 1;

        while ( left < right ) {
            final int sum = arr[left] + arr[right];
            if ( sum == x ) {
                sb.append( String.format( "{ %d, %d } ", arr[left], arr[right] ) );
                left = left + 1;
                right = right - 1;
            } else if ( sum < x ) {
                left = left + 1;
            } else if ( sum > x ) {
                right = right - 1;
            }
        }

        if ( sb.length() > 0 ) {
            return String.format( "Match found %s", sb.toString() );
        } else {
            return "No match found";
        }
    }

    @Test
    public void testFindPairsWithSumShouldYieldResult() {

        final int arr[] = {
                5,
                10,
                4,
                6,
                8,
                12,
                15,
                -5,
                19
        };
        final int sumValue = 10;

        final String result = findPairsWithSum( arr, sumValue );
        System.out.println( result );
        Assert.assertNotNull( result );
        Assert.assertTrue( result.contains( "-5, 15" ) );
        Assert.assertTrue( result.contains( "4, 6" ) );

    }

    @Test
    public void testFindPairsWithSumShouldNotYieldResult() {

        final int arr[] = {
                5,
                10,
                4,
                6,
                8,
                12,
                15,
                -5,
                19
        };
        final int sumValue = 100;

        final String result = findPairsWithSum( arr, sumValue );
        System.out.println( result );
        Assert.assertNotNull( result );
        Assert.assertEquals( "No match found", result );

    }

}
