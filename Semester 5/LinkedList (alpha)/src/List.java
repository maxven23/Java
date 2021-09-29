public class List extends SEQUENCE.Sequence {
    private int size;
    private Node head;


    class Node {
        public Node(Object data) {
            this.data = data;
            this.next = null;
        }

        Object data;
        Node next;
    };

    List() {
        this.head = null;
    }

    // ======================================================

    @Override
    public void add(Object element) {
        Node elem = new Node(element);

        if (this.head == null) {
            this.head = elem;
            ++this.size;
        }
        else {
            Node temp = this.head;

            while (temp.next != null) {
                temp = temp.next;
            }

            temp.next = elem;
            ++this.size;
        }
    };

    @Override
    public void add(Object element, int index) {
        if ((index < 0) || (index > this.size)) {

        }
        else {
            Node elem = new Node(element);
            Node temp = this.head;

            int currentIndex = 0;

            while (temp.next != null) {
                if (currentIndex + 1 == index) {
                    elem.next = temp.next;
                    temp.next = elem;
                }

                ++currentIndex;
                temp = temp.next;
            }
            ++this.size;
        }
    };

    @Override
    public Object get(int index) {
        if ((index < 0) || (index > this.size)) {
            return null;
        }
        else {
            Node temp = this.head;

            for (int i = 0; i < index; ++i) {
                temp = temp.next;
            }
            return temp.data;
        }
    };

    @Override
    public Object remove(int index) {
        if ((index < 0) || (index > this.size)) {
            return null;
        }
        else {
            Node temp = this.head;
            Node tempPrev = null;

            int currentIndex = 0;

            Object data = null;
            if (index == 0) {
                data = this.head.data;
                this.head = temp.next;
            }
            else {
                while (temp != null) {
                    if (currentIndex == index) {
                        data = temp.data;
                        tempPrev.next = temp.next;
                        break;
                    } else {
                        tempPrev = temp;
                        temp = temp.next;
                        ++currentIndex;
                    }
                }
            }
            --this.size;
            return data;
        }
    };

    @Override
    public Object set(Object element, int index) {
        if ((index < 0) || (index > this.size)) {
            return null;
        }
        else {
            Node elem = new Node(element);
            Node temp = this.head;

            for (int i = 0; i < index - 1; ++i) {
                temp = temp.next;
            }
            elem.next = temp.next.next;
            temp.next = elem;
            return element;
        }
    };

    @Override
    public boolean contains(Object element) {
        Node temp = this.head;
        while (temp != null) {
            if (temp.data == element) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    };

    @Override
    public int indexOf(Object element) {
        Node temp = this.head;

        int currentIndex = 0;

        while (temp != null) {
            if (temp.data == element) {
                return currentIndex;
            }
            ++currentIndex;
            temp = temp.next;
        }
        return -1;
    };

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    };

    public void printList() {
        Node temp = this.head;

        System.out.println("List:");
        System.out.print("[ ");

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }

        System.out.println("]\n");
    }
}

class Main {

    public static void main(String[] args) {
        List list = new List();

        list.add(3);
        list.printList();

        list.add("hello");
        list.add("world");
        list.add("mark1");
        list.add("mark2", 1);

        list.printList();

        list.set("mark3", 3);
        list.printList();

        System.out.println("Element \"" + list.remove(0) + "\" was deleted from the list (index: 0)\n");
        list.printList();

        System.out.println("Does list contain \"mark1\"? - " + list.contains("mark1"));
        System.out.println("Index of \"hello\": " + list.indexOf("hello"));
        System.out.println("Item with index 0: " + list.get(0));
    }
}