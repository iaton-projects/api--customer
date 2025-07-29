package br.com.iaton.api.customer.exception;

public class ListNotFoundException extends ResourceException {

    private static final long serialVersionUID = 320544027921912540L;

    public ListNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ListNotFoundException(String message) {
        super(message);
    }



}
