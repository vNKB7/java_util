package zwz.struct.list;

import java.util.LinkedList;
import java.util.ListIterator;

public class MaxQueue<T extends Comparable<T>> {

	LinkedList<T> queue = new LinkedList<>();
	LinkedList<T> maxQueue = new LinkedList<>();

	public void add(T obj) {
		queue.addLast(obj);
		ListIterator<T> it = maxQueue.listIterator(maxQueue.size());
		int remove = 0;
		while (it.hasPrevious()) {
			if (it.previous().compareTo(obj) < 0) {
				remove++;
			} else {
				break;
			}
		}

		for (int i = 0; i < remove; i++) {
			maxQueue.removeLast();
		}

		maxQueue.addLast(obj);
	}

	public T poll() {
		if (queue.size() == 0) {
			return null;
		}

		T obj = queue.pollFirst();
		if (obj.compareTo(maxQueue.getFirst()) == 0) {
			maxQueue.pollFirst();
		}

		return obj;
	}

	public T peek() {
		return queue.getFirst();
	}

	public T max() {
		if (maxQueue.size() == 0) {
			return null;
		} else {
			return maxQueue.getFirst();
		}
	}

	public static void main(String[] args) {
		MaxQueue<Integer> mq = new MaxQueue<>();
		mq.add(1);
		mq.add(2);
		mq.add(3);
		mq.add(1);
		mq.add(2);
		System.out.println("max: " + mq.max());
		System.out.println("poll: " + mq.poll());
		System.out.println("max: " + mq.max());
		System.out.println("poll: " + mq.poll());
		System.out.println("max: " + mq.max());
		System.out.println("poll: " + mq.poll());
		System.out.println("max: " + mq.max());
		System.out.println("poll: " + mq.poll());
		System.out.println("max: " + mq.max());
		System.out.println("poll: " + mq.poll());
		System.out.println("max: " + mq.max());
	}

}
