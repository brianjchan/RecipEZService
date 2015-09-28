package org.jboss.as.quickstarts.recipezservice.model;

import java.io.Serializable;
import java.util.ArrayList;
import javax.xml.bind.annotation.*;

//@Entity
@XmlRootElement
//@Table(uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class Ingredient implements Serializable {
   
   
	 @XmlElement(name = "ingredientId", required = false)
   private String ingredientID;
   
   @XmlElement(name = "ingredientName", required = false)
   private String ingredientName;
   
   @XmlElement(name = "ingredientAmount", required = false)
   private String ingredientAmount;
   
   public Ingredient(){
	   ingredientID = "0";
	   ingredientName = "Cheddar Cheese";
	   ingredientAmount = "10 oz";
   }

}