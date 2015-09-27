package org.jboss.as.quickstarts.recipezservice.model;

import java.io.Serializable;
import java.util.ArrayList;
import javax.xml.bind.annotation.*;

//@Entity
@XmlRootElement
//@Table(uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class User implements Serializable {
   
   
	 @XmlElement(name = "userId", required = false)
   private String userId;
  
   
   @XmlElement(name = "userName", required = false)
   private String userName;
      
   public Recipe(){
	   userId = "0";
	   userName = "Yolanda";
   }

}