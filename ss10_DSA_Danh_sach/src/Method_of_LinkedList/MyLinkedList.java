package Method_of_LinkedList;

public class MyLinkedList<E> {
    private Node head;
    private int numNodes;

    private class Node {
        private Node next;
        private Object data;

        public Node(Object data) {
            this.data = data;
        }

        public Object getData() {
            return data;
        }
    }

    public MyLinkedList() {
    }

    public MyLinkedList(Node head) {
        this.head = head;
    }

    public void add(int index, E element) {
        Node temp = head;
        for (int i = 0; i < index - 1 && temp.next != null; i++) {
            temp = temp.next;
        }
        Node holder = temp.next;
        temp.next = new Node(element);
        temp.next.next = holder;
        numNodes++;
    }

    public void addFirst(E e) {
        Node temp = head;
        head = new Node(e);
        head.next = temp;
        numNodes++;
    }

    public void addLast(E e) {
        Node temp = head;
        for (int i = 0; i < numNodes && temp.next != null; i++) {
            temp = temp.next;
        }
        temp.next = new Node(e);
        numNodes++;
    }

    public int size() {
        return numNodes;
    }

    public E remove(int index) {
        Node temp = head;
        if (index == 0) {
            head = temp.next;
            numNodes--;
            return (E) temp;
        } else {
            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }
            Node holder = temp.next;
            temp.next = temp.next.next;
            numNodes--;
            return (E) holder;
        }
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public boolean contains(E o) {
        Node temp = head;
        for (int i = 0; i < numNodes; i++) {
            if (temp.data == o) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public int indexOf(E o) {
        Node temp = head;
        for (int i = 0; i < numNodes; i++) {
            if (temp.data == o) {
                return i;
            }
            temp = temp.next;
        }
        return -1;
    }

    public boolean add(E e) {
        addLast(e);
        return true;
    }

    public E get(int index) {
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return (E) temp.data;
    }

    public E getFirst() {
        Node temp = head;
        return (E) temp.data;
    }

    public E getLast() {
        Node temp = head;
        for (int i = 0; i < numNodes && temp.next != null; i++) {
            temp = temp.next;
        }
        return (E) temp.data;
    }

    public void clear() {
        Node temp = head;
        for (int i = 0; i < numNodes; i++) {
            temp = temp.next = null;
        }
        numNodes = 0;
    }

    public E clone() {
        Node temp = head;
        MyLinkedList<E> newLinkedList = new MyLinkedList<>();
        newLinkedList.addFirst((E) temp.data);
        temp = temp.next;
        while (temp != null) {
            newLinkedList.addLast((E) temp.data);
            temp = temp.next;
        }
        return (E) newLinkedList;
    }

    public void ensureCapacity(int minCapacity) {
        numNodes = minCapacity;
    }

    public boolean remove(Object e) {
        Node temp = head;
        for (int i = 0; i < numNodes; i++) {
            if (temp instanceof Object) {
                if (temp.data == e) {
                    remove(i);
                    return true;
                }
            }
            temp = temp.next;
        }
        return false;
    }
}
