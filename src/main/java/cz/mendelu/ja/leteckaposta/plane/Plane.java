package cz.mendelu.ja.leteckaposta.plane;

import cz.mendelu.ja.leteckaposta.country.City;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

@Data
public class Plane {

    private final String code;
    private final double carryingCapacity;
    private final double flyDistance;
    private final City defaultLocation;

}

