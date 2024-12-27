package com.chat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	ServerSocket serverSocket;
	Socket socket;

	BufferedReader bReader;
	PrintWriter out;

	public Server() {
		try {
			serverSocket = new ServerSocket(7777);
			System.out.println("Server is ready to accept connection");
			System.out.println("Waiting...");
			socket = serverSocket.accept();
			
			bReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			out = new PrintWriter(socket.getOutputStream());
			
			startReading();
			startWriting();
			
		} catch (Exception e) {

		};
	}
	
	public void startReading() {
		@SuppressWarnings("unused")
		Runnable r1 =()->{
			System.out.println("Reader started...");
			
			try {
				while(true) {
					String msg = bReader.readLine();
					
					if(msg.equals("EXIT")) {
						System.out.println("Client terminated the chating");
						socket.close();
						break;
					}
					System.out.println("Clint: "+msg);
				}
			}catch (Exception e) {
				System.out.println("------Connection is Closed------");
			}
		};
		new Thread().start();
	}
	
	@SuppressWarnings("unused")
	public void startWriting() {
		Runnable r2 = () -> {
			System.out.println("Writer started...");
			
			try {
				while(!socket.isClosed()) {
					BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
					
					String content = br1.readLine();
					
					out.println(content);
					out.flush();
					
					if(content.equals("EXIT")) {
						socket.close();
						break;
					}
				}
			}catch (Exception e) {
				System.out.println("------Connection is Closed------");
			}
		};
		new Thread().start();
	}
	
	public static void main(String[] args) {
		System.out.println("This is server..going to start seerver");
		new Server();
	}
}
