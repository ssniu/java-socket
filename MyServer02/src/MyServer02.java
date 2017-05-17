
import java.io.*;
import java.net.*;


public class MyServer02 {

	public static void main(String[] args) {
		MyServer02 my = new MyServer02();
		
	}
	
	public MyServer02(){
		
		try{
			ServerSocket ss = new ServerSocket(8888);
			
			Socket s = ss.accept();
			
			InputStreamReader isr = new InputStreamReader(s.getInputStream());
			//read buffer
			BufferedReader br = new BufferedReader(isr);
			//write
			PrintWriter pw = new PrintWriter(s.getOutputStream(), true);
			//get input from 
			InputStreamReader isr2 = new InputStreamReader(System.in);
			BufferedReader br2 = new BufferedReader(isr2);
			
			while(true){
				String infoFromClient = br.readLine();
				System.out.println("Message from Client" + infoFromClient);
				
				if(infoFromClient.equals("bye")){
					System.out.println("end the connection");
					s.close();
					break;
				}
				
				//receive the data 
				System.out.println("receive the data from center");
				String res = br2.readLine();
				//write the date to client
				pw.println(res);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
