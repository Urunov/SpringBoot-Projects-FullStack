package posilka.admin.controller;

        import org.springframework.stereotype.Controller;
        import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Created 06 / 05 / 2020 - 12:01 PM
 * @project AdminPage
 * @Author Hamdamboy
 */

@Controller
public class AdminController {

    @GetMapping("/admin")
    public String loginPage(){
        return "admin/index";
    }

}
