package com.tripsync.flightandsearchservice.repository;

import com.tripsync.flightandsearchservice.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City, String> {


City findByCityId(String cityId);

City findByCityName(String cityName);
}
