package org.simplemart.product.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.codahale.metrics.annotation.Timed;

@Path("/product")
@Produces(MediaType.APPLICATION_JSON)
public class ProductResource {
    @GET
    @Path("{id}")
    @Timed
    public Product getProduct(@PathParam("id") String id) {
        Product p = new Product();
        p.setCaption(id);
        return p;
    }
}
