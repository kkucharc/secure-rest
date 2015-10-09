package services;

import entity.Person;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

@Path("/person")
public class PersonService {
    private Map<Integer, Person> dataInMemory;
    public PersonService(){
        dataInMemory = new HashMap<Integer, Person>();
    }

    @POST
    @Consumes("application/xml")
    public Response savePerson(Person person){
        int id = dataInMemory.size() + 1;
        person.serId(id);
        dataInMemory.put(id, person);
        return Response.created(URI.create("/person/"+id)).build();
    }

    @GET
    @Path("{id}")
    @Produces("application/xml")
    public Person findById(@PathParam("id") int id){
        Person person = dataInMemory.get(id);
        if(person == null){
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        return person;
    }

}
