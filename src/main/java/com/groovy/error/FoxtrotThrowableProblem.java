package com.groovy.error;

import lombok.Getter;
import org.zalando.problem.AbstractThrowableProblem;
import org.zalando.problem.Status;
import org.zalando.problem.ThrowableProblem;

import java.net.URI;
import java.util.Arrays;

public class FoxtrotThrowableProblem extends AbstractThrowableProblem {

    /**
     * Name of the module which encouraged the problem.
     */
    @Getter
    private final String entityName;

    /**
     * Short error identifier.
     */
    @Getter
    private final String errorKey;

    /**
     * Args for detail string.
     */
    private final transient Object[] detailArgs;

    public final Object[] getDetailArgs() {
        return Arrays.copyOf(detailArgs, detailArgs.length);
    }

    /**
     * @param type type of the problem from ErrorConstants
     * @param title message title
     * @param status response status
     * @param detail message details
     * @param entityName name of the module which encouraged the problem
     * @param errorKey short error representation.
     * @param detailArgs args for localization string
     * @see AbstractThrowableProblem
     */
    public FoxtrotThrowableProblem(URI type, String title, Status status, String detail, String entityName, String errorKey,
                                   Object... detailArgs) {
        this(type, title, status, detail != null ? String.format(detail, detailArgs) : null, null, null, entityName, errorKey, detailArgs);
    }

    /**
     * @param type type of the problem from ErrorConstants
     * @param title message title
     * @param status response status
     * @param detail message details
     * @param instance
     * @param cause reason for the problem
     * @param entityName name of the module which encouraged the problem
     * @param errorKey short error identifier
     * @param detailArgs args for detail string
     * @see AbstractThrowableProblem
     */
    public FoxtrotThrowableProblem(URI type, String title, Status status, String detail, URI instance, ThrowableProblem cause,
                                   String entityName, String errorKey, Object... detailArgs) {
        super(type, title, status, detail, instance, cause);
        this.entityName = entityName;
        this.errorKey = errorKey;
        this.detailArgs = detailArgs == null ? new Object[0] : Arrays.copyOf(detailArgs, detailArgs.length);
    }
}
