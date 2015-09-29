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
	   final String sql = "select *";
	   InitialContext ic;
	   Connection con = null;
	   Statement stmt = null;
	   ResultSet rs = null;
	   try {
		   ic = new InitialContext();
			DataSource ds = (DataSource) ic.lookup("java:/mydb");
		   con =  ((Statement) ds).getConnection();
		   stmt = con.createStatement();
		   rs = stmt.executeQuery(sql);
		   returnString = ("<test> Query '" + sql + "' returned " + rs.getString(1) + "</test>");
//		   }
	   } catch (Exception e) {
		   return "<failure>"+ e.toString() +"</failure>";
		// TODO Auto-generated catch block
	} finally {
	   			if(rs != null) rs.close();
	   			if(stmt != null) stmt.close();
	   			if(con != null) con.close();
	   	}
   
	   
      
      return returnString;
   }


}
