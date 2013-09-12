package com.malleamus.diener.demo;

import java.io.IOException;

import com.malleamus.diener.RequestFactory;
import com.malleamus.diener.Server;

public class MyServer extends Server {

	public MyServer(RequestFactory factory, int port) {
		super(factory, port);
	}

	public static void main(String[] args) throws IOException {
		MyReqeustFactory factory = new MyReqeustFactory();
		MyServer ms = new MyServer(factory, 2958);
		ms.startUp();
	}

}
