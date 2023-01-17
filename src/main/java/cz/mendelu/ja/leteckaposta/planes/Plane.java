package cz.mendelu.ja.leteckaposta.planes;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name="planes")
@Entity
public class Plane {
    @Id
    private String code;
    private double carryingCapacity;
    private double flyDistance;

    private String defaultLocation;

    private String currentLocation;

    public Plane(String code, double carryingCapacity, double flyDistance, String defaultLocation, String currentLocation) {

        this.code = code;
        this.carryingCapacity = carryingCapacity;
        this.flyDistance = flyDistance;
        this.defaultLocation = defaultLocation;
        this.currentLocation = currentLocation;
    }

    public Plane() {

    }
}

