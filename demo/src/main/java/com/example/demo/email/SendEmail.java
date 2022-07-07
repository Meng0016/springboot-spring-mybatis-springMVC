package com.example.demo.email;

import com.sun.mail.util.MailSSLSocketFactory;
import lombok.extern.slf4j.Slf4j;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.security.GeneralSecurityException;
import java.util.Properties;

@Slf4j
public class SendEmail {
    public static void main(String [] args) throws GeneralSecurityException {
        // 收件人电子邮箱
        String toEmail = "2516558211@qq.com";

        // 发件人电子邮箱
        String fromEmail = "2292834280@qq.com";

        // 指定发送邮件的主机为QQ 邮件服务器 smtp.qq.com
        String emailHost = "smtp.qq.com";

        // 邮件接收的协议
        String storeType = "pop3";

        // 获取系统属性
        Properties properties = System.getProperties();

        // 设置邮件服务器
        properties.setProperty("mail.smtp.host", emailHost);

        // 设置用户认证以及SSL加密
        properties.put("mail.smtp.auth", "true");
        MailSSLSocketFactory sf = new MailSSLSocketFactory();
        sf.setTrustAllHosts(true);
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.ssl.socketFactory", sf);
        log.info("properties: {}", properties);

        // 获取默认session对象
        Session session = Session.getDefaultInstance(properties,new Authenticator(){
            public PasswordAuthentication getPasswordAuthentication() {
                //设置发件人邮件用户名、授权码
                return new PasswordAuthentication("2292834280@qq.com", "hgipfzgbxxflebdj");
            }
        });

        try{
            // 创建默认的 MimeMessage 对象
            MimeMessage message = new MimeMessage(session);

            // SetFrom 设置发件人
            message.setFrom(new InternetAddress(fromEmail));

            // SetTo 设置收件人
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));

            // SetSubject 设置标题
            message.setSubject("Hello!  This is the Subject Line!");

            // 设置邮件正文
            message.setText("I'm Yeats_Liao");
            log.info("message: {}", message);
            // 发送邮件
            Transport.send(message);
            System.out.println("Sent message successfully");
        }catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
}
