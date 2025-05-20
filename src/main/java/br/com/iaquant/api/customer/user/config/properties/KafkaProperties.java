package br.com.iaquant.api.customer.user.config.properties;


import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "kafka")
public record KafkaProperties(String bootstrapServers, String schemaRegistry, KafkaServiceProperties notification) {}
