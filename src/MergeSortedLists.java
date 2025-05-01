class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}
public class MergeSortedLists {
    public static ListNode mergeTwoList(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0); //временный узел для начала объедененного списка
        ListNode current = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                current.next = l1; //добавили меньший узел
                l1 = l1.next; //продвигаем указатель в первом списке
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next; //продвигаемся по новому списку
        }

        if (l1 != null) { // присоединяем оставшиеся узлы
            current.next = l1;
        } else if (l2 != null) {
            current.next = l2;
        }

        return dummy.next; //возвращаем
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(3);
        l1.next.next = new ListNode(5);

        ListNode l2 = new ListNode(2);
        l2.next = new ListNode(4);
        l2.next.next = new ListNode(6);

        ListNode mergedList = mergeTwoList(l1, l2);
        System.out.println("Merged List: ");
        printList(mergedList);
    }
}
