package com.recipe.recipeproject.controllers;

import com.recipe.recipeproject.Repositories.CategoryRepository;
import com.recipe.recipeproject.Repositories.RecipeRepository;
import com.recipe.recipeproject.Repositories.UnitOfMeasureRepository;
import com.recipe.recipeproject.model.Category;
import com.recipe.recipeproject.model.Recipe;
import com.recipe.recipeproject.model.UnitOfMeasure;
import com.recipe.recipeproject.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class IndexController {

    private RecipeService recipeService;

    @Autowired
    public IndexController(RecipeService recipeService) {
        this.recipeService= recipeService;
    }

    @RequestMapping({"","/","/index"})
    public String getIndexPage(Model model) {

        model.addAttribute("recipe",recipeService.getRecipe());


        return "index";
    }
}

