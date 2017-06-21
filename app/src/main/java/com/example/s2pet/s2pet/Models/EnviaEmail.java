package com.example.s2pet.s2pet.Models;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

/**
 * Created by aluno on 20/06/2017.
 */

public class EnviaEmail {

    public void enviarEmail() throws EmailException{
        Email email = new SimpleEmail();
        email.setHostName("smtp.gmail.com");
        email.setSmtpPort(465);
        email.setAuthenticator(new DefaultAuthenticator("vittgiangarelli03@gmail.com", "70705510"));
        email.setSSLOnConnect(true);
        email.setFrom("vittgiangarelli03@gmail.com");
        email.setSubject("Teste enviar email");
        email.setMsg("Enviou carai");
        email.addTo("wfelipewill@hotmail.com");
        email.send();



    }

}
