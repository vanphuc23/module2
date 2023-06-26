package Method_of_ArrayList;

public class MyListTest {
    public static void main(String[] args) {
        MyList<Integer> arrlist = new MyList<>();
        arrlist.add(1);
        arrlist.add(2);
        arrlist.add(3);
        arrlist.add(4);
        arrlist.add(1,5);
        arrlist.add(4,10);
        arrlist.remove(0);
        arrlist.add(11);
        arrlist.clone();
        System.out.println();
        arrlist.get();
    }
}
