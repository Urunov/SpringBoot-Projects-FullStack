package spring.jersey.resource;

import org.springframework.beans.factory.annotation.Autowired;
import spring.jersey.domain.Customer;
import spring.jersey.service.CustomerService;
import java.net.URI;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.*;

/**
 * @Created 02 / 04 / 2020 - 3:30 PM
 * @project SpringJerseySimple
 * @Author Hamdamboy
 */

@Path("customers")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class CustomerResource {
    //
    @Autowired
    private CustomerService customerService;

    @GET
    public Response getAllCustomer(@QueryParam("fileName") String firstName, @QueryParam("lastName") String lastName) {

        List<Customer> customers;

        if(firstName !=null && lastName!=null){
            customers = customerService.findByFirstAndLastName(firstName, lastName);
        } else {
            customers = customerService.findAll();
        }
        return Response.ok(new GenericEntity<List<Customer>>(customers){
        }).build();
    }

//    @GET
//    @Path("/{id}")
//    public Response getCustomer(@PathParam("id") long id){
//        Customer customer = customerService.findOne(id);
//        if(customer==null){
//            throw new WebApplicationException(javax.ws.rs.core.Response.Status.NOT_FOUND);
//        }
//        return Response.ok(customer).build();
//    }

    @POST
    public Response createCustomer(Customer customer, @Context UriInfo uriInfo){
        customer = customerService.save(customer);
        long id = customer.getId();

        URI createURi = uriInfo.getAbsolutePathBuilder().path(Long.toString(id)).build();
        return Response.created(createURi).build();
    }

//    @PUT
//    @Path("/{id}")
//    public Response updateCustomer(@PathParam("id") long id, Customer customer){
//        Customer inDB = customerService.findOne(id);
//        if(inDB==null){
//            throw new WebApplicationException(javax.ws.rs.core.Response.Status.NOT_FOUND);
//        }
//
//        inDB.setFirstName(customer.getFirstName());
//        inDB.setLastName(customer.getLastName());
//        customerService.update(inDB);
//        return Response.noContent().build();
//    }

//    @DELETE
//    @Path("/{id}")
//    public Response deleteCustomer(@PathParam("id") long id) {
//        Customer inDB = customerService.findOne(id);
//        if(inDB==null){
//            throw new WebApplicationException(javax.ws.rs.core.Response.Status.NOT_FOUND);
//        }
//        customerService.delete(inDB);
//        return Response.ok().build();
//    }


}
