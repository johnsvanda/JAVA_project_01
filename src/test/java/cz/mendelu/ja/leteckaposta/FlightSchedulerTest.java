package cz.mendelu.ja.leteckaposta;

import cz.mendelu.ja.leteckaposta.parcel.Parcel;
import cz.mendelu.ja.leteckaposta.parcel.ParcelRepository;
import cz.mendelu.ja.leteckaposta.planes.flight.Flight;
import cz.mendelu.ja.leteckaposta.planes.flight.FlightRepository;
import cz.mendelu.ja.leteckaposta.planes.flight.FlightScheduler;
import cz.mendelu.ja.leteckaposta.planes.flight.FlightService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;


@SpringBootTest
public class FlightSchedulerTest {
    @Autowired
    private FlightScheduler flightScheduler;

    @MockBean
    private ParcelRepository parcelRepository;

    @MockBean
    private FlightRepository flightRepository;

    @MockBean
    private FlightService flightService;

    @Test
    public void scheduleFlightsTest() {
        Parcel parcel1 =
                new Parcel("CZE",
                2165156.0,
                "EST");
        Parcel parcel2 =
                new Parcel("RUS",
                2165156.0,
                "EST");

        List<Parcel> parcels = Arrays.asList(parcel1, parcel2);

        Flight flight1 = new Flight("CU-V1005", "CU-V10054028803285be8b760185be8c04ce0000", "EST", "CZE");
        Flight flight2 = new Flight("OO-BKB", "OO-BKB4028803285be8b760185be8c04ce0000", "RUS", "CZE");

        List<Flight> flights = Arrays.asList(flight1, flight2);

        when(parcelRepository.findAll()).thenReturn(parcels);
        when(flightRepository.findAll()).thenReturn(flights);

        flightScheduler.scheduleFlights();


    }
}
