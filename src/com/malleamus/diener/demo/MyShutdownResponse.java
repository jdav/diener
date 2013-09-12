package com.malleamus.diener.demo;

import com.malleamus.diener.Response;

public class MyShutdownResponse implements Response {

	@Override
	public String serialize() {
		return "shutting down...";
	}

}
