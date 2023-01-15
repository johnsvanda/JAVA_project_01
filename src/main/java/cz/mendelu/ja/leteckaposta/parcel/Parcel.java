package cz.mendelu.ja.leteckaposta.parcel;

import cz.mendelu.ja.leteckaposta.country.City;
import lombok.Data;

import java.util.UUID;

@Data
public class Parcel {

    private final UUID id;
    private final City destination;
    private double weight;
    private City location;

}
