package in.apptitute;

import in.apptitute.resources.ComingSoonController;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class DropwizardApplication extends Application<DropwizardConfiguration> {

    public static void main(final String[] args) throws Exception {
        new DropwizardApplication().run(args);
    }

    @Override
    public String getName() {
        return "dropwizard";
    }

    @Override
    public void initialize(final Bootstrap<DropwizardConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(DropwizardConfiguration configuration,
                    Environment environment) {
        final ComingSoonController resource = new ComingSoonController(
        );
        environment.jersey().register(resource);
    }

}
