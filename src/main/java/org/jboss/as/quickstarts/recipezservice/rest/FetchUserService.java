package org.jboss.as.quickstarts.recipezservice.rest;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
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
   public User listAllMembers() {
      // Use @SupressWarnings to force IDE to ignore warnings about "genericizing" the results of
      // this query
      @SuppressWarnings("unchecked")
     
      User testUse = new User();
      return testUse;
   }


}
