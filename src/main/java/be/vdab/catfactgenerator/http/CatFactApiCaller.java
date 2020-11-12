package be.vdab.catfactgenerator.http;

import be.vdab.catfactgenerator.model.CatFact;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.asm.TypeReference;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Map;

@Component
public class CatFactApiCaller {

    private final RestTemplate restTemplate;

    public CatFactApiCaller(RestTemplateBuilder rtb){
        this.restTemplate = rtb.build();
    }

    public CatFact requestCatFact(){
        String url = "https://catfact.ninja/facts?limit=1";
        String jSon = restTemplate.getForObject(url, String.class);
        ObjectMapper objectMapper = new ObjectMapper();
        CatFact catFact = new CatFact();

        try {
            JsonNode node = objectMapper.readValue(jSon, JsonNode.class);
            //JsonNode nameNode = node.get("name");
            //String name = nameNode.asText();
            //System.out.println(name);
            //JsonNode ageNode = node.get("age");
            //int age = ageNode.asInt();
            //System.out.println(age);
            JsonNode array = node.get("data");
            JsonNode jsonNode = array.get(0);
            String techStr = jsonNode.asText();
            System.out.println(techStr);
            JsonNode child = jsonNode.get("fact");
            //JsonNode childField = child.get("field");
            String result = child.asText();
            System.out.println(child);
            catFact.setFact(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
/*
        JsonNode jsonNode;
        CatFact catFact = null;
        try {
            jsonNode = objectMapper.readTree(jSon);
            catFact = new CatFact();
            String result = jsonNode.get("data").asText();
            System.out.println(result);
            *//*
            jsonNode = objectMapper.readTree(result);
            String result2 = jsonNode.get("fact").asText();
            *//*

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }*/
        return catFact;
    }
}
