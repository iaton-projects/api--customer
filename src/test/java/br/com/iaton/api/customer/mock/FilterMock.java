package br.com.iaton.api.customer.mock;

import br.com.iaton.api.customer.entity.Filter;
import br.com.iaton.api.customer.openapi.model.domain.FilterRequest;

public class FilterMock {

    public static Filter getFilter() {
        return new Filter().setFilter("nome");
    }

    public static FilterRequest getFilterRequest() {
        var filtroBusca = new FilterRequest();
        filtroBusca.setPage(1);
        filtroBusca.setFilter("nome");
        return filtroBusca;
    }

}
