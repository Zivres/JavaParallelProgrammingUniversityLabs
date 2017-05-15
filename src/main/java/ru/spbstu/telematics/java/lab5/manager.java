package ru.spbstu.telematics.java.lab5;

import java.util.LinkedList;
import java.util.Random;

public class manager implements Runnable {

	private byte[] places;
	private int number;
		
	public manager(byte[] places, int number){
		this.places=places;
		this.number=number;
		System.out.println("Manger "+number+" is ready.");
	}
	
	public int GetNumber(){
		return number;
	}

	
	public void run() {
		while (true)
				;
	}
	
	public LinkedList <Integer> GetFreePlaces(){
		LinkedList <Integer> freePlaces = new LinkedList <Integer>();
		for (int i=0;i<places.length;i++)
			if (places[i]==0)
				freePlaces.add(i);
		return freePlaces;
	}
	
	public boolean SelectPlace(int place){
		synchronized(places){
			if (places[place]==2)
				return false;
			places[place]=1;
		}
		try {
			Thread.sleep(new Random().nextInt(3000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return (BuyPlace(place));
	}
	
	public boolean BuyPlace(int place){
		synchronized(places){
			if (places[place]!=2){
				places[place]=2;
				return true;
			}
			else
				return false;
		}
	}
	
}
