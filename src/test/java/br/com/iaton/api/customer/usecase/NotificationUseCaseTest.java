package br.com.iaton.api.customer.usecase;


import br.com.iaton.api.customer.entity.Customer;
import br.com.iaton.api.customer.entity.Notification;
import br.com.iaton.api.customer.repository.NotificationRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
class NotificationUseCaseTest {

    @Mock
    NotificationRepository notificationRepository;

    @InjectMocks
    NotificationUseCase notificationUseCase;

    @Test
    void shouldSendNotificationSuccess() {
        var customer = notificationUseCase.sendNotification(new Customer().setId(1L).setFirstName("name").setLastName("last name"));
        verify(notificationRepository, times(1)).sendNotification(any(Notification.class));
        assertNotNull(customer);
    }
}
