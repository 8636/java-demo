package DS.linkedList;

/**
 * Created by duan on 2020/2/17 20:41
 */
public class LinkedList<E> {

    private class Node {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node dummyHead;
    private int size;

    public LinkedList() {
        dummyHead.next = null;
        size = 0;
    }

    public void add(int index, E e) {
        Node pre = dummyHead.next;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        Node node = new Node(e);
        node.next = pre.next;
        pre.next = node;
    }

    public void addFirst(E e){
        add(0,e);
    }

    @Override
    public String toString(){
        StringBuffer res = new StringBuffer();
        Node cur = dummyHead.next;
        while (cur!=null){
            res.append(cur.e);
            res.append("=>");
        }
        res.append("null");
        return res.toString();
    }

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            linkedList.addFirst(i);
            System.out.println(linkedList);
        }
        linkedList.add(3,233);
        System.out.println(linkedList);
    }
}
