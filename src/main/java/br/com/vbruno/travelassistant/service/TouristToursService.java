package br.com.vbruno.travelassistant.service;

import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TouristToursService {

    @Autowired
    private OpenAiChatModel chatClient;

    public String tours(String place) {
        String question = "Liste as 3 principais empresas de passeios turísticos que trabalham na região do local " + place;

        return chatClient.call(question);
    }
}
