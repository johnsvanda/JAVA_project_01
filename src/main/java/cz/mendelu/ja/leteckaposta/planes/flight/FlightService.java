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
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
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
    CommandLineRunner FlightService(FlightRepository flightRepository, PlaneRepository planeRepository, ParcelRepository parcelRepository, CountryService countryService) {

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

    /**
     * @param parcelId - Assign a flight to a given parcel
     * */
    @Transactional
    public String addFlight(String parcelId) {
        Parcel p = parcelRepository.getReferenceById(parcelId);
        String parcelDepatrure = p.getLocation();
        Double parcelDepartureLat = countryService.getCountryLat(parcelDepatrure);
        Double parcelDepartureLon = countryService.getCountryLon(parcelDepatrure);
        List<Plane> availablePlanes = planeRepository.findAll();
        double minDistance = 999999999;
        Plane minPlane = new Plane();

        for (Plane plane : availablePlanes) {
            Double planeDepartureLat = countryService.getCountryLat(plane.getCurrentLocation());
            Double planelDepartureLon = countryService.getCountryLon(plane.getCurrentLocation());
            double distance = calculateDistanceInMeters(parcelDepartureLat, parcelDepartureLon, planeDepartureLat, planelDepartureLon);
            if (distance < minDistance) {
                minDistance = distance;
                minPlane = plane;
            }
        }

        flightRepository.save(new Flight(minPlane.getCode(), minPlane.getCode() + parcelId, p.getLocation(), p.getDestination()));
        minPlane.setCurrentLocation(p.getDestination());
        XMLgenerator.updateXML(p.getLocation(), p.getDestination(), p.getId(), LocalDateTime.now());
        return minPlane.getCode() + parcelId;
    }

    public double calculateDistanceInMeters(double lat1, double long1, double lat2,
                                            double long2) {
        double dist = org.apache.lucene.util.SloppyMath.haversinMeters(lat1, long1, lat2, long2);
        return dist;
    }
}
