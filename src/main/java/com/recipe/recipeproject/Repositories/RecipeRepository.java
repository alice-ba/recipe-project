package com.recipe.recipeproject.Repositories;

import com.recipe.recipeproject.model.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe,Long>{
}
