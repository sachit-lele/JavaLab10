public class ThreadDemo implements Runnable {
    private Thread t;
    private String threadName;

    ThreadDemo(String name) {
        threadName = name;
        System.out.println("Creating " + threadName);
        //Create a new, second thread
    }

    public void run() {
        System.out.println("Running " + threadName);
        try {
            for(int i = 4; i > 0; i--) {
                System.out.println("Thread: " + threadName + ", " + i);
                Thread.sleep(50);
            }
        } catch (InterruptedException e) {
            System.out.println("Thread " + threadName + " interrupted.");
        }
        System.out.println("Thread " + threadName + " exiting.");
        // terminate the thread
    }

    public void start () {
        System.out.println("Starting " + threadName);
        if (t == null) {
            t = new Thread (this, threadName);
            t.start ();
        }
    }

    public static void main(String args[]) {
        ThreadDemo T1 = new ThreadDemo( "Thread-1");
        T1.start();

        ThreadDemo T2 = new ThreadDemo( "Thread-2");
        T2.start();

        // Get the currently executing thread
        Thread t = Thread.currentThread();
        System.out.println("Current thread: " + t);

        // Change the name of the thread
        t.setName("MyThread");
        System.out.println("After name change: " + t);

        // Pause the currently executing thread for a specified time
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted.");
        }

        // Check if a thread is alive or not
        System.out.println("Thread-1 is alive: " + T1.t.isAlive());
        System.out.println("Thread-2 is alive: " + T2.t.isAlive());

        System.out.println("Main thread exiting.");
    }
}
