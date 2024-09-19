package br.com.vbruno.travelassistant.service;

import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArriveThePlaceService {

    @Autowired
    private OpenAiChatModel chatClient;

    public String arrive(String currentPlace, String arrivalPlace) {
        String question = "Qual a distância, em KM, do local " + currentPlace + " até o local " + arrivalPlace +
                " e qual a forma mais indicada, e os seus custos, de chegar até lá?";

        return chatClient.call(question);
    }
}
