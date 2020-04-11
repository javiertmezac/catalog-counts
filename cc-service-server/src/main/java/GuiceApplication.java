import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;

import javax.ws.rs.core.Application;
import java.util.Set;

public abstract class GuiceApplication extends Application {

    @Override
    public Set<Object> getSingletons () {
        Injector injector = Guice.createInjector(modules());
       return serviceInstances(injector);
    }

    protected abstract Set<Module> modules();
    protected abstract Set<Object> serviceInstances(Injector injector);
}
