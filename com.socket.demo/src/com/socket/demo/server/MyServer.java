package com.socket.demo.server;

import java.io.*;
import java.net.*;
//receive the request from client
public class MyServer {

	public static void main(String[] args){
		
		MyServer m = new MyServer();
	}
	
	public MyServer(){
		try{
		ServerSocket ss = new ServerSocket(9999);
		Socket s = ss.accept(); //return the socket connection
		//readLine() to read the data
		System.out.println("connected");
		// read message from s
		InputStreamReader isr = new InputStreamReader(s.getInputStream());
		BufferedReader br = new BufferedReader(isr);
		String info = br.readLine();
		System.out.println("got the message from client" + info);
		
		//send message to client
		PrintWriter pw = new PrintWriter(s.getOutputStream(), true);
		pw.println("this is server");
		
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
}
