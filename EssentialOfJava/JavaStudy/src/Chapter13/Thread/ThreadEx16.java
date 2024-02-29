package Chapter13.Thread;

public class ThreadEx16 {

	public static void main(String[] args) {
		RunImplEx16 r1 = new RunImplEx16();
		RunImplEx16 r2 = new RunImplEx16();
		RunImplEx16 r3 = new RunImplEx16();
	}

}

class RunImplEx16 implements Runnable {
	boolean suspended = false;
	boolean stopped = false;
	
	public void run() {
		while(!stopped) {
			if(!suspended) {
				System.out.println(Thread.currentThread().getName());
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					
				}
			}
		}
		System.out.println(Thread.currentThread().getName() + " - stopped");
	}
}