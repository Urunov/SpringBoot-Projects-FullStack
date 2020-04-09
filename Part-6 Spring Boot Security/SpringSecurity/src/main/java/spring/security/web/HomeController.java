package spring.security.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import spring.security.entities.Message;
import spring.security.repository.MessageRepository;

/**
 * @Created 09 / 04 / 2020 - 2:18 PM
 * @project SpringSecurity
 * @Author Hamdamboy
 */
@Controller
public class HomeController {

    //
    @Autowired
    private MessageRepository messageRepository;

    @GetMapping("/home")
    public String home(Model model){
        model.addAttribute("msgs", messageRepository.findAll());
        return "userhome";
    }

    @PostMapping("/message")
    public String saveMessage(Message message){

        messageRepository.save(message);
        return "redirect:/home";
    }
}
