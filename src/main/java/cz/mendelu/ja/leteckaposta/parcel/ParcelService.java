package cz.mendelu.ja.leteckaposta.parcel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParcelService {

    private final ParcelRepository parcelRepository;
    @Autowired
    public ParcelService(ParcelRepository parcelRepository) {
        this.parcelRepository = parcelRepository;
    }

    public void addParcel(Parcel parcel) {
        parcelRepository.save(parcel);
    }

}
