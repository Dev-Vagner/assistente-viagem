package br.com.vbruno.travelassistant.service;

import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TouristAttractionsService {

    @Autowired
    private OpenAiChatModel chatClient;

    public String attractions(String place) {
        String question = "Liste os 5 principais pontos turísticos de " + place;

        return chatClient.call(question);
    }
}
