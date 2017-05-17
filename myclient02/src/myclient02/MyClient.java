package myclient02;

import java.io.*;
import java.net.*;

public class MyClient {

	public static void main(String[] args) {
		MyClient c = new MyClient();

	}

	public MyClient(){
		
		try{
			//connect the client
			Socket s = new Socket("127.0.0.1", 8888);
			
			//write the date from client
			PrintWriter pw = new PrintWriter(s.getOutputStream(), true);
			
			//read data from center
			InputStreamReader irs = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(irs);
			
			//read data from client
			InputStreamReader irs2 = new InputStreamReader(s.getInputStream());
			BufferedReader br2 = new BufferedReader(irs2);
			
			
			while(true){
				System.out.println("say something to server");
				//read from center
				String info = br.readLine();
				pw.println(info);
				//read date from server
				String info2 = br2.readLine();
				System.out.println("server sent the message" + info2);
				
				//disconnect 
				if(info2.equals("bye")){
					s.close();
					break;
				}
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
