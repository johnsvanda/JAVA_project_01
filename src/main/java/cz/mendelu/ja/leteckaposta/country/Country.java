package cz.mendelu.ja.leteckaposta.country;

import lombok.Data;

import java.util.Collection;

@Data
public
class Country {

    private final String cca3;
    private Collection<Country> borders;
    private City capital;

    public Country(String cca3) {
        this.cca3 = cca3;
    }

    public Country() {

        cca3 = null;
    }
}
