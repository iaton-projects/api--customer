package br.com.iaton.api.customer.exception;

public class ElementNotFoundException extends ResourceException {

    private static final long serialVersionUID = 320544027921912540L;

    public ElementNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ElementNotFoundException(String message) {
        super(message);
    }

}
