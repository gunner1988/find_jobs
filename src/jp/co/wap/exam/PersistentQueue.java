package jp.co.wap.exam;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
public class PersistentQueue<E> {
	
	int head;
	int tail;
	int size;
	E[] queue;
	static int initialSize=500;
	public PersistentQueue(){
		head=0;
		tail=0;
		size=initialSize;
	}
	public PersistentQueue(PersistentQueue<E> other){
		this.head=other.head;
		this.tail=other.tail;
		size=other.size;
		this.queue=other.queue;
	}
	public PersistentQueue<E> enqueue(E e){
		
		PersistentQueue<E> sr=new PersistentQueue<E>(this);
		
		
		if((sr.tail+1)%sr.size==sr.head){
			
		}
		else
		{
		    queue.	
		}
		return sr;
		
	}
	public PersistentQueue<E> dequeue(){
		if(size==0){
			return this;
		}
		
		return null;
	}
    public E peek(){
    	return null;
    }
    public int size(){
    	
    	return 0;
    }
 
	

}
