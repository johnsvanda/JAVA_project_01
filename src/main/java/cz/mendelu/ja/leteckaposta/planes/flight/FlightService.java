package cz.mendelu.ja.leteckaposta.planes.flight;

import cz.mendelu.ja.leteckaposta.country.Country;
import cz.mendelu.ja.leteckaposta.country.CountryService;
import cz.mendelu.ja.leteckaposta.parcel.Parcel;
import cz.mendelu.ja.leteckaposta.parcel.ParcelRepository;
import cz.mendelu.ja.leteckaposta.planes.Plane;
import cz.mendelu.ja.leteckaposta.planes.PlaneRepository;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class FlightService {
    private final FlightRepository flightRepository;
    private final PlaneRepository planeRepository;

    private final ParcelRepository parcelRepository;
    private final CountryService countryService;

    @Autowired
    public FlightService(FlightRepository flightRepository, PlaneRepository planeRepository, ParcelRepository parcelRepository, CountryService countryService) {
        this.flightRepository = flightRepository;
        this.planeRepository = planeRepository;
        this.parcelRepository = parcelRepository;
        this.countryService = countryService;
    }

    @Autowired
    CommandLineRunner FlightService(FlightRepository flightRepository, PlaneRepository planeRepository, ParcelRepository parcelRepository, CountryService countryService){

        val flightService = new FlightService(flightRepository, planeRepository, parcelRepository, countryService);

        List<Plane> availablePlanes = planeRepository.findAll();
        List<Parcel> parcels = parcelRepository.findAll();
        List<Map<String, Object>> countries = countryService.getCountries();
        countries.stream().map(country -> (Country) country);
        System.out.println(availablePlanes);
        System.out.println(parcels);
        System.out.println(countries);
        return null;
    }

    public void addFlight() {


    }
}
