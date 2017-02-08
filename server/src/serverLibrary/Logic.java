package serverLibrary;

import java.util.LinkedList;
import java.util.concurrent.locks.*;

import commonLibrary.Message;
import commonLibrary.Query;
import commonLibrary.Queue;

public class Logic implements Runnable
{
	private Queue<Query> queue;
	private Logic instance;
	private final ReentrantLock lock;
	
	
	protected Logic()
	{
		queue = new Queue<Query>();
		lock = new ReentrantLock();
	}
	
	public Logic getInstance()
	{
		if(instance == null)
			instance = new Logic();
		return instance;
	}
	
	
	public static void main(String args[])
	{
		DBWrapper DB = DBWrapper.getInstance();
		Network net = Network.getInstance();
		net.serv();

	}
	
	
	
	public void addQuery(Query q)
	{
		lock.lock();
		queue.enqueue(q);
		lock.unlock();
	}
	
	
	public void run()
	{
		Query q;
		
		while(true)
		{
			lock.lock();
			while(queue.isEmpty())
			{
				lock.unlock();
				try
				{
				Thread.sleep(1000);
				}
				catch(Exception e)
				{
					DBWrapper.getInstance().writeLog("Warning", this.getClass().getName(), "queue faild at sleeping : "+e);
				}
				
				lock.lock();
			}
			
			q = queue.dequeue();
			
			
			lock.unlock();
			
			switch(q.getOpCode())
			{
			case 0:
				break;
				
				
				default:
					
			}
		}
		
		
	}
}