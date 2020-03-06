package controller;

import model.Ingredient;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

public class DesignTacoController {

    @GetMapping
    public String showDesignForm(Model model) {
        List<Ingredient> ingredients = Arrays.asList(
                new Ingredient("Hamdamboy", "Flour ", Ingredient.Type.WRAP),
                new Ingredient("Urunov", "Flour Tortilla", Ingredient.Type.WRAP)
        );
    }
}
