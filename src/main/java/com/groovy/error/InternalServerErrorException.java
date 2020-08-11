package com.groovy.error;

import org.zalando.problem.Status;

import java.net.URI;

public class InternalServerErrorException extends FoxtrotThrowableProblem {

    private static final URI type = ErrorConstants.DEFAULT_TYPE;
    private static final Status status = Status.INTERNAL_SERVER_ERROR;

    public InternalServerErrorException(String message) {
        this(message, "unknown", null);
    }

    public InternalServerErrorException(String title, String entityName, String errorKey) {
        this(title, null, entityName, errorKey);
    }

    public InternalServerErrorException(String title, String detail, String entityName, String errorKey, Object... detailArgs) {
        super(type, title, status, detail, entityName, errorKey, detailArgs);
    }
}
