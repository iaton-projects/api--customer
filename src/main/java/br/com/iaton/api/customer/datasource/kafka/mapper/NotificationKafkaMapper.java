package br.com.iaton.api.customer.datasource.kafka.mapper;


import br.com.iaton.api.customer.entity.Notification;
import br.com.iaton.service.notification.avro.NotificationAvro;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel= MappingConstants.ComponentModel.SPRING)
public interface NotificationKafkaMapper {

    NotificationAvro map(Notification notification);
}
