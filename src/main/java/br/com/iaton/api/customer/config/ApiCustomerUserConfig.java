package br.com.iaton.api.customer.config;

import br.com.iaton.api.customer.config.properties.KafkaProperties;
import br.com.iaton.api.customer.config.properties.SecurityProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties({SecurityProperties.class, KafkaProperties.class})
public class ApiCustomerUserConfig {
}
