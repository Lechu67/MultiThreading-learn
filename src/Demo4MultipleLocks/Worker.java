package Demo4MultipleLocks;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Worker {
	
	private Random random = new Random();
	private List<Integer> list1 = new ArrayList<Integer>();
	private List<Integer> list2 = new ArrayList<Integer>();
	private Object lock1 = new Object();
	private Object lock2 = new Object();
	
	public void stage1(){
		
		synchronized (lock1) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			list1.add(random.nextInt(100));
		}
	}

	public synchronized void stage2() {
		synchronized (lock2) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			list2.add(random.nextInt(100));
		}
	}

	public void process() {
		for (int i = 0; i < 1000; i++) {
			stage1();
			stage2();
		}
	}
	
	public void main(){
		
		System.out.println("Starting...");
		long startTime = System.currentTimeMillis();
		
		Thread t1 = new Thread (new Runnable() {
			
			@Override
			public void run() {
				process();
			}
		});
		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				process();
			}
		});
		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		long endTime = System.currentTimeMillis();
		System.out.println("List 1: " +list1.size() + " List 2: " + list2.size() + "\nTime :" + (endTime-startTime));
		
	}

}
