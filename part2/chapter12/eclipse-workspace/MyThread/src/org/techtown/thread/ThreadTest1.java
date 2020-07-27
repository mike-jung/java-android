package org.techtown.thread;

public class ThreadTest1 {

	public static void main(String[] args) {
		ThreadTest1 test = new ThreadTest1();
	    test.startup();
	}
	
	public void startup() {
		DogThread dog = new DogThread();
		dog.start();
			
		HorseThread horse = new HorseThread();
		horse.start();
	}
			
	class DogThread extends Thread {
		 public void run() {
			 int distance = 0;
		     for (int i = 0; i < 10; i++) {
		        distance += (10*i);
		        System.out.println("dog running : " + distance);

		        try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		     }
		 }	
	}

	class HorseThread extends Thread {
		 public void run() {
			 int distance = 0;
		     for (int i = 0; i < 10; i++) {
		        distance += (10*i);
		        System.out.println("horse running : " + distance);

		        try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		     }
		 }	
	}
	 
}
