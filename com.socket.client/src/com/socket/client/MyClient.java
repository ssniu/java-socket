package com.socket.client;

import java.io.*;
import java.net.*;
public class MyClient {

	public static void main(String[] args) {
		MyClient mc = new MyClient();

	}
	
	public MyClient(){
		try{
		Socket s = new Socket("127.0.0.1", 9999);
		//transport data to server
		//true == update info dynamically
		PrintWriter pw = new PrintWriter(s.getOutputStream(), true);
		pw.println(" this is client");
		
		
		//receive the data from server
		InputStreamReader isr = new InputStreamReader(s.getInputStream());
		BufferedReader br = new BufferedReader(isr);
		String res=br.readLine();
		
		System.out.println(" Client received the message from server" + res);
		
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
