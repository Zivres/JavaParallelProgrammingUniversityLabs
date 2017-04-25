package ru.spbstu.telematics.java.lab2;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class App 
{
    public static void main( String[] args )
    {
        MySet <Integer> s = new MySet <Integer> ();
        LinkedHashSet <Integer> trueSet = new LinkedHashSet <Integer> ();
        s.add(1);
        trueSet.add(1);
        System.out.println(trueSet.equals(s));
        s.remove(2);
        trueSet.remove(2);
        System.out.println(trueSet.equals(s));
        s.remove(1);
        trueSet.remove(1);
        System.out.println(trueSet.equals(s));
        s.add(null);
        trueSet.add(null);
        ArrayList <Integer> temp = new ArrayList<Integer>();
        temp.add(1);
        temp.add(2);
        s.addAll(temp);
        trueSet.addAll(temp);
        System.out.println(trueSet.equals(s));
        s.retainAll(temp);
        trueSet.retainAll(temp);
        System.out.println(trueSet.equals(s));
        Object[] t = s.toArray();
        Object[] t2 = trueSet.toArray();
        System.out.println(t.equals(t2));

		Iterator<Integer> itr = s.iterator();
		Iterator<Integer> itr2 = trueSet.iterator();
		while (itr.hasNext())
	        System.out.println(itr.next().equals(itr2.next()));

		s.clear();
		s.add(null);
		s.add(null);
		trueSet.clear();
		trueSet.add(null);
		trueSet.add(null);
        System.out.println(trueSet.equals(s));
    }
}
