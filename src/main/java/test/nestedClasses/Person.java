package test.nestedClasses;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String givenName;
    private String surName;
    private int age;
    private Gender gender;
    private String email;
    private String phone;
    private String address;

    public Person() {

    }

    private Person( final String givenName, final String surName, final int age, final Gender gender, final String email, final String phone, final String address ) {
        super();
        this.givenName = givenName;
        this.surName = surName;
        this.age = age;
        this.gender = gender;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    public String getGivenName() {
        return this.givenName;
    }

    public void setGivenName( final String givenName ) {
        this.givenName = givenName;
    }

    public String getSurName() {
        return this.surName;
    }

    public void setSurName( final String surName ) {
        this.surName = surName;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge( final int age ) {
        this.age = age;
    }

    public Gender getGender() {
        return this.gender;
    }

    public void setGender( final Gender gender ) {
        this.gender = gender;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail( final String email ) {
        this.email = email;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone( final String phone ) {
        this.phone = phone;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress( final String address ) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Given Name : " + this.givenName + " Sur Name : " + this.surName + " Age : " + this.age + " Gender : " + this.gender + " Email : " + this.email + " Phone :" + this.phone + " Address : " + this.address + "\n";
    }

    public static Builder aBuilder() {
        return new Builder();
    }

    public static List<Person> createShortList() {
        final List<Person> people = new ArrayList<>();
        people.add( new Builder().givenName( "Bob" ).surName( "Baker" ).age( 21 ).gender( Gender.MALE ).email( "bob.baker@example.com" ).phoneNumber( "201-121-4678" ).address( "44 4th St, Smallville, KS 12333" ).build() );

        people.add( new Person.Builder().givenName( "Jane" ).surName( "Doe" ).age( 25 ).gender( Gender.FEMALE ).email( "jane.doe@example.com" ).phoneNumber( "202-123-4678" ).address( "33 3rd St, Smallville, KS 12333" ).build() );

        people.add( new Person.Builder().givenName( "John" ).surName( "Doe" ).age( 25 ).gender( Gender.MALE ).email( "john.doe@example.com" ).phoneNumber( "202-123-4678" ).address( "33 3rd St, Smallville, KS 12333" ).build() );

        return people;
    }

    static class Builder {
        private String givenName;
        private String surName;
        private int age;
        private Gender gender;
        private String email;
        private String phoneNumber;
        private String address;

        public Builder givenName( final String givenName ) {
            this.givenName = givenName;
            return this;
        }

        public Builder surName( final String surName ) {
            this.surName = surName;
            return this;
        }

        public Builder age( final int age ) {
            this.age = age;
            return this;
        }

        public Builder gender( final Gender gender ) {
            this.gender = gender;
            return this;
        }

        public Builder email( final String email ) {
            this.email = email;
            return this;
        }

        public Builder phoneNumber( final String phone ) {
            this.phoneNumber = phone;
            return this;
        }

        public Builder address( final String address ) {
            this.address = address;
            return this;
        }

        public Person build() {
            return new Person( this.givenName, this.surName, this.age, this.gender, this.email, this.phoneNumber, this.address );
        }

    }
}

enum Gender {
    MALE, FEMALE;
}