package br.com.iaquant.api.customer.user.config;

import br.com.iaquant.api.customer.user.config.properties.KafkaProperties;
import br.com.iaquant.api.customer.user.config.properties.SecurityProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties({SecurityProperties.class, KafkaProperties.class})
public class ApiCustomerUserConfig {
}
