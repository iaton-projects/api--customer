package br.com.iaton.api.customer.mock;

import br.com.iaton.api.customer.entity.Filter;

public class FilterMock {

    public static Filter getFilter() {
        return new Filter().setFilter("nome");
    }

}
