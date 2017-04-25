package ru.spbstu.telematics.java.lab2;

import static org.junit.Assert.*;

import java.util.LinkedHashSet;
import java.util.Iterator;

import org.junit.Assert;
import org.junit.Test;

public class Lab2Test {

	@Test
	public void createNotNull(){
		MySet <Integer> set=new MySet <Integer>();
		Assert.assertNotNull(set);
	}
	
	@Test
	public void createSize0(){
		MySet <Integer> set=new MySet <Integer>();
		Assert.assertEquals(set.size(),0);
	}
	
	@Test
	public void AddGetCorrect(){
		MySet <Integer> set=new MySet <Integer>();
		for (Integer i=0; i<10; i++){
			Assert.assertTrue(set.add(i));
			Assert.assertEquals(set.get(i),i);
		}
	}
	
	@Test
	public void AddSizeCorrect(){
		MySet <Integer> set=new MySet <Integer>();
		for (int i=0; i<10; i++){
			set.add(i);
			Assert.assertEquals(set.size(),i+1);
		}
	}
	
	@Test
	public void AddEqualsReturnFalse(){
		MySet <Integer> set=new MySet <Integer>();
		set.add(1);
		Assert.assertFalse(set.add(1));
	}
	
	@Test
	public void AddTwoNullsReturnFalse(){
		MySet <Integer> set=new MySet <Integer>();
		set.add(null);
		Assert.assertFalse(set.add(null));
	}
	
	@Test
	public void AddEqualsDontAdd(){
		MySet <Integer> set=new MySet <Integer>();
		set.add(1);
		set.add(1);
		Assert.assertEquals(set.size(),1);
	}

	@Test
	public void AddTwoNullsDontAdd(){
		MySet <Integer> set=new MySet <Integer>();
		set.add(null);
		set.add(null);
		Assert.assertEquals(set.size(),1);
	}
	
	@Test(expected=IndexOutOfBoundsException.class)
	public void GetTooBigIndex(){
		MySet <Integer> set=new MySet <Integer>();
		set.add(1);
		set.get(1);
	}
	
	@Test(expected=IndexOutOfBoundsException.class)
	public void GetTooLittleIndex(){
		MySet <Integer> set=new MySet <Integer>();
		set.add(1);
		set.get(-1);
	}
	
	@Test
	public void IsEmptySetEmpty(){
		MySet <Integer> set=new MySet <Integer>();
		Assert.assertTrue(set.isEmpty());
	}
	
	@Test
	public void IsNotEmptySetNotEmpty(){
		MySet <Integer> set=new MySet <Integer>();
		set.add(1);
		Assert.assertFalse(set.isEmpty());
	}

	@Test
	public void ClearSize0(){
		MySet <Integer> set=new MySet <Integer>();
		set.add(1);
		set.clear();
		Assert.assertEquals(set.size(),0);
	}
	
	@Test(expected=IndexOutOfBoundsException.class)
	public void ClearReally0Elements(){
		MySet <Integer> set=new MySet <Integer>();
		set.add(1);
		set.clear();
		set.get(0);
	}

	@Test
	public void AddAll(){
		MySet <Integer> set=new MySet <Integer>();
		LinkedHashSet <Integer> temp = new LinkedHashSet<Integer>();
        temp.add(1);
        temp.add(2);
        temp.add(2);
        set.addAll(temp);
        Iterator<Integer> itr = temp.iterator();
		while(itr.hasNext())
			Assert.assertTrue(set.contains(itr.next()));
	}
	
	@Test
	public void AddAllWithEqualsCorrectSize(){
		MySet <Integer> set=new MySet <Integer>();
		LinkedHashSet <Integer> temp = new LinkedHashSet<Integer>();
        temp.add(1);
        temp.add(2);
        temp.add(2);
        set.addAll(temp);
		Assert.assertEquals(set.size(),2);
	}

	@Test
	public void RemoveCorrectSize(){
		MySet <Integer> set=new MySet <Integer>();
		set.add(1);
		set.remove(1);
		Assert.assertEquals(set.size(),0);
	}
	
	@Test
	public void RemoveCorrectOutput(){
		MySet <Integer> set=new MySet <Integer>();
		set.add(1);
		Assert.assertTrue(set.remove(1));
		Assert.assertFalse(set.remove(2));
	}
	
	@Test
	public void RemoveReallyRemove(){
		MySet <Integer> set=new MySet <Integer>();
		set.add(1);
		set.add(2);
		set.add(3);
		set.remove(2);
		Iterator<Integer> itr = set.iterator();
		while (itr.hasNext())
			Assert.assertNotEquals(itr.next(),new Integer(2));
	}

	@Test
	public void RemoveAll(){
		MySet <Integer> set=new MySet <Integer>();
		set.add(1);
		LinkedHashSet <Integer> temp = new LinkedHashSet<Integer>();
        temp.add(1);
        temp.add(2);
        temp.add(2);
        set.addAll(temp);
        set.removeAll(temp);
        Iterator<Integer> itr = temp.iterator();
		while(itr.hasNext())
			Assert.assertFalse(set.contains(itr.next()));
	}
	
	@Test
	public void Contains(){
		MySet <Integer> set=new MySet <Integer>();
		set.add(1);
		Assert.assertTrue(set.contains(1));
		Assert.assertFalse(set.contains(2));
	}
	
	@Test
	public void ContainsAll(){
		MySet <Integer> set=new MySet <Integer>();
		LinkedHashSet <Integer> temp = new LinkedHashSet<Integer>();
        temp.add(1);
        temp.add(2);
        set.addAll(temp);
		Assert.assertTrue(set.containsAll(temp));
		set.remove(2);
		Assert.assertFalse(set.containsAll(temp));
	}

	@Test
	public void RetainAll(){
		MySet <Integer> set=new MySet <Integer>();
		set.add(1);
		set.add(2);
		set.add(3);
		MySet <Integer> copyOfSet=new MySet <Integer>();
		copyOfSet.addAll(set);
		LinkedHashSet <Integer> temp = new LinkedHashSet<Integer>();
        temp.add(0);
        temp.add(1);
        temp.add(2);
		set.retainAll(temp);
		Iterator<Integer> itr = copyOfSet.iterator();
		Integer i;
		while (itr.hasNext()){
			i=itr.next();
			Assert.assertEquals(set.contains(i), copyOfSet.contains(i) && temp.contains(i));
		}
		Iterator<Integer> itr2 = temp.iterator();
		while (itr2.hasNext()){
			i=itr2.next();
			Assert.assertEquals(set.contains(i), copyOfSet.contains(i) && temp.contains(i));
		}
	}
	
	@Test
	public void toArray(){
		MySet <Integer> set=new MySet <Integer>();
		LinkedHashSet <Integer> temp = new LinkedHashSet<Integer>();
        temp.add(0);
        temp.add(1);
        temp.add(2);
		set.addAll(temp);
		for (int i=0;i<3;i++)
			Assert.assertEquals(temp.toArray()[i],set.toArray()[i]);
	}
	
	@Test
	public void toExistingArray(){
		MySet <Integer> set=new MySet <Integer>();
		LinkedHashSet <Integer> temp = new LinkedHashSet<Integer>();
        temp.add(0);
        temp.add(1);
        temp.add(2);
		set.addAll(temp);
		Integer[] arr1=set.toArray(new Integer[3]);
		Integer[] arr2=temp.toArray(new Integer[3]);
		for (int i=0;i<3;i++)
			Assert.assertEquals(arr1[i],arr2[i]);
	}
}
