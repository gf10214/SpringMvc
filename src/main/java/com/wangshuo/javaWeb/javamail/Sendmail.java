package com.wangshuo.javaWeb.javamail;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.text.html.MinimalHTMLWriter;
import java.io.FileOutputStream;
import java.net.URL;
import java.util.Properties;

/**
 * Created by wangshuo on 2016/8/25 0025.
 */
public class Sendmail {
    public static void main(String[] args) throws Exception {
        Properties prop=new Properties();
        prop.setProperty("mail.host","smtp.wondersgroup.com");
        prop.setProperty("mail.transport.protocol","smtp");
        prop.setProperty("mail.smtp.auth","true");
        Session session=Session.getInstance(prop);
        session.setDebug(true);
        Transport ts=session.getTransport();
        ts.connect("smtp.wondersgroup.com","wangshuo","Ws8555698123");
        Message message=createSimpleMail(session);
        ts.sendMessage(message,message.getAllRecipients());
        ts.close();
    }
    public static MimeMessage createSimpleMail(Session session) throws Exception {
        MimeMessage message=new MimeMessage(session);
        message.setFrom(new InternetAddress("wangshuo@wondersgroup.com"));
        message.setRecipient(Message.RecipientType.TO,new InternetAddress("wangshuo@wondersgroup.com"));
        message.setSubject("恭喜你中奖了");
        //发送文本
//        message.setContent("你好呀！","text/html;charset=UTF-8");
        //发送图片
        MimeBodyPart text=new MimeBodyPart();
        text.setContent("潇哥你看我老婆漂亮么<img src='cid:xxx.jpg'>的邮件", "text/html;charset=UTF-8");
        MimeBodyPart image=new MimeBodyPart();
        URL url=new URL("http://pic.4j4j.cn/upload/pic/20130815/31e652fe2d.jpg");
        DataHandler dh=new DataHandler(url);
        image.setDataHandler(dh);
        image.setContentID("xxx.jpg");
        MimeMultipart mm=new MimeMultipart();
        mm.addBodyPart(text);
        mm.addBodyPart(image);
        mm.setSubType("mix");
        message.setContent(mm);
        message.saveChanges();
        message.writeTo(new FileOutputStream("E:\\ImageMail.eml"));
        return message;
    }
}
