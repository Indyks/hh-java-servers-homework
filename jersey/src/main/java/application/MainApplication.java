package application;

import resource.MainResource;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MainApplication extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        return new HashSet(List.of(MainResource.class));
    }
}
