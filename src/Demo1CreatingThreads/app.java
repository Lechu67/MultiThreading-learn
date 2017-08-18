package Demo1CreatingThreads;

class Runner extends Thread{

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
public class app {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Runner runner1 = new Runner();
		runner1.start();
		Runner runner2 = new Runner();
		runner2.start();
	
	}

}
