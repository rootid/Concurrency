package com.threads;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class TaskExecutionWebServer {
		
	private static final int NTHREADS = 100;
    private static final Executor exec = Executors.newFixedThreadPool(NTHREADS);
    
    public static void handleRequest (Socket connection) throws InterruptedException {
            System.out.println("Received request" + connection.getPort());
             //Thread.sleep(10);
            int i = 0;
            while (i < 100) {
            	i++;
            }
            System.out.println("computed i " + i);
            
    }    
    	
    public static void main(String[] args) throws IOException 
    { 
        ServerSocket socket = new ServerSocket(9090);
        while (true) {
            final Socket connection = socket.accept(); 
            Runnable task = new Runnable() 
            {
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
            exec.execute(task);
        } 
    }

}
