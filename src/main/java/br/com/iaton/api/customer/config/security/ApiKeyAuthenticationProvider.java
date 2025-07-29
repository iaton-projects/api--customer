package br.com.iaton.api.customer.config.security;

import br.com.iaton.api.customer.config.properties.SecurityProperties;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ApiKeyAuthenticationProvider implements AuthenticationProvider {

    private final SecurityProperties securityProperties;

    public ApiKeyAuthenticationProvider(SecurityProperties securityProperties) {
        this.securityProperties = securityProperties;
    }

    @Override
    public Authentication authenticate(Authentication authentication) {
        ApiKeyAuthenticationToken authToken = (ApiKeyAuthenticationToken) authentication;
        String apiKey = authToken.getApiKey();

        if (securityProperties.apiKey().equals(apiKey)) {
            // Cria um token autenticado
            return new ApiKeyAuthenticationToken(apiKey, List.of());
        }
        throw new BadCredentialsException("Invalid API Key");
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return ApiKeyAuthenticationToken.class.isAssignableFrom(authentication);
    }
}
