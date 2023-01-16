package cz.mendelu.ja.leteckaposta.planes.flight;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

import java.util.UUID;

@Data
@Table(name = "flights")
@Entity
public class Flight {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;
    private String plane;
    private String number;
    private String departure;
    private String destination;
//    @OneToMany
//    private List<Parcel> parcels;
    public Flight(){

    }
    public Flight(String plane, String number, String departure, String destination){
        this.plane = plane;
        this.number = number;
        this.departure = departure;
        this.destination = destination;
    }
}
