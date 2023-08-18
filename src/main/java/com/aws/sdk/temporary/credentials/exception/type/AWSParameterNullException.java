package com.aws.sdk.temporary.credentials.exception.type;

public class AWSParameterNullException extends RuntimeException{
    public AWSParameterNullException(String parameterName) {
        super(parameterName + " is null.");
    }
}
