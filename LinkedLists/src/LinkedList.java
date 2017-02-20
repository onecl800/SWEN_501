import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import javax.xml.soap.Node;

public class LinkedList<E> implements List<E> {

	
	//inner class, fields, getter and setters and constructor for LinkedNode
	private class LinkedNode<E> {
		public E item;
		public LinkedNode next;

		public LinkedNode(E o) {
			this.item = o;
			this.next = null;
		}
		
		public E getItem() {
			return item;
		}

		public void setItem(E item) {
			this.item = item;
		}

		public LinkedNode getNext() {
			return next;
		}

		public void setNext(LinkedNode next) {
			this.next = next;
		}
	}
	
	
	//outer class fields
	private LinkedNode<E> head;
	private int size;
	
	public int getSize() {
		return size;
	}

	
	//constructor for empty list
	public LinkedList() {
		head = new LinkedNode(null);
		size = 0;
	}
	
	
	//add item to list
	@Override
	public boolean add(E item) {
		LinkedNode<E> n = head;
		
		if (head != null) {
			while (n.next != null) {
				n = n.next;
			}
			if (n.next == null) {
				LinkedNode<E> newNode = new LinkedNode<E>(item);
				n.next = newNode;
				size++;
			}
		} else {
			head = new LinkedNode<E>(item);
			size++;
		}
		return true;
	}
	
	
	//return true if list is empty (size == 0)
	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	
	//return size
	@Override
	public int size() {
		return size;
	}
	
	
	//get item at int index
	@Override
	public E get(int index) {
		
		if (index < 0) {
			return null;
		}
		
		LinkedNode<E> n = head;
		
		n = n.next;
		
		for(int i = 0; i < index; i++) {
			if(n.next == null) {
				return null;
			}
			n = n.next;
		}
		
		return n.item;
	}
	
	
	//set item at index
	@Override
	public E set(int index, E item) {
		if (index < 0) {
			return null;
		}
		
		LinkedNode<E> n = head;
		n = n.next;
		
		for(int i = 0; i < index; i++) {
			if(n.next == null) {
				return null;
			}
			n = n.next;
		}
		
		n.setItem(item);
		
		return n.item;
	}
	
	
	//clear list - set head to null and size to 0
	@Override
	public void clear() {
		head = null;
		size = 0;
	}


	//add item at index
	//fails test to check i and check i+1, so is not adding new item to list correctly
	@Override
	public void add(int index, E item) {
		if (index == 0) {
			head = new LinkedNode<E>(item);
			size++;
		
		} else {
			LinkedNode<E> n = head;
			n = n.next;
		
			for(int i = 1; i < index; i++) {
				if(n.next == null) {
			}
			n = n.next;
		}
		
		n = new LinkedNode<E>(item);
		size++;
	}
	}
	

	//remove item at index
	//fails test to check i and check i+1, so is not removing item from list correctly
	@Override
	public E remove(int index) {
		if (index < 0) {
			return null;
		}
		
		LinkedNode<E> n = head;
		n = n.next;
		
		for(int i = 0; i < index; i++) {
			if(n.next == null) {
				return null;
			}
			n = n.next;
		}
		
		//n.setItem(index+1);
		size--;
		
		return n.item;
	}


	@Override
	public boolean contains(Object item) {
		
		return false;
	}




	@Override
	public boolean remove(Object item) {
		
		return false;
	}


	
	
	
	
	
	

	
	
	//BELOW NOT NEEDED//
	@Override
	public boolean addAll(Collection<? extends E> c) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean addAll(int index, Collection<? extends E> c) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public int indexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public int lastIndexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public ListIterator<E> listIterator() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public ListIterator<E> listIterator(int index) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public List<E> subList(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}

}
