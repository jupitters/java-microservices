package com.jupitters.notification_service.service;

import com.jupitters.order.event.OrderPlacedEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class NotificationService {
    private final JavaMailSender javaMailSender;

    @KafkaListener(topics = "order-placed")
    public void listen(OrderPlacedEvent orderPlacedEvent) {
        log.info("Got message from order-placed topic: {}", orderPlacedEvent);
        MimeMessagePreparator messagePreparator = mimeMessage -> {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);
            mimeMessageHelper.setFrom("springshop@gmail.com");
            mimeMessageHelper.setTo(orderPlacedEvent.getEmail());
            mimeMessageHelper.setSubject(String.format("Your order with OrderNumber %s is placed successfully!", orderPlacedEvent.getOrderNumber()));
            mimeMessageHelper.setText(String.format("""
                    Hi %s, %s
                    
                    Your order with order number %s is now placed successfully.
                    
                    Best regards,
                    Spring Shop
                    """,
                    orderPlacedEvent.getFirstName(),
                    orderPlacedEvent.getLastName(),
                    orderPlacedEvent.getOrderNumber()));
        };
        try{
            javaMailSender.send(messagePreparator);
        } catch(MailException e) {
            log.error("Exception occurred when sendim mail: ", e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
