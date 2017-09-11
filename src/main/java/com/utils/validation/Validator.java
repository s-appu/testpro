package com.utils.validation;

public interface Validator<T> {

    ValidationResult SUCCESSFUL_VALIDATION_RESULT = new ValidationResult();

    ValidationResult validate( final T obj );
}
