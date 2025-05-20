package br.com.iaquant.api.customer.user.datasource;


import br.com.iaquant.api.customer.user.config.properties.KafkaProperties;
import br.com.iaquant.api.customer.user.datasource.kafka.mapper.NotificationKafkaMapper;
import br.com.iaquant.api.customer.user.entity.Notification;
import br.com.iaquant.api.customer.user.repository.NotificationRepository;
import br.com.iaquant.service.notification.avro.NotificationAvro;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Component
public class NotificationDataSource implements NotificationRepository {

    private final KafkaTemplate<String, NotificationAvro> kafkaTemplate;

    private final NotificationKafkaMapper notificationKafkaMapper;

    private final KafkaProperties kafkaProperties;

    public NotificationDataSource(KafkaTemplate<String, NotificationAvro> kafkaTemplate, NotificationKafkaMapper notificationKafkaMapper, KafkaProperties kafkaProperties) {
        this.kafkaTemplate = kafkaTemplate;
        this.notificationKafkaMapper = notificationKafkaMapper;
        this.kafkaProperties = kafkaProperties;
    }

    @Override
    public void sendNotification(Notification notification) {
        var record = new ProducerRecord<>(kafkaProperties.notification().topic(), String.valueOf(UUID.randomUUID()), notificationKafkaMapper.map(notification));
        kafkaTemplate.send(record);
    }
}
