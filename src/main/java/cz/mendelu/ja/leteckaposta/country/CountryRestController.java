package cz.mendelu.ja.leteckaposta.country;

import cz.mendelu.ja.leteckaposta.utils.Response;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/country")
class CountryRestController {

    @GetMapping("/{cca3:[A-Z0-9]{3}}")
    @ResponseStatus(HttpStatus.OK)
    Response<Country> getByCca3(
            @PathVariable String cca3
    ) {
        return Response.of(new Country(cca3));
    }



}
