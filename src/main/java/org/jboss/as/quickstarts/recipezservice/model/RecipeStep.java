package org.jboss.as.quickstarts.recipezservice.model;

import java.io.Serializable;
import java.util.ArrayList;
import javax.xml.bind.annotation.*;

//@Entity
@XmlRootElement
//@Table(uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class RecipeStep implements Serializable {
   
   
	 @XmlElement(name = "recipeStepId", required = false)
   private String recipeStepId;
   
   //IN MINUTES
   private String preparationTime;
   @XmlElement(name = "description", required = false)
   private String description;
   
   @XmlElement(name = "ingredients", required = false)
   private ArrayList<String> ingredients;
   
   public RecipeStep(ArrayList<String> ingredients){
	   recipeStepId = "0";
	   description = "Melt cheese";
	   this.ingredients = ingredients;
   }

}