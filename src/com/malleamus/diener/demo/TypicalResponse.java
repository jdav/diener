package com.malleamus.diener.demo;

import com.malleamus.diener.Response;

public class TypicalResponse implements Response {

	@Override
	public String serialize() {
		return "typical response";
	}

}
