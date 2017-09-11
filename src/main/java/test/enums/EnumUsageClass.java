package test.enums;

public class EnumUsageClass {

    public static void main( final String args[] ) {

        final WeekEnum en = WeekEnum.MONDAY;

        String dayShort = "";
        if ( en == WeekEnum.MONDAY ) {
            dayShort = "Mon";
        } else if ( en == WeekEnum.TUESDAY ) {
            dayShort = "Tue";
        } else if ( en == WeekEnum.WEDNESDAY ) {
            dayShort = "Wed";
        }

        System.out.println( dayShort );

    }
}
