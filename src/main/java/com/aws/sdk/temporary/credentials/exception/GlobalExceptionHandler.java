package com.aws.sdk.temporary.credentials.exception;

import com.aws.sdk.temporary.credentials.exception.type.AWSParameterNullException;
import com.aws.sdk.temporary.credentials.exception.type.S3ConnectionException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Controller
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public String handleException(Exception ex){

        if(ex instanceof AWSParameterNullException){
            return ex.getMessage();
        } else if (ex instanceof S3ConnectionException) {
            return ex.getMessage();
        } else {
            return "Null Exception";
        }
    }
}
