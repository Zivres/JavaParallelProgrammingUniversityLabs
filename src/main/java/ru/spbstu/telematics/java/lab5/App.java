package ru.spbstu.telematics.java.lab5;

public class App {
	public static CentralComputer comp = new CentralComputer(1000);

	public static void main(String[] args) {
		for (int i=0;i<1;i++)
			comp.AddManager();
		for (int i=0;i<100;i++)
			new Thread(new customer(i)).start();
	}
}

