package test.some;

import org.apache.commons.lang3.StringUtils;

public enum MyEnum {
    SUN( "Sunday" ), MON( "Monday" );

    private final String name;

    MyEnum( final String name ) {
        this.name = name;
    }

    public static MyEnum getMyEnumByName( final String name ) {
        for ( final MyEnum m : MyEnum.values() ) {
            if ( StringUtils.equals( m.name, name ) ) {
                return m;
            }
        }
        return null;
    }
}
