import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKLists {

	static class ListNode {
		int val;
		ListNode next;

		ListNode(int val) {
			this.val = val;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode l1 = new ListNode(1);
		ListNode l1_2 = new ListNode(4);
		ListNode l1_3 = new ListNode(7);
		ListNode l1_4 = new ListNode(10);

		l1.next = l1_2;
		l1_2.next = l1_3;
		l1_3.next = l1_4;

		ListNode l2 = new ListNode(2);
		ListNode l2_2 = new ListNode(5);
		ListNode l2_3 = new ListNode(8);
		l2.next = l2_2;
		l2_2.next = l2_3;

		ListNode l3 = new ListNode(3);
		ListNode l3_2 = new ListNode(6);
		ListNode l3_3 = new ListNode(9);
		l3.next = l3_2;
		l3_2.next = l3_3;

		ListNode[] input = new ListNode[] { l1, l2, l3 };
		mergeKLists(input);
	}

	public static ListNode mergeKLists(ListNode[] lists) {
		if (lists == null || lists.length == 0) {
			return null;
		}

		Comparator<ListNode> comp = Comparator.comparing((ListNode a) -> a.val);

		PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(lists.length, comp);

		for (ListNode node : lists) {
			if (node != null) {
				queue.offer(node);
			}
		}

		ListNode dummy = new ListNode(0);
		ListNode tail = dummy;

		while (!queue.isEmpty()) {
			tail.next = queue.poll();
			tail = tail.next;
			if (tail.next != null) {
				queue.offer(tail.next);
			}
		}

		return dummy.next;
	}

}
