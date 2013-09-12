package com.malleamus.diener.demo;

import com.malleamus.diener.Request;
import com.malleamus.diener.Response;

public class TypicalRequest implements Request {

	@Override
	public Response execute() {
		return new TypicalResponse();
	}

}
