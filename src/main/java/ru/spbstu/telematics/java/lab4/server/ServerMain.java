package ru.spbstu.telematics.java.lab4.server;

import java.util.LinkedList;
import java.net.*;

public class ServerMain 
{
	private static final String HOST="0.0.0.0";
	private static final int PORT=23456;
	
	private static LinkedList <String> activeAuthors=new LinkedList <String>();
	private static LinkedList <ServerClientThread> clients=new LinkedList <ServerClientThread>();
	
	public static void SendAll(String mes){
		for (ServerClientThread s : clients){
			s.send(mes);
		}
	}
	
    public static void main( String[] args )
    {
    	try {
			ServerSocket server = new ServerSocket(PORT, 0,InetAddress.getByName(HOST));
			while (true){
				clients.add(new ServerClientThread(server.accept(), activeAuthors, clients));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}
