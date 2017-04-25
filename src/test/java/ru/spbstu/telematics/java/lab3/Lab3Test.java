package ru.spbstu.telematics.java.lab3;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import junit.framework.Assert;

public class Lab3Test {

	@Test(expected=NullPointerException.class)
	public void matrNull() throws InterruptedException{
		ArrayList <ArrayList <Double>> matr= null;
		ArrayList <Double> results = new ArrayList<Double>();
		results.add(0.0);
		MyThread thread=new MyThread(matr,1,results);
		thread.start();
		thread.join();
	}

	@Test(expected=NullPointerException.class)
	public void matrLineNull() throws InterruptedException{
		ArrayList <ArrayList <Double>> matr= new ArrayList <ArrayList <Double>>();
		ArrayList <Double> results = new ArrayList<Double>();
		for (int i=0;i<2;i++){
			matr.add(null);
			results.add(0.0);
		}
		MyThread thread=new MyThread(matr,1,results);
		thread.start();
		thread.join();
	}
	
	@Test(expected=NullPointerException.class)
	public void resultsNull() throws InterruptedException{
		ArrayList <ArrayList <Double>> matr= new ArrayList <ArrayList <Double>>();
		ArrayList <Double> results = null;
		for (int i=0;i<2;i++){
			matr.add(new ArrayList <Double>());
			for (int j=0;j<2;j++)
				matr.get(i).add((double)(i+j));
		}
		MyThread thread=new MyThread(matr,1,results);
		thread.start();
		thread.join();
	}
	
	@Test(expected=IndexOutOfBoundsException.class)
	public void matrTooBigIndex() throws InterruptedException{
		ArrayList <ArrayList <Double>> matr= new ArrayList <ArrayList <Double>>();
		ArrayList <Double> results = new ArrayList<Double>();
		for (int i=0;i<2;i++){
			matr.add(new ArrayList <Double>());
			for (int j=0;j<2;j++)
				matr.get(i).add((double)(i+j));
			results.add(0.0);
		}
		MyThread thread=new MyThread(matr,3,results);
		thread.start();
		thread.join();
	}
	
	@Test(expected=IndexOutOfBoundsException.class)
	public void matrNegativeIndex() throws InterruptedException{
		ArrayList <ArrayList <Double>> matr= new ArrayList <ArrayList <Double>>();
		ArrayList <Double> results = new ArrayList<Double>();
		for (int i=0;i<2;i++){
			matr.add(new ArrayList <Double>());
			for (int j=0;j<2;j++)
				matr.get(i).add((double)(i+j));
			results.add(0.0);
		}
		MyThread thread=new MyThread(matr,-1,results);
		thread.start();
		thread.join();
	}
	
	@Test(expected=IndexOutOfBoundsException.class)
	public void matrSizeIsNotResultsSize() throws InterruptedException{
		ArrayList <ArrayList <Double>> matr= new ArrayList <ArrayList <Double>>();
		ArrayList <Double> results = new ArrayList<Double>();
		for (int i=0;i<2;i++){
			matr.add(new ArrayList <Double>());
			for (int j=0;j<2;j++)
				matr.get(i).add((double)(i+j));
			results.add(0.0);
		}
		results.add(0.0);
		MyThread thread=new MyThread(matr,1,results);
		thread.start();
		thread.join();
	}
	
	@Test
	public void isComputationCorrect() throws InterruptedException{
		ArrayList <ArrayList <Double>> matr= new ArrayList <ArrayList <Double>>();
		ArrayList <Double> results = new ArrayList<Double>();
		for (int i=0;i<2;i++){
			matr.add(new ArrayList <Double>());
			for (int j=0;j<2;j++)
				matr.get(i).add((double)(i+j));
			results.add(0.0);
		}
		MyThread thread1=new MyThread(matr,0,results);
		MyThread thread2=new MyThread(matr,1,results);
		thread1.start();
		thread2.start();
		thread1.join();
		thread2.join();
		Assert.assertEquals((matr.get(0).get(0)+matr.get(0).get(1))/2, results.get(0));
		Assert.assertEquals((matr.get(1).get(0)+matr.get(1).get(1))/2, results.get(1));
}
}
