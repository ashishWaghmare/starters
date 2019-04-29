package micronaut;
import io.micronaut.http.HttpRequest
import io.micronaut.http.client.RxHttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.test.annotation.*
import spock.lang.*
import javax.inject.Inject

@MicronautTest
class HelloSpec extends Specification {

    @Inject
    @Client('/')
    RxHttpClient client 

    @Unroll
    void "should compute #num to #square"() {
        when:
        String result = client.toBlocking().retrieve(HttpRequest.GET('/hello'), String) 
        then:
        result == "Hello Wssorld"
    }
}