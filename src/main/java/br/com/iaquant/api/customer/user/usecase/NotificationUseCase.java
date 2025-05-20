package br.com.iaquant.api.customer.user.usecase;

import br.com.iaquant.api.customer.user.entity.Customer;
import br.com.iaquant.api.customer.user.entity.Notification;
import br.com.iaquant.api.customer.user.entity.Status;
import br.com.iaquant.api.customer.user.repository.NotificationRepository;
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
                .setAttributes(Map.of("nome",customer.getName()))
                        .setTypeTemplates(Arrays.asList("PAYMENT_APPROVED_EMAIL"));


        notificationRepository.sendNotification(notification);
        return new Status(0,"SUCESSO");
    }
}
