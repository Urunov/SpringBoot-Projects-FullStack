package com.urunov.controller.web;

import com.urunov.constants.GeneralConstants;
import com.urunov.constants.PusherConstants;
import com.urunov.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

/**
 * User: hamdamboy
 * Project: card
 * Github: @urunov
 */
@Controller
@SessionAttributes(GeneralConstants.ID_SESSION_SHOPPING_CART)
public class IndexController {

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public ModelAndView index(Model model) {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("index");
        modelAndView.addObject("pusher_app_key", PusherConstants.PUSHER_APP_KEY);
        modelAndView.addObject("pusher_channel", PusherConstants.CHANNEL_NAME);

        if (!model.containsAttribute(GeneralConstants.ID_SESSION_SHOPPING_CART)) {
            model.addAttribute(GeneralConstants.ID_SESSION_SHOPPING_CART, new ArrayList<Product>());
        }
            return modelAndView;
        }
    }
