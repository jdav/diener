package com.malleamus.diener;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class Server implements Runnable {
	
	private RequestFactory factory = null;
	private int port = 0;
	private boolean up = false;

	public Server(RequestFactory factory, int port) {
		this.factory = factory;
		this.port = port;
	}
	
	public void startUp() throws IOException {
		up = true;
		ServerSocket ss = new ServerSocket(port);

		do {
			Socket socket = null;
			
			try {
				ss.setSoTimeout(5000);
				socket = ss.accept();
				
				if (up) {
					//These lines will not execute if timeout on accept is exceeded
					RequestProcessor pr = new RequestProcessor(socket, factory, this);
					pr.start();
				}
			} catch (SocketTimeoutException ste) {
				//Ignore
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		} while (up);
		
		ss.close();
	}
	
	public void shutDown() {
		up = false;
	}

	@Override
	public void run() {
		try {
			startUp();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
