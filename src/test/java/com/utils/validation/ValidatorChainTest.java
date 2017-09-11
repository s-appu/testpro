package com.utils.validation;

import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ValidatorChainTest {

    private static final SomeTestObject VALID_TEST_OBJECT = new SomeTestObject( "ABC", "abc@test.com", "New York", 50 );
    private static final SomeTestObject NO_NAME_TEST_OBJECT = new SomeTestObject( "", "abc@test.com", "New York", 50 );
    private static final SomeTestObject NO_AGE_TEST_OBJECT = new SomeTestObject( "ABC", "abc@test.com", "New York", 0 );
    private static final SomeTestObject NO_NAME_EMAIL_TEST_OBJECT = new SomeTestObject( "", "", "New York", 50 );
    private static final SomeTestObject NO_EMAIL_CITY_TEST_OBJECT = new SomeTestObject( "ABC", "", "", 50 );
    private static final SomeTestObject NO_NAME_EMAIL_AGE_TEST_OBJECT = new SomeTestObject( "", "", "New York", 0 );

    private static final String NAME_EMPTY_MSG = "Name is empty.";
    private static final String EMAIL_EMPTY_MSG = "Email is empty.";
    private static final String CITY_EMPTY_MSG = "City is empty.";
    private static final String AGE_EMPTY_MSG = "Age is empty.";

    private ValidatorChain<SomeTestObject> doAllValidationChain;
    private ValidatorChain<SomeTestObject> failFastValidationChain;

    @Before
    public void setup() {
        this.doAllValidationChain = new ValidatorChain<SomeTestObject>()
                .proceedOnError( testObj -> StringUtils.isEmpty( testObj.name ), NAME_EMPTY_MSG )
                .proceedOnError( testObj -> StringUtils.isEmpty( testObj.email ), EMAIL_EMPTY_MSG )
                .proceedOnError( testObj -> StringUtils.isEmpty( testObj.city ), CITY_EMPTY_MSG )
                .proceedOnError( testObj -> testObj.age <= 0, AGE_EMPTY_MSG );

        this.failFastValidationChain = new ValidatorChain<SomeTestObject>()
                .breakOnError( testObj -> StringUtils.isEmpty( testObj.name ), NAME_EMPTY_MSG )
                .breakOnError( testObj -> StringUtils.isEmpty( testObj.email ), EMAIL_EMPTY_MSG )
                .breakOnError( testObj -> StringUtils.isEmpty( testObj.city ), CITY_EMPTY_MSG )
                .breakOnError( testObj -> testObj.age <= 0, AGE_EMPTY_MSG );
    }

    @Test
    public void shouldCaptureAllValidation_validObject() {
        final ValidationResult result = this.doAllValidationChain.validate( VALID_TEST_OBJECT );

        Assert.assertTrue( result.isValid() );
        Assert.assertTrue( result.getAllErrors().size() == 0 );
    }

    @Test
    public void shouldCaptureAllValidation_invalidObjects() {
        final ValidationResult noNameResult = this.doAllValidationChain.validate( NO_NAME_TEST_OBJECT );
        final ValidationResult noAgeResult = this.doAllValidationChain.validate( NO_AGE_TEST_OBJECT );
        final ValidationResult noNameEmailResult = this.doAllValidationChain.validate( NO_NAME_EMAIL_TEST_OBJECT );
        final ValidationResult noEmailCityResult = this.doAllValidationChain.validate( NO_EMAIL_CITY_TEST_OBJECT );
        final ValidationResult noNameEmailAgeResult = this.doAllValidationChain.validate( NO_NAME_EMAIL_AGE_TEST_OBJECT );

        Assert.assertTrue( noNameResult.isInValid() );
        Assert.assertTrue( noAgeResult.getAllErrors().size() == 1 );
        Assert.assertTrue( noNameResult.getAllErrors().contains( NAME_EMPTY_MSG ) );

        Assert.assertTrue( noAgeResult.isInValid() );
        Assert.assertTrue( noAgeResult.getAllErrors().size() == 1 );
        Assert.assertTrue( noAgeResult.getAllErrors().contains( AGE_EMPTY_MSG ) );

        Assert.assertTrue( noNameEmailResult.isInValid() );
        Assert.assertTrue( noNameEmailResult.getAllErrors().size() == 2 );
        Assert.assertTrue( noNameEmailResult.getAllErrors().contains( NAME_EMPTY_MSG ) && noNameEmailResult.getAllErrors().contains( EMAIL_EMPTY_MSG ) );

        Assert.assertTrue( noEmailCityResult.isInValid() );
        Assert.assertTrue( noEmailCityResult.getAllErrors().size() == 2 );
        Assert.assertTrue( noEmailCityResult.getAllErrors().contains( EMAIL_EMPTY_MSG ) && noEmailCityResult.getAllErrors().contains( CITY_EMPTY_MSG ) );

        Assert.assertTrue( noNameEmailAgeResult.isInValid() );
        Assert.assertTrue( noNameEmailAgeResult.getAllErrors().size() == 3 );
        Assert.assertTrue( noNameEmailAgeResult.getAllErrors().contains( NAME_EMPTY_MSG ) && noNameEmailAgeResult.getAllErrors().contains( EMAIL_EMPTY_MSG ) && noNameEmailAgeResult.getAllErrors().contains( AGE_EMPTY_MSG ) );
    }

    @Test
    public void shouldValidateFailFast_validObject() {
        final ValidationResult result = this.failFastValidationChain.validate( VALID_TEST_OBJECT );

        Assert.assertTrue( result.isValid() );
        Assert.assertTrue( result.getAllErrors().size() == 0 );
    }

    @Test
    public void shouldFailFast_invalidObject() {
        final ValidationResult noNameResult = this.failFastValidationChain.validate( NO_NAME_TEST_OBJECT );
        final ValidationResult noAgeResult = this.failFastValidationChain.validate( NO_AGE_TEST_OBJECT );
        final ValidationResult noNameResult_fromNoNameEmailTest = this.failFastValidationChain.validate( NO_NAME_EMAIL_TEST_OBJECT );
        final ValidationResult noEmailResult_fromNoEmailCityTest = this.failFastValidationChain.validate( NO_EMAIL_CITY_TEST_OBJECT );

        Assert.assertTrue( noNameResult.isInValid() );
        Assert.assertTrue( noNameResult.getAllErrors().size() == 1 );
        Assert.assertTrue( noNameResult.getAllErrors().contains( NAME_EMPTY_MSG ) );

        Assert.assertTrue( noAgeResult.isInValid() );
        Assert.assertTrue( noAgeResult.getAllErrors().size() == 1 );
        Assert.assertTrue( noAgeResult.getAllErrors().contains( AGE_EMPTY_MSG ) );

        Assert.assertTrue( noNameResult_fromNoNameEmailTest.isInValid() );
        Assert.assertTrue( noNameResult_fromNoNameEmailTest.getAllErrors().size() == 1 );
        Assert.assertTrue( noNameResult_fromNoNameEmailTest.getAllErrors().contains( NAME_EMPTY_MSG ) );

        Assert.assertTrue( noEmailResult_fromNoEmailCityTest.isInValid() );
        Assert.assertTrue( noEmailResult_fromNoEmailCityTest.getAllErrors().size() == 1 );
        Assert.assertTrue( noEmailResult_fromNoEmailCityTest.getAllErrors().contains( EMAIL_EMPTY_MSG ) );
    }

    @Test(expected = RuntimeException.class)
    public void shouldThrowExceptionWhenNoValidatorAdded() {
        this.doAllValidationChain = new ValidatorChain<>();
        this.doAllValidationChain.validate( VALID_TEST_OBJECT );
    }

    static class SomeTestObject {
        String name;
        String email;
        String city;
        int age;

        public SomeTestObject( final String name, final String email, final String city, final int age ) {
            this.name = name;
            this.email = email;
            this.city = city;
            this.age = age;
        }

    }

}
