package com.client;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.io.*;
import java.net.*;

public class MyClientdemo03 extends JFrame implements ActionListener{
	
	JTextArea jta = null;
	JTextField jtf = null;
	JButton jb = null;
	JPanel jp1 = null;
	JScrollPane jsp = null;
	PrintWriter pw = null;

	public static void main(String[] args) {
		MyClientdemo03 m = new MyClientdemo03();

	}
	
	public MyClientdemo03(){
		
		jta = new JTextArea();
		jtf = new JTextField(20);
		jb = new JButton("submit");
		jp1 = new JPanel();
		jsp = new JScrollPane(jta);
		jb.addActionListener(this);
		//add listener to jtf for keyboard "enter" to submit the message
		jtf.addActionListener(this);
		
		jp1.add(jtf);
		jp1.add(jb);
		this.add(jsp, "Center");
		this.add(jp1,"South");
		this.setTitle("LetsChatClient");
		this.setSize(400,300);
		this.setVisible(true);
		
		try{
			
			Socket s = new Socket("127.0.0.1", 7777);
			
			//read data
			InputStreamReader isr = new InputStreamReader(s.getInputStream());
			BufferedReader br = new BufferedReader(isr);
			
			pw = new PrintWriter(s.getOutputStream(),true);
			while(true){
				String info = br.readLine();
				jta.append(info + "\r\n");
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == jb || e.getSource() == jtf){
			String info = jtf.getText();
			jta.append(info + "\r\n");
			pw.println(info);
			jtf.setText("");
		}
		
	}

}
