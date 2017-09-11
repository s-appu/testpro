package com.utils.validation;

import java.util.function.Predicate;

public class ValidatorChain<T> {

    private ValidatorFunction<T, ValidationResult> validatorFunction;

    public ValidatorChain<T> proceedOnError( final Predicate<T> p, final String message ) {
        final ValidatorFunction<T, ValidationResult> v = ( obj, vr ) -> p.test( obj ) ? vr.addErrorMessage( message ) : vr;
        if ( this.validatorFunction == null ) {
            this.validatorFunction = v;
        } else {
            this.validatorFunction = this.validatorFunction.and( v );
        }
        return this;
    }

    public ValidatorChain<T> breakOnError( final Predicate<T> p, final String message ) {
        final ValidatorFunction<T, ValidationResult> v = ( obj, vr ) -> p.test( obj ) ? vr.addErrorMessage( message ) : vr;
        if ( this.validatorFunction == null ) {
            this.validatorFunction = v;
        } else {
            this.validatorFunction = this.validatorFunction.or( v );
        }
        return this;
    }

    public ValidationResult validate( final T object ) {
        if ( this.validatorFunction == null ) {
            throw new RuntimeException( "No Validator has been set." );
        }
        return this.validatorFunction.apply( object, new ValidationResult() );
    }
}
