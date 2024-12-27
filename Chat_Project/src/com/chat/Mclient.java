package com.chat;

import java.io.*;
import java.net.*;

public class Mclient {
	@SuppressWarnings("deprecation")
	public static void main(String[] args)throws Exception {
		Socket s1 = null;
        String line = null;
        DataInputStream br = null;
        DataInputStream is = null;
        PrintWriter os = null;
		
		try{
			s1 = new Socket("LocalHost", 9999);
			br = new DataInputStream(System.in);
			is = new DataInputStream(s1.getInputStream());
			os = new PrintWriter(s1.getOutputStream());
		}catch (IOException e) {
			System.out.println("IO Exception");
		}
		
		System.out.println("Enter data to server (Enter QUIT to end): ->"+s1.getRemoteSocketAddress().toString());
		String res = null;
		
		try {
			line = br.readLine();
			while(line.compareTo("QUIT") != 0) {
				os.println(line);
				os.flush();
				res = is.readLine();
				System.out.println("Server response :->"+res);
			}
			
			is.close();
			os.close();
			br.close();
			s1.close();
			System.out.println("Close connection");
			
		}catch (IOException e) {
			System.out.println("Socket read error");
		}
	}
}
