package ru.spbstu.telematics.java.lab4.server;

import java.net.*;
import java.util.LinkedList;
import java.util.Scanner;
import java.io.*;

public class ServerClientThread extends Thread {
	private Socket sock;
    private Scanner in;
    private PrintWriter out;
	LinkedList <String> activeAuthors;
	LinkedList <ServerClientThread> clients;
	
	ServerClientThread(Socket s, LinkedList <String> activeAuthors, LinkedList <ServerClientThread> clients){
		sock=s;
    	try {
			in = new Scanner(sock.getInputStream());
	    	out = new PrintWriter(sock.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
   		this.activeAuthors=activeAuthors;
   		this.clients=clients;
		start();
	}
	
    void send(String mes){
    	out.println(mes);
        out.flush();
    }
    
    void end(String author){
    	if (!author.equals("")){
    		synchronized (activeAuthors){
    			ServerMain.SendAll(author+" leaved our chat.");
    			activeAuthors.remove(author);
    		}
    	}
		synchronized (clients){
			clients.remove(this);
		}
        out.close();
        in.close();
		try {
			sock.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    }
	
	public void run(){
        try {
        	String mes="";
        	String author="";
        	//login
        	do{
        		if (in.hasNext()){
        			mes = in.nextLine();
        			if (mes.equals("__exit")){
        				end(author);
        				return;
        			}
        			synchronized (activeAuthors){
        				if(!activeAuthors.contains(mes)){
        					author=mes;
        					activeAuthors.add(author);
        					send("__ok");
        					ServerMain.SendAll(author+" joined our chat.");
        				}
        				else{
        					send("__bad");
        				}
        			}
        		}
        	}while(author.equals(""));
        	//message cycle
			while (true){
				if (in.hasNext()){
					mes = in.nextLine();
					if (mes.equals("__exit"))
						break;
					ServerMain.SendAll(author+">> "+mes);
				}
			}
			//user disconnected
			end(author);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
