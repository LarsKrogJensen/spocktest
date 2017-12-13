package se.lars

import spock.lang.Specification

class TestSpec extends Specification {
    def "test"() {
        given:
        def dependency = Mock(Dependency)
        def service = new Service(dependency)

        when:
        service.update("sailing")

        then:
        1 *  dependency.update({value -> value == "sailing"})
    }
}