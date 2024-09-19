package br.com.vbruno.travelassistant.service;

import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HostingService {

    @Autowired
    private OpenAiChatModel chatClient;

    public String hosting(String place) {
        String question = "Liste os 5 melhores locais para se hospedar em " + place;

        return chatClient.call(question);
    }
}
