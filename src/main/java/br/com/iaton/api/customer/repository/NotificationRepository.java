package br.com.iaton.api.customer.repository;

import br.com.iaton.api.customer.entity.Notification;

public interface NotificationRepository {
    void sendNotification(Notification notification);

}
