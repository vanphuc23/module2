package Method_of_LinkedList;

public class MyLinkedListTest {
    public static void main(String[] args) {
        MyLinkedList<String> in=new MyLinkedList<>();
        in.addFirst("H");
        in.add("E");
        in.add("L");
        in.add("L");
        in.add("O");
        in.remove("H");
        in.remove("O");
        in.printList();
    }
}
