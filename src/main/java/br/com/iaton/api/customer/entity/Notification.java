package br.com.iaton.api.customer.entity;

import java.util.List;
import java.util.Map;

public class Notification {

    private Long idCustomer;
    private List<String> typeTemplates;
    private Map<String, String> attributes;

    public Long getIdCustomer() {
        return idCustomer;
    }

    public Notification setIdCustomer(Long idCustomer) {
        this.idCustomer = idCustomer;
        return this;
    }

    public List<String> getTypeTemplates() {
        return typeTemplates;
    }

    public Notification setTypeTemplates(List<String> typeTemplates) {
        this.typeTemplates = typeTemplates;
        return this;
    }

    public Map<String, String> getAttributes() {
        return attributes;
    }

    public Notification setAttributes(Map<String, String> attributes) {
        this.attributes = attributes;
        return this;
    }
}
