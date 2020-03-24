package spring.config.service;

/**
 * @Created 24 / 03 / 2020 - 2:44 PM
 * @project SpringBoot
 * @Author Hamdamboy
 */
public class MessageProcessImpl  implements MessageProcessor{
    //

    private MessageService messageService;
    public void setMessageService(MessageService messageService){
        this.messageService=messageService;
    }

    @Override
    public void processMsg(String message) {
        messageService.sendMsg(message);
    }
}
