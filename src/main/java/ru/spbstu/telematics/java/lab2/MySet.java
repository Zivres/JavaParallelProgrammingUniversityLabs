package ru.spbstu.telematics.java.lab2;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class MySet <E> implements Set<E>, Iterable<E>{
	int size=0;
	MySetNode <E> first=null;
	MySetNode <E> last=null;
	
	public boolean add(E e) {
		if (contains(e))
			return false;
		MySetNode<E> node = new MySetNode<E>(e);
		if (this.last==null)
			this.last=this.first=node;
		else{
			this.last.setNext(node);
			this.last=this.last.getNext();
		}
		size++;
		return true;
	}

	public boolean addAll(Collection<? extends E> c) {
		Boolean b=false;
		Iterator<? extends E> itr = c.iterator();
		while(itr.hasNext())
			if(add(itr.next()))
				b=true;
		return b;
	}

	public void clear() {
		size=0;
		this.first=this.last=null;
	}

	public boolean contains(Object o) {
		for (int i=0;i<size();i++)
			if (o==null? get(i)==null:o.equals(get(i)))
				return true;
		return false;
	}

	public boolean containsAll(Collection<?> c) {
		Iterator<?> itr = c.iterator();
		while(itr.hasNext())
			if (!contains(itr.next()))
				return false;
		return true;
	}
	
	private MySetNode<E> getNode(int i){
		MySetNode<E> node = this.first;
		if (!isEmpty() && i>=0 && i<this.size())
			for (int j=0;j<i;j++){
				node = node.getNext();
			}
		else throw new IndexOutOfBoundsException();
		return node;
	}
	
	public E get(int i){
		E element=null;
		try{
			element=getNode(i).getItem();
		}
		catch(IndexOutOfBoundsException e){
			throw e;
		}
		return element;
	}
	
	public boolean isEmpty() {
		return (size == 0);
	}

	public Iterator<E> iterator() {
		Iterator<E> itr = new Iterator<E>(){
			private int current=0;
			
			public boolean hasNext() {
				return (current<size() && (first!=null));
			}

			public E next() {
				return get(current++);
			}
			public void remove(){
				MySet.this.remove(get(current));
				current--;
			}
		};
		return itr;
	}

	public boolean remove(Object o) throws IndexOutOfBoundsException{
		MySetNode<E> element, lastElement=null;
		for (int i=0;i<size();i++){
			element=getNode(i);
			if ((o!=null)?(o.equals(element.getItem())) : (element.getItem()==null)){
				if (lastElement==null)
					first=element.getNext();
				else
					lastElement.setNext(element.getNext());
				if (last==element)
					last=lastElement;
				size--;
				return true;
			}
			lastElement=element;
		}
		return false;
	}

	public boolean removeAll(Collection<?> c) {
		Boolean b=false;
		Iterator<?> itr = c.iterator();
		while(itr.hasNext())
			if(remove(itr.next()))
				b=true;
		return b;
	}

	public boolean retainAll(Collection<?> c) {
		Boolean b=false, isInCollection;
		Iterator<?> itr;
		E element;
		for (int i=0;i<size();i++){
			itr = c.iterator();
			element=get(i);
	        isInCollection=false;
			while(itr.hasNext()&&!isInCollection)
				if (itr.next().equals(element))
			        isInCollection=true;
			if (!isInCollection){
				remove(element);
				i--;
				b=true;
			}
		}
		return b;
	}

	public int size() {
		return size;
	}

	public Object[] toArray() {
		Object[] arr = new Object[size()];
		for (int i=0;i<size();i++)
			arr[i]=get(i);
		return arr;
	}

	public <T> T[] toArray(T[] a) {
		for (int i=0;i<size();i++)
			a[i]=(T)get(i);
		if(a.length>size())
			a[size]=null;
		return a;
	}
	
}
