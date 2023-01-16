package cz.mendelu.ja.leteckaposta.planes.flight;

import cz.mendelu.ja.leteckaposta.planes.flight.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlightService {
    private final FlightRepository flightRepository;
    @Autowired
    public FlightService(FlightRepository flightRepository){
        this.flightRepository = flightRepository;
    }

    public void addFlight(){

    }
}
