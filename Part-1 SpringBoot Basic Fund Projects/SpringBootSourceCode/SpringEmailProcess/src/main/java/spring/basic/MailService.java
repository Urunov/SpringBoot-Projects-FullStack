package spring.basic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Created 23 / 03 / 2020 - 2:04 PM
 * @project SpringEmailProcess
 * @Author Hamdamboy
 */

@Component
public class MailService {
    //

    @Autowired
    private MailProperties mailProperties;

    public void print(){
        //
        System.out.println("Mail TO = " + mailProperties.getTo());
        System.out.println("HOST = " + mailProperties.getHost());
        System.out.println("PORT = " + mailProperties.getPort());
        System.out.println();


        //Print list or array
        System.out.println("Mail CC =" + String.join(", ", mailProperties.getCc()));
        System.out.println("MAIL BCC = " + mailProperties.getBcc());
        System.out.println();

        // Printed nested bean's properties
        System.out.println("User Name: " + mailProperties);
    }
}
