package Demo9ProducerConsumer2;

import java.util.LinkedList;
import java.util.Random;

public class Processor {

	private LinkedList<Integer> list = new LinkedList<>();
	private final int SIZE = 20;
	private Object lock = new Object();
	private Random random = new Random();

	public void produce() throws InterruptedException {
		int value = 0;
		while (true) {
			synchronized (lock) {
				while (list.size() == SIZE)
					lock.wait();
				list.add(value++);
				lock.notify();
				//Thread.sleep(random.nextInt(1000));
			}
		}
	}

	public void consume() throws InterruptedException {
		while (true) {
			synchronized (lock) {
				while(list.isEmpty())
					lock.wait();
				
				System.out.print("Size of the list : "+list.size());
				int value = list.removeFirst();
				System.out.println(" the value removed: "+value);
				lock.notify();
				Thread.sleep(random.nextInt(1000));
			}

		}
	}

}
