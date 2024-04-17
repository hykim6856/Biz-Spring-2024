package com.callor.hello.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.callor.hello.models.AnalysisResult;
import com.google.gson.Gson;

@Service
public class SpellService {

    @Value("${wisenu.api.url}")
    private String wiseNLUUrl;

    @Value("${access.key}")
    private String accessKey;

    private final RestTemplate restTemplate;
    private final Gson gson;

    public SpellService() {
        this.restTemplate = new RestTemplate();
        this.gson = new Gson();
    }

    public AnalysisResult analyzeText(String text) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", accessKey);

        Map<String, Object> request = new HashMap<>();
        Map<String, String> argument = new HashMap<>();
        argument.put("analysis_code", "ner");
        argument.put("text", text);
        request.put("argument", argument);

        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(request, headers);

        ResponseEntity<String> response = restTemplate.exchange(
        		wiseNLUUrl,
            HttpMethod.POST,
            entity,
            String.class
        );

        if (response.getStatusCode() != HttpStatus.OK) {
            // Handle error response
            return null;
        }

        String responseBody = response.getBody();
        Map<String, Object> responseBodyMap = gson.fromJson(responseBody, Map.class);
        Map<String, Object> returnObject = (Map<String, Object>) responseBodyMap.get("return_object");
        List<Map<String, Object>> sentences = (List<Map<String, Object>>) returnObject.get("sentence");

        // Extract analysis results
        List<String> nouns = new ArrayList<>();
        List<String> verbs = new ArrayList<>();
        List<String> entities = new ArrayList<>();

        for (Map<String, Object> sentence : sentences) {
            List<Map<String, Object>> morps = (List<Map<String, Object>>) sentence.get("morp");
            for (Map<String, Object> morp : morps) {
                String lemma = (String) morp.get("lemma");
                String type = (String) morp.get("type");
                if (type.equals("NNG") || type.equals("NNP") || type.equals("NNB")) {
                    nouns.add(lemma);
                } else if (type.equals("VV")) {
                    verbs.add(lemma);
                }
            }

            List<Map<String, Object>> nameEntities = (List<Map<String, Object>>) sentence.get("NE");
            for (Map<String, Object> entity1 : nameEntities) {
                String textEntity = (String) entity1.get("text");
                entities.add(textEntity);
            }
        }

        return new AnalysisResult(nouns, verbs, entities);
    }
}
