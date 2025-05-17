package br.com.iaquant.api.customer.user.config;

import br.com.iaquant.api.customer.user.config.properties.SecurityProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties({SecurityProperties.class})
public class ApiCustomerUserConfig {
}
