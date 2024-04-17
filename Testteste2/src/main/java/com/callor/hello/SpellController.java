// SpellController.java
package com.callor.hello;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.callor.hello.models.AnalysisResult;
import com.callor.hello.service.SpellService;

@RestController
public class SpellController {

    private SpellService spellService;

    public SpellController(SpellService spellService) {
        this.spellService = spellService;
    }

    @PostMapping("/hello/analyze")
    public ResponseEntity<AnalysisResult> analyzeText(@RequestBody String text) {
        AnalysisResult result = spellService.analyzeText(text);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
