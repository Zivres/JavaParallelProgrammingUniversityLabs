package ru.spbstu.telematics.java.lab5;

import java.util.LinkedList;
import java.util.Random;

public class customer implements Runnable {

	manager man;
	int number;
	
	public customer(int n) throws IndexOutOfBoundsException{
		man=App.comp.GetRandomFreeManager();
		number=n;
	}
	
	public void run() {
		int place;
		boolean b;
		System.out.println(number+": Hello, manager "+man.GetNumber()+", I'm your new customer.");
		do{
			LinkedList <Integer> freePlaces = man.GetFreePlaces();
			try {
				Thread.sleep(new Random().nextInt(3000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			place=freePlaces.get(new Random().nextInt(freePlaces.size()));
			System.out.println(number+": I want to buy "+place+" place.");
			b=man.SelectPlace(place);
			if (b)
				System.out.println(number+": Place "+place+" is good for me.");
			else
				System.out.println(number+": Someone has bought place "+place+", while I tried to by it.");
		}while(!b);
	}
}
