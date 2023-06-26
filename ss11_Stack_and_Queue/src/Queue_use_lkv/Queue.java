package Queue_use_lkv;

public class Queue {
    private Node front;
    private Node rear;

    public Queue() {
        this.front = null;
        this.rear = null;
    }

    public void enQueue(int data) {
        Node node = new Node(data);
        if (this.rear == null) {
            this.front = this.rear = node;
            return;
        } else {
            this.rear.link = node;
            this.rear = node;
        }
    }

    public void deQueue() {
        if (this.front == null) {
            System.out.println("Không có phần tử nào");
        } else {
            if (this.front == this.rear) {
                this.front = this.rear = null;
            } else {
                Node temp = this.front;
                this.front = this.front.link;
            }
        }
    }

    public void displayQueue() {
        Node temp = this.front;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.link;
        }
    }

    public static void main(String[] args) {
        Queue q = new Queue();
        q.enQueue(1);
        q.enQueue(2);
        q.enQueue(3);
        q.enQueue(4);
        q.deQueue();
        q.deQueue();
        q.displayQueue();
    }
}
