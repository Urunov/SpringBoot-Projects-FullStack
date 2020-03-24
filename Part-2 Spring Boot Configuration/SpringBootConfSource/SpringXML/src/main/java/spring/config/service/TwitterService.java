package spring.config.service;

/**
 * @Created 24 / 03 / 2020 - 2:44 PM
 * @project SpringBoot
 * @Author Hamdamboy
 */
public class TwitterService implements MessageService{
    //
    @Override
    public void sendMsg(String message) {
        System.out.println(message);
    }
}
