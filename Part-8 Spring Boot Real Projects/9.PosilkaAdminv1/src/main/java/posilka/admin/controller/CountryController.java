package posilka.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import posilka.admin.model.Country;
import posilka.admin.service.CountryService;

import java.util.List;

/**
 * @Created 07 / 05 / 2020 - 1:40 PM
 * @project AdminPage
 * @Author Hamdamboy
 */
@Controller
public class CountryController {

    @Autowired
    private CountryService countryService;

    @RequestMapping("/")
    public String viewHome(Model model){
        List<Country> countryList = countryService.listAll();
        model.addAttribute("countryList", countryList);
        return "index";
    }

    @RequestMapping("/new")
    public String showNewProductPage(Model model){
        Country country = new Country();
        model.addAttribute("country", country);

        return "new_country";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveCountry(@ModelAttribute("country") Country country){
        countryService.save(country);

        return "redirect:/";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditEmployeePage(@PathVariable(name = "id") int id){
        ModelAndView mav = new ModelAndView("edit_country");
        Country country = countryService.get(id);
        mav.addObject("country", country);

        return mav;
    }

    @RequestMapping(value = "/delete/{id}")
    public String deleteCountry(@PathVariable(name = "id") int id){
        countryService.delete(id);

        return "redirect:/";
    }

}