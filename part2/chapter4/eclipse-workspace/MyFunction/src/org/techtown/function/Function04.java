package org.techtown.function;

public class Function04 {

	public static void main(String[] args) {
		int count = 0;
		
	    count = sum(1, 11);
		
	    System.out.println(count);

	    count = sum(1, 101);
	    System.out.println(count);
		
	    count = sum(1, 1001);
	    System.out.println(count);
	}
	
	static int sum(int start, int end) {
	    int count = 0;
		
	    for (int i = start; i < end; i++) {
	      count = count + i;
	    }
		
	    return count;
	}
	  
}
