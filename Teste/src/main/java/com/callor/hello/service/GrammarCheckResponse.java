package com.callor.hello.service;

public class GrammarCheckResponse {
	  private boolean hasError;

	    public GrammarCheckResponse(boolean hasError) {
	        this.hasError = hasError;
	    }

	    public boolean isHasError() {
	        return hasError;
	    }

	    public void setHasError(boolean hasError) {
	        this.hasError = hasError;
	    }
}
