package spring.configure.service;

import spring.configure.model.Message;

/**
 * @Created 30 / 03 / 2020 - 10:14 AM
 * @project SpringXMLCongif
 * @Author Hamdamboy
 */
public class MessageProcessorImpl implements MessageProcessor {
    //
    private MessageService messageService;

    public void setMessageService(MessageService messageService) {
        this.messageService = messageService;
    }

    @Override
    public void processMsg(String message) {
        messageService.sendMsg(message);
     }
    }
