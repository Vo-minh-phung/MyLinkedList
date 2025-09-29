public class MyLinkedList {

    // ======================= Node Class =======================
    public static class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    // ======================= Print Linked List =======================
    public static void printLinkedList(Node head) {
        if (head == null) {
            System.out.println("List is empty");
        } else {
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.value);
                temp = temp.next;
                if (temp != null) System.out.print(" -> ");
            }
            System.out.println();
        }
    }

    // ======================= Add To Head =======================
    public static Node addToHead(Node headNode, int value) {
        Node newNode = new Node(value);
        if (headNode != null) {
            newNode.next = headNode; // trỏ newNode vào đầu danh sách
        }
        return newNode;
    }

    // ======================= Add To Tail =======================
    public static Node addToTail(Node headNode, int value) {
        Node newNode = new Node(value); // thêm vào cuối danh sách
        if (headNode == null) {
            return newNode;
        } else {
            // Xác định lastNode
            Node lastNode = headNode;
            while (lastNode.next != null) {
                lastNode = lastNode.next;
            }
            // Gắn next của lastNode cho newNode
            lastNode.next = newNode;
            return headNode;
        }
    }

    // ======================= Add To Index =======================
    public static Node addToIndex(Node headNode, int value, int index) {
        if (index == 0) {
            return addToHead(headNode, value);
        } else {
            Node newNode = new Node(value);
            Node curNode = headNode;
            int count = 0;

            while (curNode != null) {
                count++;
                if (count == index) {
                    // Thực hiện add
                    newNode.next = curNode.next;
                    curNode.next = newNode;
                    break;
                }
                curNode = curNode.next;
            }
            return headNode;
        }
    }

    // ======================= Remove At Head =======================
    public static Node removeAtHead(Node headNode) {
        if (headNode != null) {
            return headNode.next;
        }
        return headNode;
    }

    // ======================= Remove At Tail =======================
    public static Node removeAtTail(Node headNode) {
        if (headNode == null)
            return null;

        Node lastNode = headNode;
        Node preNode = null;

        while (lastNode.next != null) {
            preNode = lastNode;
            lastNode = lastNode.next;
        }

        if (preNode == null) {
            // chỉ có 1 phần tử
            return null;
        } else {
            preNode.next = null;
        }

        return headNode;
    }

    // ======================= Remove At Index =======================
    public static Node removeAtIndex(Node headNode, int index) {
        if (headNode == null || index < 0)
            return null;
        if (index == 0)
            return removeAtHead(headNode);

        Node currNode = headNode;
        Node preNode = null;
        int count = 0;
        boolean isFound = false;

        while (currNode != null) {
            if (count == index) {
                isFound = true;
                break;
            }
            preNode = currNode;
            currNode = currNode.next;
            count++;
        }

        if (isFound) {
            if (preNode != null && currNode != null) {
                preNode.next = currNode.next;
            }
        }

        return headNode;
    }

    // ======================= Main Function =======================
    public static void main(String[] args) {

        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);

        n1.next = n2;
        n2.next = n3;

        System.out.println("Original list:");
        printLinkedList(n1);

        // Thêm node ở đầu
        n1 = addToHead(n1, 0);
        System.out.println("After addToHead:");
        printLinkedList(n1);

        // Thêm node ở cuối
        n1 = addToTail(n1, 4);
        System.out.println("After addToTail:");
        printLinkedList(n1);

        // Thêm node ở vị trí index 2
        n1 = addToIndex(n1, 99, 2);
        System.out.println("After addToIndex (index=2):");
        printLinkedList(n1);

        // Xóa node ở đầu
        n1 = removeAtHead(n1);
        System.out.println("After removeAtHead:");
        printLinkedList(n1);

        // Xóa node ở cuối
        n1 = removeAtTail(n1);
        System.out.println("After removeAtTail:");
        printLinkedList(n1);

        // Xóa node ở index 1
        n1 = removeAtIndex(n1, 1);
        System.out.println("After removeAtIndex (index=1):");
        printLinkedList(n1);
    }
}