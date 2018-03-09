package locations.bl;

import locations.persistence.LocationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService {

    private final LocationRepository locationRepository;

    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public void save(Location loc){
        locationRepository.save(loc);
    }

    public List<Location> listLocations(){
        return locationRepository.listLocations();
    }

}
