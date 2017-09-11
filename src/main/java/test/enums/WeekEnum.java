package test.enums;

public enum WeekEnum {

    MONDAY {
        public String getShortDay() {
            return "Mon";
        }
    },
    TUESDAY {
        public String getShortDay() {
            return "Tuesday";
        }
    },
    WEDNESDAY {
        public String getShortDay() {
            return "Wednesday";
        }
    };

}
