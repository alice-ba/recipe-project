package com.recipe.recipeproject.Bootstrap;

import com.recipe.recipeproject.Repositories.CategoryRepository;
import com.recipe.recipeproject.Repositories.RecipeRepository;
import com.recipe.recipeproject.Repositories.UnitOfMeasureRepository;
import com.recipe.recipeproject.model.*;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class RecipeBootstrap implements ApplicationListener<ContextRefreshedEvent> {
    private CategoryRepository categoryRepository;
    private UnitOfMeasureRepository unitOfMeasureRepository;
    private RecipeRepository recipeRepository;

    public RecipeBootstrap(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository, RecipeRepository recipeRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
        this.recipeRepository = recipeRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        recipeRepository.saveAll(getRecipe());
    }



    private List<Recipe> getRecipe(){

    List<Recipe>recipes = new ArrayList<>(2);

    //get UOMs
        Optional<UnitOfMeasure> teaUomOptional = unitOfMeasureRepository.findByUom("Teaspoon");
        if(!teaUomOptional.isPresent()){
            throw new RuntimeException("Expected Unit of measure not found");
        }

        Optional<UnitOfMeasure> tableUomOptional = unitOfMeasureRepository.findByUom("Tablespoon");
        if(!tableUomOptional.isPresent()){
            throw new RuntimeException("Expected Unit of measure not found");
        }

        Optional<UnitOfMeasure> cupUomOptional = unitOfMeasureRepository.findByUom("Cup");
        if(!cupUomOptional.isPresent()){
            throw new RuntimeException("Expected Unit of measure not found");
        }

        Optional<UnitOfMeasure> pinchUomOptional = unitOfMeasureRepository.findByUom("Pinch");
        if(!pinchUomOptional.isPresent()){
            throw new RuntimeException("Expected Unit of measure not found");
        }

        Optional<UnitOfMeasure> ounceUomOptional = unitOfMeasureRepository.findByUom("Ounce");
        if(!ounceUomOptional.isPresent()){
            throw new RuntimeException("Expected Unit of measure not found");
        }


        Optional<UnitOfMeasure> eachUomOptional = unitOfMeasureRepository.findByUom("Each");
        if(!eachUomOptional.isPresent()){
            throw new RuntimeException("Expected Unit of measure not found");
        }

        Optional<UnitOfMeasure> dashUomOptional = unitOfMeasureRepository.findByUom("Dash");
        if(!dashUomOptional.isPresent()){
            throw new RuntimeException("Expected Unit of measure not found");
        }

        Optional<UnitOfMeasure> pintUomOptional = unitOfMeasureRepository.findByUom("Pint");
        if(!pintUomOptional.isPresent()){
            throw new RuntimeException("Expected Unit of measure not found");
        }

       UnitOfMeasure teaspUom = teaUomOptional.get();
       UnitOfMeasure tablespUom = tableUomOptional.get();
       UnitOfMeasure cupUom = cupUomOptional.get();
       UnitOfMeasure pinchUom = pinchUomOptional.get();
       UnitOfMeasure ounceUom = ounceUomOptional.get();
       UnitOfMeasure eachUom = eachUomOptional.get();
       UnitOfMeasure dashUom = dashUomOptional.get();
       UnitOfMeasure pintUom = pintUomOptional.get();

       //get categories

        Optional<Category> americanCatOptional = categoryRepository.findByCategoryName("American");
        if(!americanCatOptional.isPresent()){
            throw new RuntimeException("Expected category not found");
        }
        Category americanCat = americanCatOptional.get();

        Optional<Category> italianCatOptional = categoryRepository.findByCategoryName("Italian");
        if(!italianCatOptional.isPresent()){
            throw new RuntimeException("Expected category not found");
        }
        Category italianCat = italianCatOptional.get();

        Optional<Category> mexicanCatOptional = categoryRepository.findByCategoryName("Mexican");
        if(!mexicanCatOptional.isPresent()){
            throw new RuntimeException("Expected category not found");
        }
        Category mexicanCat = mexicanCatOptional.get();

        Optional<Category> fastfoodCatOptional = categoryRepository.findByCategoryName("Fast Food");
        if(!fastfoodCatOptional.isPresent()){
            throw new RuntimeException("Expected category not found");
        }
        Category fastfoodCat = fastfoodCatOptional.get();



        //guacamole recipe
        Recipe guacamole = new Recipe();
        guacamole.setName("Perfect Guacamole");
        guacamole.getCategories().add(mexicanCat);
        guacamole.getCategories().add(americanCat);
        guacamole.setDescription("Guacamole, a dip made from avocados, is originally from Mexico. The name is derived from two Aztec Nahuatl words—ahuacatl (avocado) and molli (sauce).\n" +
                "All you really need to make guacamole is ripe avocados and salt. After that, a little lime or lemon juice—a splash of acidity— will help to balance the richness of the avocado. Then if you want, add chopped cilantro, chiles, onion, and/or tomato.\n" +
                "The trick to making perfect guacamole is using good, ripe avocados.\n" +
                "Check for ripeness by gently pressing the outside of the avocado. If there is no give, the avocado is not ripe yet and will not taste good. If there is a little give, the avocado is ripe. If there is a lot of give, the avocado may be past ripe and not good. In this case, taste test first before using.");
        guacamole.setCookTime(10);
        guacamole.setDifficulty(Difficulty.EASY);
        guacamole.setDirections("1 Cut avocado, remove flesh: Cut the avocados in half. Remove seed. Score the inside of the avocado with a blunt knife and scoop out the flesh with a spoon. (See How to Cut and Peel an Avocado.) Place in a bowl.\n" +
                "\n" +
                "2 Mash with a fork: Using a fork, roughly mash the avocado. (Don't overdo it! The guacamole should be a little chunky.)\n" +
                "\n" +
                "3 Add salt, lime juice, and the rest: Sprinkle with salt and lime (or lemon) juice. The acid in the lime juice will provide some balance to the richness of the avocado and will help delay the avocados from turning brown.\n" +
                "\n" +
                "Add the chopped onion, cilantro, black pepper, and chiles. Chili peppers vary individually in their hotness. So, start with a half of one chili pepper and add to the guacamole to your desired degree of hotness.\n" +
                "\n" +
                "Remember that much of this is done to taste because of the variability in the fresh ingredients. Start with this recipe and adjust to your taste.\n" +
                "\n" +
                "4 Cover with plastic and chill to store: Place plastic wrap on the surface of the guacamole cover it and to prevent air reaching it. (The oxygen in the air causes oxidation which will turn the guacamole brown.) Refrigerate until ready to serve.\n" +
                "\n" +
                "Chilling tomatoes hurts their flavor, so if you want to add chopped tomato to your guacamole, add it just before serving.");
        Note guaNotes = new Note();
        guaNotes.setNotes("Feel free to experiment! One classic Mexican guacamole has pomegranate seeds and chunks of peaches in it (a Diana Kennedy favorite). Try guacamole with added pineapple, mango, or strawberries (see our Strawberry Guacamole).\n" +
                "\n" +
                "The simplest version of guacamole is just mashed avocados with salt. Don't let the lack of availability of other ingredients stop you from making guacamole.\n" +
                "\n" +
                "To extend a limited supply of avocados, add either sour cream or cottage cheese to your guacamole dip. Purists may be horrified, but so what? It tastes great.\n" +
                "\n" +
                "For a deviled egg version with guacamole, try our Guacamole Deviled Eggs!");
        guaNotes.setRecipe(guacamole);
        guacamole.setNote(guaNotes);

        guacamole.getIngredients().add(new Ingredient("ripe avocado", new BigDecimal(2), eachUom ,guacamole) );
        guacamole.getIngredients().add(new Ingredient("Kosher salt", new BigDecimal(0.5), teaspUom ,guacamole));
        guacamole.getIngredients().add(new Ingredient("fresh lime juice or lemon juice", new BigDecimal(1),tablespUom ,guacamole));
        guacamole.getIngredients().add(new Ingredient("minced red onion or thinly sliced green onion", new BigDecimal(2),tablespUom ,guacamole));
        guacamole.getIngredients().add(new Ingredient("serrano chiles, stems and seeds removed, minced", new BigDecimal(2), eachUom ,guacamole) );
        guacamole.getIngredients().add(new Ingredient("cilantro (leaves and tender stems), finely chopped", new BigDecimal(2), eachUom ,guacamole) );
        guacamole.getIngredients().add(new Ingredient("freshly grated black pepper", new BigDecimal(1), dashUom ,guacamole) );
        guacamole.getIngredients().add(new Ingredient("ripe tomato, seeds and pulp removed, chopped", new BigDecimal(0.5), eachUom ,guacamole) );

        recipes.add(guacamole);

        //Spicy Grilled Chicken Tacos
        Recipe sgct = new Recipe();
        sgct.setName("Chicken grilled Tacos");
        sgct.getCategories().add(americanCat);
        sgct.setCookTime(30);
        sgct.setDescription("Spicy grilled chicken tacos! Quick marinade, then grill. Ready in about 30 minutes. Great for a quick weeknight dinner, backyard cookouts, and tailgate parties.\n" +
        "We have a family motto and it is this: Everything goes better in a tortilla.\n" +
                "\n" +
                "Any and every kind of leftover can go inside a warm tortilla, usually with a healthy dose of pickled jalapenos. I can always sniff out a late-night snacker when the aroma of tortillas heating in a hot pan on the stove comes wafting through the house.\n" +
                "\n" +
                "Today’s tacos are more purposeful – a deliberate meal instead of a secretive midnight snack!\n" +
                "\n" +
                "First, I marinate the chicken briefly in a spicy paste of ancho chile powder, oregano, cumin, and sweet orange juice while the grill is heating. You can also use this time to prepare the taco toppings.\n" +
                "\n" +
                "Grill the chicken, then let it rest while you warm the tortillas. Now you are ready to assemble the tacos and dig in. The whole meal comes together in about 30 minutes!");

        Note sgctNote = new Note();
        sgctNote.setNotes("Look for ancho chile powder with the Mexican ingredients at your grocery store, on buy it online. (If you can't find ancho chili powder, you replace the ancho chili, the oregano, and the cumin with 2 1/2 tablespoons regular chili powder, though the flavor won't be quite the same.)");
        sgctNote.setRecipe(sgct);
        sgct.setNote(sgctNote);
        sgct.setDifficulty(Difficulty.EASY);

        sgct.setDirections("1 Prepare a gas or charcoal grill for medium-high, direct heat.\n" +
                "\n" +
                "2 Make the marinade and coat the chicken: In a large bowl, stir together the chili powder, oregano, cumin, sugar, salt, garlic and orange zest. Stir in the orange juice and olive oil to make a loose paste. Add the chicken to the bowl and toss to coat all over.\n" +
                "\n" +
                "Set aside to marinate while the grill heats and you prepare the rest of the toppings.\n" +
                "\n" +
                "3 Grill the chicken: Grill the chicken for 3 to 4 minutes per side, or until a thermometer inserted into the thickest part of the meat registers 165F. Transfer to a plate and rest for 5 minutes.\n" +
                "\n" +
                "4 Warm the tortillas: Place each tortilla on the grill or on a hot, dry skillet over medium-high heat. As soon as you see pockets of the air start to puff up in the tortilla, turn it with tongs and heat for a few seconds on the other side.\n" +
                "\n" +
                "Wrap warmed tortillas in a tea towel to keep them warm until serving.\n" +
                "\n" +
                "5 Assemble the tacos: Slice the chicken into strips. On each tortilla, place a small handful of arugula. Top with chicken slices, sliced avocado, radishes, tomatoes, and onion slices. Drizzle with the thinned sour cream. Serve with lime wedges.\n");
        sgct.getIngredients().add(new Ingredient("ancho chili powder", new BigDecimal(2), tablespUom, sgct));
        sgct.getIngredients().add(new Ingredient("dried oregano", new BigDecimal(1), teaspUom, sgct));
        sgct.getIngredients().add(new Ingredient("dried cumin", new BigDecimal(1), teaspUom, sgct));
        sgct.getIngredients().add(new Ingredient("sugar", new BigDecimal(1), teaspUom, sgct));
        sgct.getIngredients().add(new Ingredient("salt", new BigDecimal(0.5), teaspUom, sgct));
        sgct.getIngredients().add(new Ingredient("clove garlic, finely chopped", new BigDecimal(1), eachUom, sgct));
        sgct.getIngredients().add(new Ingredient("finely grated orange zest", new BigDecimal(1), tablespUom, sgct));
        sgct.getIngredients().add(new Ingredient("fresh-squeezed orange juice", new BigDecimal(3), tablespUom, sgct));
        sgct.getIngredients().add(new Ingredient("olive oil", new BigDecimal(2), tablespUom, sgct));
        sgct.getIngredients().add(new Ingredient("skinless, boneless chicken thighs (1 1/4 pounds)", new BigDecimal(4), eachUom, sgct));
        sgct.getIngredients().add(new Ingredient("small corn tortillas", new BigDecimal(8), eachUom, sgct));
        sgct.getIngredients().add(new Ingredient("packed baby arugula (3 ounces)", new BigDecimal(3), cupUom, sgct));
        sgct.getIngredients().add(new Ingredient("medium ripe avocados, sliced", new BigDecimal(2), eachUom, sgct));
        sgct.getIngredients().add(new Ingredient("radishes, thinly sliced", new BigDecimal(4), eachUom, sgct));
        sgct.getIngredients().add(new Ingredient("cherry tomatoes, halved", new BigDecimal(0.5), pintUom, sgct));
        sgct.getIngredients().add(new Ingredient("red onion, thinly sliced", new BigDecimal(0.25), eachUom, sgct));
        sgct.getIngredients().add(new Ingredient("Roughly chopped cilantro", new BigDecimal(1), eachUom, sgct));
        sgct.getIngredients().add(new Ingredient("sour cream", new BigDecimal(0.5), cupUom, sgct));
        sgct.getIngredients().add(new Ingredient("milk", new BigDecimal(0.25), cupUom, sgct));
        sgct.getIngredients().add(new Ingredient("lime, cut into wedges", new BigDecimal(1), eachUom, sgct));

        recipes.add(sgct);
        return(recipes);
    }
}
