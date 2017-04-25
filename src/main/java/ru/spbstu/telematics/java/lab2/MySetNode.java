package ru.spbstu.telematics.java.lab2;

public class MySetNode <E> {
	private E item;
	private MySetNode<E> next;
	
	MySetNode(E item){
		this.item=item;
		this.next=null;
	}
	
	public E getItem() {
		return item;
	}
	public void setItem(E item) {
		this.item = item;
	}
	public MySetNode<E> getNext() {
		return next;
	}
	public void setNext(MySetNode<E> next) {
		this.next = next;
	}
	
	@Override
	public boolean equals(Object obj) {
	    return item.equals(obj);
	}
}
