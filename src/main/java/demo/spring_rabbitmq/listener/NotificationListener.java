package demo.spring_rabbitmq.listener;

import model.Notification;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class NotificationListener {
    @RabbitListener(queues = "guest-queue")
    public void handleMessage(Notification notification){
        System.out.println(notification.toString());
    }
}
