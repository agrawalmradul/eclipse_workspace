

import java.util.NoSuchElementException;

public class QueueImpl<T> {
	
	private static class QueueNode<T>{
		private T data;
		private QueueNode next;
		
		public QueueNode(T data) {
			this.data = data;
		}
	}
	
	private QueueNode<T> first;
	private QueueNode<T> last;
	
	public void enqueue(T item) {
		QueueNode<T> newNode = new QueueNode<T>(item);
		if(last != null) {
			last.next  = newNode;
		}
		last = newNode;
		if(first == null) {
			first = last;
		}
	}
	
	public T dequeue() {
		if(first == null) throw new NoSuchElementException();
		T data = first.data;
		first = first.next;
		if(first == null) {
			last = null;
		}
		return data;
	}

}
