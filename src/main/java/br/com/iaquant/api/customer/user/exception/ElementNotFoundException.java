package br.com.iaquant.api.customer.user.exception;

public class ElementNotFoundException extends ResourceException {

    private static final long serialVersionUID = 320544027921912540L;

    public ElementNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ElementNotFoundException(String message) {
        super(message);
    }

}
