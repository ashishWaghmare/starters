

## Dropwizard
mvn archetype:generate -DarchetypeGroupId=io.dropwizard.archetypes -DarchetypeArtifactId=java-simple -DarchetypeVersion=1.3.9

## Netty
mvn archetype:generate -DgroupId=io.apptitude -DartifactId=netty -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.4 -DinteractiveMode=false

## Jetty
Too low level and complicated. Abandoning for now

## Micronaut
sdk install micronaut
mn create-app micronaut
