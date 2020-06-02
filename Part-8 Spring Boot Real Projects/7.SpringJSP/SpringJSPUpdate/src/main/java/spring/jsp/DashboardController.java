package spring.jsp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;

/**
 * @Created 22 / 05 / 2020 - 3:45 PM
 * @project SpringJSPUpdate
 * @Author Hamdamboy
 */
@Controller
public class DashboardController {

    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public ModelAndView welcome(){
        ModelAndView model = new ModelAndView();
        model.setViewName("welcome");
        return model;
    }

    private List getUsers() {

        User user = new User();
        user.setEmail("johndoe123@gmail.com");
        user.setName("John Doe");
        user.setAddress("Bangalore, Karnataka");

        User user1 = new User();
        user1.setEmail("amitsingh@yahoo.com");
        user1.setName("Amit Singh");
        user1.setAddress("Chennai, Tamilnadu");

        User user2 = new User();
        user2.setEmail("bipulkumar@gmail.com");
        user2.setName("Bipul Kumar");
        user2.setAddress("Bangalore, Karnataka");

        User user3 = new User();
        user3.setEmail("prakashranjan@gmail.com");
        user3.setName("Prakash Ranjan");
        user3.setAddress("Chennai, Tamilnadu");

        return Arrays.asList(user, user1, user2, user3);
    }
}
