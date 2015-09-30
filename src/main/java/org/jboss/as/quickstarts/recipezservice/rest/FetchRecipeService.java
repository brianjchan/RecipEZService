package org.jboss.as.quickstarts.recipezservice.rest;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.naming.InitialContext;
import javax.persistence.EntityManager;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.jboss.as.quickstarts.recipezservice.model.Recipe;
import org.jboss.as.quickstarts.recipezservice.model.User;

/**
 * JAX-RS Example
 * 
 * This class produces a RESTful service to read the contents of the members table.
 */
@Path("/recipes")
@RequestScoped
public class FetchRecipeService {
   @Inject
   private EntityManager em;

   @GET
   @Produces("text/xml")
   public ArrayList<Recipe> listAllMembers() throws SQLException {
	   ArrayList<Recipe> recipes = new ArrayList<Recipe>();
	   final String sql = "Select * From Recipes rec"
	   		+ "Left Join Recipe_Steps r_steps"
	   		+ "On rec.recipe_id = r_steps.recipe_id"
	   		+ "Left Join Recipe_Step_Ingredients r_s_i"
	   		+ "On r_steps.recipe_id = r_s_i.recipe_id AND r_steps.step_number = r_s_i.step_number";
	   InitialContext ic;
	   Connection con = null;
	   Statement stmt = null;
	   ResultSet rs = null;
	   Recipe recipe = new Recipe();
	   try {
		   ic = new InitialContext();
		   javax.sql.DataSource ds = (javax.sql.DataSource) ic.lookup("java:jboss/datasources/MySQLDS");
		   con =  ds.getConnection();
		   stmt = con.createStatement();
		   rs = stmt.executeQuery(sql);
		   String recipeID, recipeName, instruction;
		   int stepNumber;
		   while (rs.next()) {
			   recipeID = rs.getString("recipe_name");
			   recipeName = rs.getString("recipe_id");
			   stepNumber = rs.getInt("step_number");
			   instruction = rs.getString("instructions");
			   
			   if(RecipeAlreadyInList(recipeID, recipes))AddStepToRecipeList(recipes, recipeID, stepNumber, instruction);
			   else
			   {
				   recipe = new Recipe(recipeName, recipeID, stepNumber, instruction);
				   recipes.add(recipe);
			   }
		   }
//		   }
	   } catch (Exception e) {
		   
		// TODO Auto-generated catch block
	} finally {
	   			if(rs != null) rs.close();
	   			if(stmt != null) stmt.close();
	   			if(con != null) con.close();
	   	}
   
      return recipes;
   }

   private void AddStepToRecipeList(ArrayList<Recipe> recipes, String recipeID, int stepNumber,String instruction) 
   {
	   int elementNumber = GetElementNumber(recipes, recipeID);
	   if(elementNumber == -1) return; //NotFound
	   recipes.get(elementNumber).getInstructions().add(stepNumber, instruction);
   }

   private int GetElementNumber(ArrayList<Recipe> recipes, String recipeID) {
	   for(Recipe r : recipes)
	   {
		   if(r.getId().equals(recipeID)) return recipes.indexOf(r);
	   }
	   return -1;
   }

//@GET
//   @Path("/{id:[0-9][0-9]*}")
//   @Produces("text/xml")
//   public Recipe lookupMemberById(@PathParam("id") long id) {
//      return em.find(Recipe.class, id);
//   }
   
   public boolean RecipeAlreadyInList(String recipeID, ArrayList<Recipe> recipes)
   {
	   for(Recipe r : recipes)
	   {
		   if(r.getId().equals(recipeID)) return true;
	   }
	   return false;
   }
}
