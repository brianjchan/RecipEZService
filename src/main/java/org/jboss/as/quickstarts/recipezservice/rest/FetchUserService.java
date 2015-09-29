package org.jboss.as.quickstarts.recipezservice.rest;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.activation.DataSource;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;


import org.jboss.as.quickstarts.recipezservice.model.User;

/**
 * JAX-RS Example
 * 
 * This class produces a RESTful service to read the contents of the members table.
 */
@Path("/users")
@RequestScoped
public class FetchUserService {
   @Inject
   private EntityManager em;

   @GET
   @Produces("text/xml")
   public String listAllMembers() throws SQLException {
	   String returnString = "";
	   final String sql = "SELECT * FROM Users";
	   InitialContext ic;
	   Connection con = null;
	   Statement stmt = null;
	   ResultSet rs = null;
	   User u = new User();
	   try {
		   ic = new InitialContext();
		   javax.sql.DataSource ds = (javax.sql.DataSource) ic.lookup("java:jboss/datasources/MySQLDS");
		   con =  ds.getConnection();
		   stmt = con.createStatement();
		   rs = stmt.executeQuery(sql);
		   String name, id;
		   while (rs.next()) {
			   name = rs.getString("username");
			   id = rs.getString("user_id");
			   u = new User(id, name);
		   }
//		   }
	   } catch (Exception e) {
		   return "<failure>"+ e.toString() +"</failure>";
		// TODO Auto-generated catch block
	} finally {
	   			if(rs != null) rs.close();
	   			if(stmt != null) stmt.close();
	   			if(con != null) con.close();
	   	}
   
      return u.toString();
   }


}
