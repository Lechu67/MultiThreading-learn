package Demo1CreatingThreads;

class Runner2 implements Runnable{

	@Override
	public void run() {
		for(int i = 0;i<10;i++){
			System.out.println("hello" + i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	
}
public class app2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		Runner2 runner1 = new Runner2();
		Thread thread1 = new Thread(runner1);
		Thread thread2 = new Thread(new Runner2());
		
		thread1.start();
		thread2.start();
	}

}
