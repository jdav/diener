package com.malleamus.diener.demo;

import com.malleamus.diener.Response;

public class DefaultResponse implements Response {

	@Override
	public String serialize() {
		return "default response";
	}

}
