
public class SwapTwoList {

	class ListNode {
		int val;
		ListNode next;

		ListNode(int val) {
			this.val = val;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null) // for List of length<2.
			return head;

		ListNode prev = null, first = head, second = head.next;

		while (second != null) {
			if (prev != null) // This if-else condition to also check for first pair
				prev.next = second;
			else
				head = second;

			first.next = second.next;
			second.next = first;
			prev = first;
			first = first.next;
			if (first == null || first.next == null) // if list is of odd length.
				break;
			second = first.next;
		}
		return head;
	}
}
