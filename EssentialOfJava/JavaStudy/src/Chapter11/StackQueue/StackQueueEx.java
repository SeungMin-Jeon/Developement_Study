package Chapter11.StackQueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StackQueueEx {

	public static void main(String[] args) {
		Stack<String> st = new Stack<>();
		Queue<String> q = new LinkedList<>();
		
		st.push("0");
		st.push("1");
		st.push("2");
		
		q.offer("0");
		q.offer("1");
		q.offer("2");
		
		System.out.println("-- STACK ---");
		
		while(!st.isEmpty()) {
			System.out.println(st.pop());
		}
		
		System.out.println("-- queue --");
		while(!q.isEmpty()) {
			System.out.println(q.poll());
		}
	}
}
