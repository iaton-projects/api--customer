package br.com.iaton.api.customer.mock;

import br.com.iaton.api.customer.entity.Status;

public class StatusMock {

    public static Status getStatusSuccess() {
        return new Status(0, "SUCESSO");
    }
}
