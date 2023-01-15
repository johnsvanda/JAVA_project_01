package cz.mendelu.ja.leteckaposta.country

import org.springframework.jdbc.core.JdbcTemplate;
import spock.lang.Specification;

import static org.junit.jupiter.api.Assertions.*;

class CountryServiceTest extends Specification {

    private CountryService countryService;
    private JdbcTemplate jdbcTemplate;

    def setup() {
        countryService = new CountryService(
                jdbcTemplate = Mock(JdbcTemplate)
        )
        countryService.url = "https://restcountries.com/v3.1/region/"
    }

    void deleteAllCountries() {
        given:
        def a = 1
        when:
        def r = a + 1
        then:
        r == 2
    }

    def "Basic fetchCountries test"() {
        when:
        def r = countryService.fetchCountries("europe");
        then:
        r.size() == 53
        2 * jdbcTemplate.batchUpdate(_,_,_,_)
    }
}