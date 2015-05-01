package com.threads;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiThreadWebServer {

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
             final Socket connection = serverSocket.accept();
             
             Runnable task = new Runnable() {
				
				@Override
				public void run() {
					 try {
						handleRequest(connection);
						connection.close();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			};
			
			new Thread(task).start();
		
         }
	}
	
}
