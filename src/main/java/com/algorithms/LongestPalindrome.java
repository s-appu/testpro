package com.algorithms;

public class LongestPalindrome {

    public static void main( final String args[] ) {

        System.out.println( "bananas  -- " + longestPalidrome( "bananas" ) );
        System.out.println( "malayalam -- " + longestPalidrome( "malayalam" ) );
        System.out.println( "appu -- " + longestPalidrome( "appu" ) );
        System.out.println( "soumya -- " + longestPalidrome( "soumya" ) );
    }

    public static String longestPalidrome( final String s ) {
        if ( s == null || s.isEmpty() ) {
            return null;
        }
        if ( s.length() == 1 ) {
            return s;
        }

        String longest = s.substring( 0, 1 );
        for ( int i = 0; i < s.length(); i++ ) {
            String tmp = helper( s, i, i );
            if ( tmp.length() > longest.length() ) {
                longest = tmp;
            }

            tmp = helper( s, i, i + 1 );
            if ( tmp.length() > longest.length() ) {
                longest = tmp;
            }
        }
        return longest;
    }

    public static String helper( final String s, int begin, int end ) {
        while ( begin >= 0 && end <= s.length() - 1 && s.charAt( begin ) == s.charAt( end ) ) {
            begin--;
            end++;
        }
        return s.substring( begin + 1, end );
    }
}
