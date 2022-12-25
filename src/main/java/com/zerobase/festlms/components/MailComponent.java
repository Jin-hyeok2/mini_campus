package com.zerobase.festlms.components;

import lombok.RequiredArgsConstructor;

import javax.mail.internet.MimeMessage;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MailComponent {
    private final JavaMailSender javaMailSender;
    public void sendMailTest() {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo("hwlsgur1120@naver.com");
        msg.setSubject("안녕하세요 제로베이스 입니까?");
        msg.setText("안녕하세요 제로베이스입니까? 방...갑습니다??!");

        javaMailSender.send(msg);
    }

    public boolean sendMail(String mail, String subject, String text) {
        
        boolean result = false;

        MimeMessagePreparator msg = new MimeMessagePreparator() {
            @Override
            public void prepare(MimeMessage mimeMessage) throws Exception {
                MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
                mimeMessageHelper.setTo(mail);
                mimeMessageHelper.setSubject(subject);
                mimeMessageHelper.setText(text, true);
            }
        };
        try {
            javaMailSender.send(msg);
            result = true;
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }

        return result;
    }
}
