package Oppgave3;

import java.util.Collection;
import java.util.Iterator;


import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;


public class BurgerSlide implements BlockingQueue{

		BlockingQueue<Hamburger> slide;
		private int MAX_SIZE = 5;
		Hamburger burger;
		
		  
	int burgercount = 1;
		  
		  
		  public BurgerSlide() {
			this.slide = new LinkedBlockingDeque<>(MAX_SIZE);

		  }
		
			  public boolean isFull() {
			    return slide.size() == MAX_SIZE;
			  }

			 
			  public boolean isEmpty() {
			    if(slide.size() == 0 || slide.size() < 0) {
			    	return true;
			    	
			    }else 
			    	return false;
			      
			  }
			  
			  public int addElement() {
				  
				 if(!isFull()) {
					  try {
						slide.put(new Hamburger(burgercount));
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					  burgercount++;
					  return burgercount-1;
				 }  
				return -1;
			  }
			  
			// delete element from the queue
			public int removeElement() {
			    int c = -2;
				if(!isEmpty()) {
					try {
						c = slide.take().getNumber();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
			  return c;
			}
					
			@Override
			public String toString() {
				
				String s = "";
				
				if(!isEmpty()) {
					for(Hamburger b : slide) {
						
						s +=  "(" + Integer.toString(b.getNumber()) + ")" + ",";
					}
				}
				
				return s;
			}
				
			@Override
			public Object remove() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Object poll() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Object element() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Object peek() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public int size() {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public Iterator iterator() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Object[] toArray() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Object[] toArray(Object[] a) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public boolean containsAll(Collection c) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean addAll(Collection c) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean removeAll(Collection c) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean retainAll(Collection c) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public void clear() {
				// TODO Auto-generated method stub
				
			}

			@Override
			public boolean add(Object e) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean offer(Object e) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public void put(Object e) throws InterruptedException {
				// TODO Auto-generated method stub
				
			}

			@Override
			public boolean offer(Object e, long timeout, TimeUnit unit) throws InterruptedException {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public Object take() throws InterruptedException {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Object poll(long timeout, TimeUnit unit) throws InterruptedException {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public int remainingCapacity() {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public boolean remove(Object o) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean contains(Object o) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public int drainTo(Collection c) {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public int drainTo(Collection c, int maxElements) {
				// TODO Auto-generated method stub
				return 0;
			}
				
//				String onSlide = "[";
//				
//				if(!isEmpty()) {
//					onSlide += "(" +slide.toString() + ")]";
//			    }
//				
//				return onSlide;
//			  }

}
