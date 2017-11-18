package com.github.dannil.urldatabind.model.bind.result;

public class TextResult implements Action {

	private String text;

	public TextResult(String text) {
		this.text = text;
	}

	@Override
	public Object trigger() {
		return this.text;
	}

}
