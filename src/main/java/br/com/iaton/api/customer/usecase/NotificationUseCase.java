package br.com.iaton.api.customer.usecase;

import br.com.iaton.api.customer.entity.Customer;
import br.com.iaton.api.customer.entity.Notification;
import br.com.iaton.api.customer.entity.Status;
import br.com.iaton.api.customer.repository.NotificationRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Map;

@Service
public class NotificationUseCase {

    private final NotificationRepository notificationRepository;


    public NotificationUseCase(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    public Status sendNotification(Customer customer) {

        var notification = new Notification()
                .setIdCustomer(customer.getId())
                .setAttributes(Map.of("nome",customer.getFirstName()+customer.getLastName()))
                        .setTypeTemplates(Arrays.asList("PAYMENT_APPROVED_EMAIL"));


        notificationRepository.sendNotification(notification);
        return new Status(0,"SUCESSO");
    }
}
