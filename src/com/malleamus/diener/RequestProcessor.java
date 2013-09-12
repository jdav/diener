package com.malleamus.diener;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class RequestProcessor extends Thread {
	
	private Socket socket = null;
	private RequestFactory factory = null;
	private Server server = null;
	
	public RequestProcessor(Socket socket, RequestFactory factory, Server server) {
		this.socket = socket;
		this.factory = factory;
		this.server = server;
	}
	
	public void run() {
		PrintWriter out = null;
		BufferedReader in = null;
		
		try {
			out = new PrintWriter(socket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String rawInput = in.readLine();
			
			//Determine how to process it..,.
			Request request = factory.create(rawInput);
			if (request instanceof ShutdownRequest) {
				server.shutDown();
			}
			
			//Write the response...
			Response response = request.execute();
			String serializedResponse = response.serialize();
			out.write(serializedResponse);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			out.flush();
			out.close();
			try {
				in.close();
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}