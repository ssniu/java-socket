package com.server;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.*;

public class MyServerDemo03  extends JFrame implements ActionListener{
	
	JTextArea jta = null;
	JTextField jtf = null;
	JButton jb = null;
	JPanel jp1 = null;
	JScrollPane jsp = null;
	//send info to client
	PrintWriter pw = null;
	

	public static void main(String[] args) {
		MyServerDemo03 c = new MyServerDemo03();

	}
	
	public MyServerDemo03(){
		
		jta = new JTextArea();
		jtf = new JTextField(20);
		jb = new JButton("submit");
		jp1 = new JPanel();
		jsp = new JScrollPane(jta);
		
		//add the listener to button
		jb.addActionListener(this);
		//add listener to jtf for keyboard "enter" to submit the message
		jtf.addActionListener(this);
		
		jp1.add(jtf);
		jp1.add(jb);
		this.add(jsp, "Center");
		this.add(jp1,"South");
		this.setTitle("LetsChatServer");
		this.setSize(400,300);
		this.setVisible(true);
		
		
		
		try{
			ServerSocket ss = new ServerSocket(7777);
			System.out.println("waiting for connection...");
			
			Socket s = ss.accept();
			
			//read data
			InputStreamReader irs = new InputStreamReader(s.getInputStream());
			BufferedReader br = new BufferedReader(irs);
			
			 pw = new PrintWriter(s.getOutputStream(), true);
			
			//read data from client
			while(true){
				String infoClient = br.readLine();
				jta.append(infoClient + "\r\n");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//both button and enter can submit the message
		if(e.getSource() == jb || e.getSource() == jtf){
			//send the content in server to client
			String infoServer = jtf.getText();
			pw.println(infoServer);
			jta.append(infoServer + "\r\n");
			//erase the content inside input box
			//jta.append(infoServer);
			jtf.setText("");
		}
		
	}

}
