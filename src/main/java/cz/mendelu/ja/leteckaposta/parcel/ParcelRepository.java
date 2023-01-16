package cz.mendelu.ja.leteckaposta.parcel;


import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;


@Repository
public interface ParcelRepository extends JpaRepository<Parcel, UUID>{
}
