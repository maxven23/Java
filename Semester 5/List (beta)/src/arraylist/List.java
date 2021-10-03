package arraylist;

public class List {
    private int size;
    private Object[] data;

    //_______Constructors_______//
    public List() {

        this.size = 0;

    }

    public List(int size) {

        this.size = size;
        this.data = new Object[size];

    }


    //_______Methods_______//
    public void add(Object element) {
        ++this.size;

        if (this.size > 1) {
            Object[] data = this.data;
            this.data = new Object[this.size];
            System.arraycopy(data, 0, this.data, 0, this.size - 1);

            this.data[this.size - 1] = element;
        }
        else {
            this.data = new Object[1];
            this.data[0] = element;
        }
    }

    public void add(Object element, int index) {
        if (index < 0 || index >= this.size) {
            // in case we can use "output" instead of "exceptions" //
            System.out.println("INDEX ERROR: Index out of range");
        }
        else {
            ++this.size;

            Object[] data = this.data;
            this.data = new Object[this.size];

            System.arraycopy(data, index, this.data, index + 1, this.size - index - 1);
            System.arraycopy(data, 0, this.data, 0, index);

            this.data[index] = element;
        }
    }

    public Object get(int index) {
        if (index < 0 || index >= this.size) {
            // in case we can use "output" instead of "exceptions" //
            System.out.println("INDEX ERROR: Index out of range");
            return null;
        } else {
            return this.data[index];
        }
    }

    public Object remove(int index) {
        if (index < 0 || index >= this.size) {
            // in case we can use "output" instead of "exceptions" //
            System.out.println("INDEX ERROR: Index out of range");
            return null;
        }
        else {
            --this.size;

            Object[] data = this.data;
            this.data = new Object[this.size];

            System.arraycopy(data, 0, this.data, 0, index);
            System.arraycopy(data, index + 1, this.data, index, this.size - index);

            return data[index];
        }
    }

    public Object set(Object element, int index) {
        if (index < 0 || index >= this.size) {
            // in case we can use "output" instead of "exceptions" //
            System.out.println("INDEX ERROR: Index out of range");
            return null;
        }
        else {
            Object fin = this.data[index];

            this.data[index] = element;

            return fin;
        }
    }

    public boolean contains(Object element) {
        for (int i = 0; i < this.size; ++i) {
            if (get(i) == element) {
                return true;
            }
        }
        return false;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public int size() {
        return this.size;
    }

    public int indexOf(Object element) {
        for (int i = 0; i < this.size; ++i) {
            if (get(i) == element) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        String listS = "[ ";
        for (int i = 0; i < this.size - 1; ++i) {
            listS += get(i);
            listS += ", ";
        }
        listS += get(this.size - 1);
        listS += " ]";
        return listS;
    }
}