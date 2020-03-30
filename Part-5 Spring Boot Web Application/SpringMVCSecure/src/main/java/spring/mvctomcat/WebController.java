package spring.mvctomcat;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.validation.Valid;

/**
 * @Created 27 / 03 / 2020 - 4:19 PM
 * @project SpringMVCSecure
 * @Author Hamdamboy
 */
@Controller
public class WebController implements WebMvcConfigurer {
    //

    public void addViewController(ViewControllerRegistry registry){
        registry.addViewController("/results").setViewName("results");
    }

    @GetMapping("/")
    public String showForm(PersonalForm personalForm){
        return "form";
    }

    @PostMapping("/")
    public String checkPersonInfo(@Valid PersonalForm personalForm, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return "form";
        }
        return "redirect:/results";
    }
}
