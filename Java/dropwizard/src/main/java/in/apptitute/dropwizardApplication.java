package in.apptitute;

import in.apptitute.resources.ComingSoonController;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class dropwizardApplication extends Application<dropwizardConfiguration> {

    public static void main(final String[] args) throws Exception {
        new dropwizardApplication().run(args);
    }

    @Override
    public String getName() {
        return "dropwizard";
    }

    @Override
    public void initialize(final Bootstrap<dropwizardConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(dropwizardConfiguration configuration,
                    Environment environment) {
        final ComingSoonController resource = new ComingSoonController(
        );
        environment.jersey().register(resource);
    }

}
