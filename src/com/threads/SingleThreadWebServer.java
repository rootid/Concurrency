package com.threads;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SingleThreadWebServer {

        public static void handleRequest (Socket connection) throws InterruptedException {
            System.out.println("Received request" + connection.getPort());
            //Thread.sleep(10); 
            int i = 0;
            while (i < 100) {
            	i++;
            }
            System.out.println("computed i " + i);
        }


	public static void main(String[] args) throws IOException, InterruptedException {
		
			
            ServerSocket serverSocket = new ServerSocket (9090);
            while (true) {
                Socket connection = serverSocket.accept();
                handleRequest(connection);
                connection.close();
            }
		
	}
		
}
