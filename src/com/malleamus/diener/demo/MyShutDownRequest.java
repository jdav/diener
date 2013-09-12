package com.malleamus.diener.demo;

import com.malleamus.diener.Response;
import com.malleamus.diener.ShutdownRequest;

public class MyShutDownRequest implements ShutdownRequest {

	@Override
	public Response execute() {
		return new MyShutdownResponse();
	}

}
