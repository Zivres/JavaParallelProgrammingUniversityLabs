package ru.spbstu.telematics.java.lab5;

import java.util.LinkedList;
import java.util.Random;

public class CentralComputer {
	LinkedList <manager> managers = new LinkedList<manager>();
	byte[] places;
	
	public CentralComputer(int PlacesCount){
		places = new byte[PlacesCount];
	}
	
	public void AddManager(){
		managers.add(new manager(places,managers.size()+1));
		new Thread(managers.get(managers.size()-1)).start();
	}
	
	public manager GetRandomFreeManager() throws IndexOutOfBoundsException {
		return managers.get(new Random().nextInt(managers.size()));
	}
	
	
}
