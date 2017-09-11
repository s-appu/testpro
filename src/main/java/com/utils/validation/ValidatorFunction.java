package com.utils.validation;

@FunctionalInterface
public interface ValidatorFunction<T, V extends ValidationResult> {

    V apply( T t, V v );

    default ValidatorFunction<T, V> and( final ValidatorFunction<T, V> other ) {
        return ( t, v ) -> other.apply( t, this.apply( t, v ) );
    }

    default ValidatorFunction<T, V> or( final ValidatorFunction<T, V> other ) {
        return ( t, v ) -> {
            V r = this.apply( t, v );
            if ( r.isValid() ) {
                r = other.apply( t, r );
            }
            return r;
        };
    }
}
