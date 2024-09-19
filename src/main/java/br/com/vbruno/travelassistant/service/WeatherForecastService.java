package br.com.vbruno.travelassistant.service;

import br.com.vbruno.travelassistant.service.validate.ValidateDateService;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class WeatherForecastService {

    @Autowired
    private OpenAiChatModel chatClient;

    @Autowired
    private ValidateDateService validateDateService;

    public String weather(String place, LocalDate startDate, LocalDate endDate) {
        validateDateService.validate(startDate, endDate);

        String question = "Qual a previsão do tempo do local " + place + " entre as datas de " +
                startDate + " a " + endDate + " ?";

        return chatClient.call(question);
    }
}
