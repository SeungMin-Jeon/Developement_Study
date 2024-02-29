package Chapter13.Thread;


class Customer implements Runnable {
	private Table table;
	private String food;
	
	Customer(Table table, String food) {
		this.table = table;
		this.food = food;
	}
	
	public void run() {
		while(true) {
			try {Thread.sleep(100); catch(InterruptedException e) {}
		}
	}
}

public class ThreadWaitEx4 {

	public static void main(String[] args) {
		
	}

}
