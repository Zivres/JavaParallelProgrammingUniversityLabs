package ru.spbstu.telematics.java.lab3;

import java.util.ArrayList;

public class MyThread extends Thread {
	ArrayList<Double> line;
	ArrayList<Double> results;
	int lineNumber;
	public MyThread(ArrayList <ArrayList <Double>> matr, int lineNumber, ArrayList<Double> results){
		if (matr==null || results==null)
			throw new NullPointerException();
		if (matr.get(lineNumber)==null)
			throw new NullPointerException();
		if (results.size()!=matr.size() || matr.get(lineNumber).size() < lineNumber+1)
			throw new IndexOutOfBoundsException();
		this.line=matr.get(lineNumber);
		this.lineNumber=lineNumber;
		this.results=results;
	}
	
	public void run(){
		double temp=0;
		for (int i=0; i<line.size();i++)
			temp+=line.get(i);
		results.set(lineNumber, temp/line.size());
	}
}
