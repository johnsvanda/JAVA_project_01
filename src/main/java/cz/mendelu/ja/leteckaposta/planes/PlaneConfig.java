package cz.mendelu.ja.leteckaposta.planes;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Map;

@Configuration
public class PlaneConfig {

    @Bean
    CommandLineRunner commandLineRunner(PlaneRepository planeRepository) {

        return args -> {
            Plane p1 = new Plane(
             "OK-AHT", 20, 1000, "Prague"
            );

            Plane p2 = new Plane(
                    "OO-BKB", 30, 250, "Brussels"
            );

            Plane p3 = new Plane(
            "CU-V1005", 30, 250, "Havana"
            );

            planeRepository.saveAll(
                    List.of(p1, p2, p3)
            );
        };
    }
}
