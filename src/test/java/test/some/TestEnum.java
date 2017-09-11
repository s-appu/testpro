package test.some;

import org.junit.Test;

public class TestEnum {

    @Test
    public void getEnumByDescription() {
        final String str = "Sunday";
        System.out.println( MyEnum.getMyEnumByName( str ) );
    }

}
