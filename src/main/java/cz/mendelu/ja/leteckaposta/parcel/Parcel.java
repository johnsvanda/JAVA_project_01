package cz.mendelu.ja.leteckaposta.parcel;

import cz.mendelu.ja.leteckaposta.country.City;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Data
@Table(name = "parcels")
@Entity
public class Parcel {
@Id
@GeneratedValue(generator = "system-uuid")
@GenericGenerator(name = "system-uuid", strategy = "uuid")
    private UUID id;
    private String destination;
    private Double weight;
    private String location;

    public Parcel(){

    }
    public Parcel(String destination, Double weight, String location){
        this.destination = destination;
        this.weight = weight;
        this.location = location;
    }
}
