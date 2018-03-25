package com.recipe.recipeproject.controllers;

import com.recipe.recipeproject.Repositories.CategoryRepository;
import com.recipe.recipeproject.Repositories.UnitOfMeasureRepository;
import com.recipe.recipeproject.model.Category;
import com.recipe.recipeproject.model.UnitOfMeasure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class IndexController {

    private CategoryRepository categoryRepository;
    private UnitOfMeasureRepository unitOfMeasureRepository;

    @Autowired
    public IndexController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @RequestMapping({"","/","/index"})
    public String getIndexPage() {

        Optional<Category> categoryOptional = categoryRepository.findByCategoryName("American");
        Optional<UnitOfMeasure> unitOfMeasureOptional = unitOfMeasureRepository.findByUom("Teaspoon");

        System.out.println("Cat id is " + categoryOptional.get().getId());
        System.out.println("Uom id is " + unitOfMeasureOptional.get().getId());


        return "index";
    }
}

