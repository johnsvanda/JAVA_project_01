package cz.mendelu.ja.leteckaposta.country;

import lombok.Data;

@Data
public class City {

    private final String name;
    private final double lat, lng;
}
