package br.com.iaquant.api.customer.user.repository;

import br.com.iaquant.api.customer.user.entity.Notification;

public interface NotificationRepository {
    void sendNotification(Notification notification);

}
