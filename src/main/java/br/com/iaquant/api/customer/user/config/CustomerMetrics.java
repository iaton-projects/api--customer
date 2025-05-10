package br.com.iaquant.api.customer.user.config;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.stereotype.Component;

@Component
public class CustomerMetrics {

    private final Counter customerProcess;

    private final Counter customerErrors;

    public CustomerMetrics(MeterRegistry registry) {
        this.customerProcess = Counter.builder("customer_process_total")
                .description("Total de customer Criados")
                .register(registry);

        this.customerErrors = Counter.builder("customer_process_errors_total")
                .description("Total de customer com erro no cadastro")
                .register(registry);

    }

    public void incrementCustomerSuccessCount() {
        customerProcess.increment();
    }

    public void incrementCustomerErrorCount() {
        customerErrors.increment();
    }
}
