package com.groovy.mail;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class SendMail {

    private final JavaMailSender emailSender;

    private final String MESSAGE_TEMPLATE = "Доброго дня, шановний клієнт!\n" +
            "У вкладенні знаходиться рахунок-специфікація для оплати замовлення № %d від %s р.\n" +
            "Звертаємо вашу увагу на наступне:\n" +
            "• Рахунок-специфікація дійсна протягом трьох банківських днів\n" +
            "• Договір оферти знаходиться на сайті за посиланням http://www.foxtrot.com.ua/ru/delivery\n" +
            "• При отриманні замовлення необхідно мати при собі довіреність на отримання товару та документи підтверджуючі особу отримувача.\n" +
            "\n" +
            "Цей лист надіслано автоматично, прохання не відповідати на нього, якщо у Вас виникнуть питання ми раді будемо відповісти на них за номером: 0 800 300-353\n" +
            "З повагою, команда Фокстрот.\n" +
            "\n";

    public SendMail() {
        this.emailSender = getJavaMailSender();
    }

    public void sendMail() {
        MimeMessage message = emailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom("Groupclientsupportsumifoxtrot@foxtrot.ua");
            helper.setSubject("Рахунок-специфікація від компанії Фокстрот");
            helper.setTo("z.murenko@gmail.com");

//            helper.addAttachment("filename", getResource());
//            helper.setText(createMessageText(123456L));
            emailSender.send(message);
        } catch (Exception e) {
            System.out.println("ERROR = " + e.getMessage());
        }

    }

//    private String createMessageText(Long saleId){
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
//
//        String htmlContent = this.templateEngine.process("mailTemplate/email.ftl", ctx);
//        return String.format(MESSAGE_TEMPLATE, saleId, LocalDateTime.now().format(formatter));
//    }

    public JavaMailSender getJavaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);

        mailSender.setUsername("varteq.workspace@gmail.com");
        mailSender.setPassword("qdkevdfntjbrbqpp");

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");

        return mailSender;
    }
}
