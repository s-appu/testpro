package test.some;

import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.junit.Test;

public class TestString {

    @Test
    public void testStringBuilderEmptyCase() {
        final StringBuilder sb = new StringBuilder();

        Assert.assertNotNull( sb );
        Assert.assertTrue( StringUtils.isBlank( sb.toString() ) );

        System.out.println( String.join( "", "abc", "cde" ) );

    }

    @Test
    public void testString() {
        final String str = "";
        this.method1( str );
        System.out.println( str );
    }

    private void method1( String strNew ) {
        strNew = "My new String";
    }
}
