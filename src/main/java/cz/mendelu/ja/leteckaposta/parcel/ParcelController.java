package cz.mendelu.ja.leteckaposta.parcel;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/parcels")
public class ParcelController {
    private final ParcelService parcelService;
    @Autowired
    public ParcelController(ParcelService parcelService){
        this.parcelService=parcelService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addParcel(@RequestBody Parcel parcel){parcelService.addParcel(parcel);}
}