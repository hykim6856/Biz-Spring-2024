package com.callor.hello.models;


import java.util.List;
 
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString 

public class AnalysisResult {
    public class AnalysisResultBuilder {

		public Object withNouns(List<String> nouns) {
			// TODO Auto-generated method stub
			return null;
		}

	}

	private List<String> nouns;
    private List<String> verbs;
    private List<String> entities;

    public AnalysisResult(List<String> nouns, List<String> verbs, List<String> entities) {
        this.nouns = nouns;
        this.verbs = verbs;
        this.entities = entities;
    }

    // Getter methods
}
