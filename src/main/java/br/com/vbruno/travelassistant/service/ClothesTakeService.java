package br.com.vbruno.travelassistant.service;

import br.com.vbruno.travelassistant.service.validate.ValidateDateService;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ClothesTakeService {

    @Autowired
    private OpenAiChatModel chatClient;

    @Autowired
    private ValidateDateService validateDateService;

    public String clothes(String place, LocalDate startDate, LocalDate endDate) {
        validateDateService.validate(startDate, endDate);

        String question = "Quais roupas levar para utilizar em " + place + " entre as datas de " +
                startDate + " a " + endDate + " ?";

        return chatClient.call(question);
    }
}
