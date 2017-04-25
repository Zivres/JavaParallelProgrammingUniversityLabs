package ru.spbstu.telematics.java.lab3;

import java.util.ArrayList;

public class App {
	
	public static void main( String[] args )
    {
		int lines=4, columns=30;
		ArrayList <ArrayList <Double>> matr= new ArrayList <ArrayList <Double>>();
		ArrayList <Double> results = new ArrayList<Double>();
		for (int i=0;i<lines;i++){
			matr.add(new ArrayList <Double>());
			for (int j=0;j<columns;j++)
				matr.get(i).add((double)(i+j));
			results.add(0.0);
		}
		MyThread[] threads=new MyThread[lines];
		long timeStart = System.currentTimeMillis();
		for (int i=0;i<lines;i++){
			threads[i]=new MyThread(matr,i,results);
			threads[i].start();
		}
		try {
			for (int i=0;i<lines;i++)
				threads[i].join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		long timeEnd = System.currentTimeMillis();
		System.out.println("Time: "+ (timeEnd-timeStart));
		for (int i=0;i<lines;i++)
			System.out.println(matr.get(i)+" = ["+results.get(i)+"]");
    }
}
