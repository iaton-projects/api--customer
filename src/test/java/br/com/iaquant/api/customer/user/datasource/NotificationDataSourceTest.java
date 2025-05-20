package br.com.iaquant.api.customer.user.datasource;

import br.com.iaquant.api.customer.user.config.properties.KafkaProperties;
import br.com.iaquant.api.customer.user.config.properties.KafkaServiceProperties;
import br.com.iaquant.api.customer.user.datasource.kafka.mapper.NotificationKafkaMapper;
import br.com.iaquant.api.customer.user.entity.Notification;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import br.com.iaquant.service.notification.avro.NotificationAvro;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
class NotificationDataSourceTest {

    @Mock
    private KafkaTemplate<String, NotificationAvro> kafkaTemplate;

    @Mock
    private KafkaProperties kafkaProperties;

    @Mock
    private NotificationKafkaMapper notificationMapper;

    @Mock
    private SecurityContext securityContext;

    @Mock
    private Authentication authentication;

    @Mock
    private OAuth2ResourceServerProperties.Jwt jwt;

    @InjectMocks
    private NotificationDataSource notificationDataSource;

    @BeforeEach
    public void setUp() {
        var kafkaNotficationProperties = new KafkaServiceProperties("GROUPID", "TOPIC");
        when(kafkaProperties.bootstrapServers()).thenReturn("SERVER");
        when(kafkaProperties.schemaRegistry()).thenReturn("REGISTRY");
        when(kafkaProperties.notification()).thenReturn(kafkaNotficationProperties);
    }

    @Test
    void shouldSendNotificationSuccess() throws IllegalAccessException {
        when(notificationMapper.map(any(Notification.class))).thenReturn(new NotificationAvro());
        notificationDataSource.sendNotification(new Notification());
        verify(kafkaTemplate, times(1)).send(any(ProducerRecord.class));
    }
}
