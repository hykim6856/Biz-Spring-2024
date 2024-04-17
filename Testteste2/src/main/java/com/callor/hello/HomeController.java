// HomeController.java
package com.callor.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.callor.hello.models.AnalysisResult;
import com.callor.hello.service.SpellService;

@Controller
public class HomeController {

    private final SpellService spellService;

    @Autowired
    public HomeController(SpellService spellService) {
        this.spellService = spellService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {
        return "et";
    }

    @PostMapping("/analyze")
    @ResponseBody
    public AnalysisResult analyzeText(@RequestBody String text) {
        return spellService.analyzeText(text);
    }
}
