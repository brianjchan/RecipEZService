package org.jboss.as.quickstarts.recipezservice.rest;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.jboss.as.quickstarts.recipezservice.model.Recipe;

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
   public String listAllMembers() {
      // Use @SupressWarnings to force IDE to ignore warnings about "genericizing" the results of
      // this query
      @SuppressWarnings("unchecked")
      // We recommend centralizing inline queries such as this one into @NamedQuery annotations on
      // the @Entity class
      // as described in the named query blueprint:
      // https://blueprints.dev.java.net/bpcatalog/ee5/persistence/namedquery.html
      //final List<Recipe> results = em.createQuery("select m from Member m order by m.name").getResultList();
      String yo ="<text>YO<text/>";
      return yo;
   }

   @GET
   @Path("/{id:[0-9][0-9]*}")
   @Produces("text/xml")
   public Recipe lookupMemberById(@PathParam("id") long id) {
      return em.find(Recipe.class, id);
   }
}
