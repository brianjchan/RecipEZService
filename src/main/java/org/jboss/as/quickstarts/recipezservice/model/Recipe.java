package org.jboss.as.quickstarts.recipezservice.model;

import java.io.Serializable;
import java.util.ArrayList;
import javax.xml.bind.annotation.XmlRootElement;


//@Entity
@XmlRootElement
//@Table(uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class Recipe implements Serializable {

   private String id;
   
   private String name;
	
	 @XmlElement(name = "serving size", required = false)
   private String servingSize;
   
   //IN MINUTES
   private String preparationTime;
   @XmlElement(name = "ingredients", required = false)
   private ArrayList<String> ingredients;
   
   @XmlElement(name = "instructions", required = false)
   private ArrayList<String> instructions;
   
   public Recipe(){
	   id = "0";
	   name = "Speedy Sticky Lemon Chicken";
	   servingSize = "2";
	   preparationTime = "unspecified";
	   
	   ingredients = new ArrayList<String>();
	   instructions = new ArrayList<String>();
	   
	   ingredients.add("2 chicken breast fillet chunks, skinless and boneless");
	   ingredients.add("1 small red pepper, sliced");
	   ingredients.add("Small handful fine beans");
	   ingredients.add("Small handful tenderstem broccoli");
	   ingredients.add("250ml hot chicken stock");
	   ingredients.add("Juice of 1 lemon");
	   ingredients.add("1 tbsp soy sauce");
	   ingredients.add("1 tbsp honey");
	   ingredients.add("1 tbsp cornflour");
	   ingredients.add("150g steamed basmati rice to serve");
	   
	   instructions.add("1) Stir the lemon juice, soy sauce and honey into the stock and set aside.)"
	   		+ "2) Put the cornflour in a small bowl and roll the chicken around in it to coat."
	   		+ "3) Fry the chicken in a hot wok for a few minutes, followed by all of the veg."
	   		+ "4) Pour in the lemon stock mixture and simmer for about 5 minutes until everything is cooked through and hot."
	   		+ "5) Serve with steamed basmati rice.");
   }

   public String getId() {
      return id;
   }

   public void setId(String id) {
      this.id = id;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }
}