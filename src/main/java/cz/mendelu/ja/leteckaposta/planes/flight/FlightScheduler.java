package cz.mendelu.ja.leteckaposta.planes.flight;

import cz.mendelu.ja.leteckaposta.parcel.Parcel;
import cz.mendelu.ja.leteckaposta.parcel.ParcelRepository;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.List;

@Configuration
@EnableScheduling
public class FlightScheduler {

    private final ParcelRepository parcelRepository;
    private final FlightService flightService;
    private final FlightRepository flightRepository;

    public FlightScheduler(ParcelRepository parcelRepository, FlightService flightService, FlightRepository flightRepository) {

        this.parcelRepository = parcelRepository;
        this.flightService = flightService;
        this.flightRepository = flightRepository;
    }

    /**
     * Service schedules new flights
     */
    @Scheduled(fixedRate = 10000)
    public void scheduleFlights() {
        List<Parcel> parcels = parcelRepository.findAll();
        List<Flight> flights = flightRepository.findAll();
        System.out.println(parcels);
        for (Parcel parcel : parcels) {
            if (flights.stream().anyMatch(flight -> flight.getNumber().contains(parcel.getId()))) {
                //parcel is already conatined in a flight
            } else {
                String flightId = flightService.addFlight(parcel.getId());
                System.out.println(String.format("##################### New flight %s scheduled #############", flightId));
            }

        }

    }

}
