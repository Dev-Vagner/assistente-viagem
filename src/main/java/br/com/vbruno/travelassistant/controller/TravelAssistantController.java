package br.com.vbruno.travelassistant.controller;

import br.com.vbruno.travelassistant.service.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/travel-assistant")
@Tag(name = "Assistente de viagem")
public class TravelAssistantController {

    @Autowired
    private ArriveThePlaceService arriveThePlaceService;

    @Autowired
    private TouristAttractionsService touristAttractionsService;

    @Autowired
    private HostingService hostingService;

    @Autowired
    private TouristToursService touristToursService;

    @Autowired
    private ClothesTakeService clothesTakeService;

    @Operation(summary = "Como chegar ao destino", description = "Mostra informações de qual a distância do ponto de partida ao destino final e dá sugestões de como chegar ao destino")
    @ApiResponse(responseCode = "200", description = "Resposta retornada com sucesso")
    @ApiResponse(responseCode = "400", description = "Dados enviados em um formato inválido")
    @ApiResponse(responseCode = "500", description = "Problemas internos no servidor")
    @GetMapping("/arrive-place")
    public String arrivePlace(@RequestParam(name = "currentPlace") String currentPlace,
                              @RequestParam(name = "arrivalPlace") String arrivalPlace) {
        return arriveThePlaceService.arrive(currentPlace, arrivalPlace);
    }

    @Operation(summary = "Pontos turísticos", description = "Lista os 5 principais pontos turísticos da localidade enviada")
    @ApiResponse(responseCode = "200", description = "Resposta retornada com sucesso")
    @ApiResponse(responseCode = "400", description = "Dados enviados em um formato inválido")
    @ApiResponse(responseCode = "500", description = "Problemas internos no servidor")
    @GetMapping("/tourist-attractions")
    public String touristAttractions(@RequestParam(name = "place") String place) {
        return touristAttractionsService.attractions(place);
    }

    @Operation(summary = "Hospedagem", description = "Lista 5 locais para se hospedar na localidade enviada")
    @ApiResponse(responseCode = "200", description = "Resposta retornada com sucesso")
    @ApiResponse(responseCode = "400", description = "Dados enviados em um formato inválido")
    @ApiResponse(responseCode = "500", description = "Problemas internos no servidor")
    @GetMapping("/hosting")
    public String hosting(@RequestParam(name = "place") String place) {
        return hostingService.hosting(place);
    }

    @Operation(summary = "Empresas de passeios turísticos", description = "Lista as 3 principais empresas de passeios turísticos da localidade enviada")
    @ApiResponse(responseCode = "200", description = "Resposta retornada com sucesso")
    @ApiResponse(responseCode = "400", description = "Dados enviados em um formato inválido")
    @ApiResponse(responseCode = "500", description = "Problemas internos no servidor")
    @GetMapping("/tourist-tours")
    public String touristTours(@RequestParam(name = "place") String place) {
        return touristToursService.tours(place);
    }

    @Operation(summary = "Roupas para levar", description = "Dá sugestões de roupas para levar para a localidade enviada nas datas informadas")
    @ApiResponse(responseCode = "200", description = "Resposta retornada com sucesso")
    @ApiResponse(responseCode = "400", description = "Dados enviados em um formato inválido")
    @ApiResponse(responseCode = "500", description = "Problemas internos no servidor")
    @GetMapping("/clothes-take")
    public String clothesTake(@RequestParam(name = "place") String place,
                              @RequestParam(name = "startDate") LocalDate startDate,
                              @RequestParam(name = "endDate") LocalDate endDate) {
        return clothesTakeService.clothes(place, startDate, endDate);
    }
}
