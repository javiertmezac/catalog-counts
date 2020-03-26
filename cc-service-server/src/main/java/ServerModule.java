import com.google.inject.AbstractModule;
import com.jtmc.apps.reforma.guice.MyBatisConfigModule;

public class ServerModule extends AbstractModule {

    @Override
    protected void configure() {
        install(new MyBatisConfigModule());
    }
}
