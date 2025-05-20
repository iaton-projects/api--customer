package br.com.iaquant.api.customer.user.exception;

public class ListNotFoundException extends ResourceException {

    private static final long serialVersionUID = 320544027921912540L;

    public ListNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ListNotFoundException(String message) {
        super(message);
    }



}
