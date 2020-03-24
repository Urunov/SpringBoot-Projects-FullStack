package spring.config.service;

/**
 * @Created 24 / 03 / 2020 - 2:42 PM
 * @project SpringBoot
 * @Author Hamdamboy
 */
public class EmailService implements MessageService {
    //
    public void sendMsg(String message) {
        System.out.println(message);
    }
}
