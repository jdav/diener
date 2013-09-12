package com.malleamus.diener.demo;

import com.malleamus.diener.Request;
import com.malleamus.diener.RequestFactory;

public class MyReqeustFactory implements RequestFactory {

	@Override
	public Request create(String rawInput) throws Exception {
		if (rawInput.equals("typical")) {
			return new TypicalRequest();
		} else if (rawInput.equals("shutdown")) {
			return new MyShutDownRequest();
		} else {
			return new DefaultRequest();
		}
	}

}
