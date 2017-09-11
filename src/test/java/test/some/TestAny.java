package test.some;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import com.google.common.base.Objects;

public class TestAny {

    @Test
    public void testMapGet() {

        final Parent m = null;
        final Child str1 = (Child) m;

        System.out.println( str1 );

    }

    @Test
    public void mapEqualsTest() {
        final String str1 = "John";
        final Map<String, String> mp1 = new HashMap<>();
        mp1.put( str1, "Mathew" );

        final String str2 = new String( "John" );
        final Map<String, String> mp2 = new HashMap<>();
        mp2.put( str2, "Mathew" );

        Assert.assertTrue( Objects.equal( mp1, mp2 ) );
    }

    class Parent {

    }

    class Child extends Parent {

    }
}
