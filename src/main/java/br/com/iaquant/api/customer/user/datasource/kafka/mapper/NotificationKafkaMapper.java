package br.com.iaquant.api.customer.user.datasource.kafka.mapper;


import br.com.iaquant.api.customer.user.entity.Notification;
import br.com.iaquant.service.notification.avro.NotificationAvro;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel= MappingConstants.ComponentModel.SPRING)
public interface NotificationKafkaMapper {

    NotificationAvro map(Notification notification);
}
