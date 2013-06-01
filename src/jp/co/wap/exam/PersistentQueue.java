package jp.co.wap.exam;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
public class PersistentQueue<E> {
	
	private int head;
	private int tail;
	private int size;
	private int maxSize;
	private E[] queue;
	static int initialMaxSize=500;
	public PersistentQueue(){
		head=0;
		tail=0;
		maxSize=initialMaxSize;
		queue=(E[])new Object[maxSize];
		size=0;
	}
	public PersistentQueue(E[] otherArray){
		E[] theQueue=(E[])new Object[2*otherArray.length];
		for(int i=0;i<otherArray.length;i++){
			theQueue[i]=otherArray[i];
		}
		this.head=0;
		this.tail=otherArray.length;
		this.maxSize=2*(otherArray.length);
		this.size=otherArray.length;
		this.queue=theQueue;
	}
	public PersistentQueue(PersistentQueue<E> other){
		this.head=other.head;
		this.tail=other.tail;
		this.size=other.size;
		this.queue=other.queue;
		this.maxSize=other.maxSize;
	}
	public boolean isFull(){
		return (tail+1==maxSize);
	}
	public boolean isEmpty(){
		return (head==tail);
	}
	public PersistentQueue<E> enqueue(E e){
		
		PersistentQueue<E> sr=new PersistentQueue<E>(this);
		
		
		if(sr.isFull()){
			E[] theQueue=(E[])new Object[2*(sr.maxSize)];//expand capacity of the queue;
			for(int i=0;i<sr.size;i++)
			{
				theQueue[i]=sr.queue[sr.head+i];
				
			}
			sr.queue=theQueue;
			sr.head=0;
			sr.maxSize=2*(sr.maxSize);
			sr.queue[sr.size]=e;
			sr.size+=1;
			sr.tail=sr.size;
			
		}
		else
		{
		    sr.queue[sr.tail]=e;
		    sr.tail=sr.tail+1;
		    sr.size+=1;
		    
		}
		return sr;
		
	}
	public PersistentQueue<E> dequeue(){
		if(isEmpty()){
			throw new NoSuchElementException();
		}
		PersistentQueue sr=new PersistentQueue(this);
		sr.head+=1;
		sr.size-=1;
		return sr;
	}
    public E peek(){
    	if(isEmpty()){
    		throw new NoSuchElementException();
    	}
    	return this.queue[head];
    }
    public int size(){
    	
    	return size;
    }
 
	public static void main(String args[]){
		String[] wa={"fsf","fff","ddd"};
		PersistentQueue<String> a=new PersistentQueue<String>(wa);
		PersistentQueue<String> b=new PersistentQueue<String>();
		PersistentQueue<String> c=b.enqueue("dsfsd");
		PersistentQueue<String> d=c.dequeue();
		c.enqueue("dddd");
		System.out.print(a.peek());
	}

}
