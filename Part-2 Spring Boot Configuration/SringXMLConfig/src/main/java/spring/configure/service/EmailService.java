package spring.configure.service;

/**
 * @Created 30 / 03 / 2020 - 10:14 AM
 * @project SpringXMLCongif
 * @Author Hamdamboy
 */
public class EmailService implements MessageService{
    @Override
    public void sendMsg(String message) {
        System.out.println(message);
    }
}
