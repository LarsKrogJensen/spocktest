package se.lars

import io.vertx.core.Vertx
import spock.lang.Specification
import spock.util.concurrent.AsyncConditions

class TestVerticleSpec extends Specification {
    Vertx vertx;

    void setup() {
        vertx = VertxTestUtil.vertx()
    }

    void cleanup() {
        vertx.close()
    }

    def "Should deploy"() {
        given:
        Service service = Mock() {
            2 * update(_) >>> ["junk","jnk2"]
        }
        def async = new AsyncConditions()


        when:
        vertx.deployVerticle(new TestVerticle(service)) { deployRes ->
            async.evaluate {
                assert deployRes.succeeded()
            }
        }

        then:
        async.await(2)
    }
}
