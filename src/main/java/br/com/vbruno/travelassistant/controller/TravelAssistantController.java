package br.com.vbruno.travelassistant.controller;

import br.com.vbruno.travelassistant.service.ArriveThePlaceService;
import br.com.vbruno.travelassistant.service.HostingService;
import br.com.vbruno.travelassistant.service.TouristAttractionsService;
import br.com.vbruno.travelassistant.service.TouristToursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/travel-assistant")
public class TravelAssistantController {

    @Autowired
    private ArriveThePlaceService arriveThePlaceService;

    @Autowired
    private TouristAttractionsService touristAttractionsService;

    @Autowired
    private HostingService hostingService;

    @Autowired
    private TouristToursService touristToursService;

    @GetMapping("/arrive-place")
    public String arrivePlace(@RequestParam(name = "currentPlace") String currentPlace,
                              @RequestParam(name = "arrivalPlace") String arrivalPlace) {
        return arriveThePlaceService.arrive(currentPlace, arrivalPlace);
    }

    @GetMapping("/tourist-attractions")
    public String touristAttractions(@RequestParam(name = "place") String place) {
        return touristAttractionsService.attractions(place);
    }

    @GetMapping("/hosting")
    public String hosting(@RequestParam(name = "place") String place) {
        return hostingService.hosting(place);
    }

    @GetMapping("/tourist-tours")
    public String touristTours(@RequestParam(name = "place") String place) {
        return touristToursService.tours(place);
    }
}
