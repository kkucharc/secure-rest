import services.PersonService;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/services")
public class RestApp extends Application{
    private Set<Object> services;

    public  RestApp(){
        services = new HashSet<Object>();
        services.add(new PersonService());
    }

    @Override
    public Set<Object> getSingletons(){
        return services;
    }
}
