package demo.spring_rabbitmq.producer;


import jakarta.annotation.PostConstruct;
import model.Notification;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
public class NotificationProducer {



    @Value("${sr.rabbit.routing.name}")
    private String routingName;

    @Value("{sr.rabbit.exchange.name}")
    private String exchangeName;

    @PostConstruct
    public void init() {
        // init metodu artık içerisinde bağımlılıkları kullanmıyor
    }

    @EventListener(ContextRefreshedEvent.class)
    public void sendInitialNotification() {
        Notification notification = new Notification();
        notification.setNotificationId(UUID.randomUUID().toString());
        notification.setCreatedAt(new Date());
        notification.setMessage("Arayüze hoşgeldiniz.");
        notification.setView(Boolean.FALSE);

        SendToQueue(notification);
    }

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void SendToQueue(Notification notification){
        System.out.println("Notification Sent Id :" + notification.getNotificationId());
        rabbitTemplate.convertAndSend(exchangeName,routingName,notification);
    }




}
