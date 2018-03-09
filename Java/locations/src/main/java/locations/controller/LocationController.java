package locations.controller;

import locations.bl.Location;
import locations.bl.LocationService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LocationController {

    private final LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }




    @RequestMapping(value="/api/locations",method= RequestMethod.POST)
    public String save(@RequestBody Location loc){
        locationService.save(loc);
        return "{\"status\": \"ok\"}";
    }

    @RequestMapping(value = "/api/locations",method = RequestMethod.GET)
    public List<Location> listLocation(){
        return locationService.listLocations();
    }


}
