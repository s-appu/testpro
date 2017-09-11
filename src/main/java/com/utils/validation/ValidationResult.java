package com.utils.validation;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.springframework.util.CollectionUtils;

public class ValidationResult {

    private List<String> errorMessages = new LinkedList<>();

    public ValidationResult() {
    }

    public boolean isValid() {
        return CollectionUtils.isEmpty( this.errorMessages );
    }

    public boolean isInValid() {
        return !CollectionUtils.isEmpty( this.errorMessages );
    }

    public ValidationResult addErrorMessage( final String errorMessage ) {
        this.errorMessages.add( errorMessage );
        return this;
    }

    public Set<String> getAllErrors() {
        return new HashSet<String>( this.errorMessages );
    }

    public String getErrors() {
        return new HashSet<String>( this.errorMessages ).toString();
    }
}
