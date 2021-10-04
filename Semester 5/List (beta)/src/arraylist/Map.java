package arraylist;

public class Map {

    private final int DEFAULT_CAPACITY = 32;

    private int capacity;
    private int size;
    private List entries;
    private List keys;


    // Entry class //
    private class Entry {
        private Object key;
        private Object value;

        public Entry(Object key, Object value) {
            this.key = key;
            this.value = value;
        }

        // Methods //
        public Object getKey() {
            return this.key;
        }
        public Object getValue() {
            return this.value;
        }
    }

    //------- Constructors -------//
    public Map() {
        this.size = 0;
        this.capacity = DEFAULT_CAPACITY;
        this.entries = new List(DEFAULT_CAPACITY);
        this.keys = new List();
    }

    public Map(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.keys = new List();
        this.entries = new List(capacity);
    }

    //------- Methods -------//
    public void put(Object key, Object value) {
        int index = key.hashCode() & (capacity - 1);
        ++this.size;
        if (this.entries.get(index) == null) {
            Entry entry = new Entry(key, value);
            this.keys.add(key);

            List entry_list = new List();
            entry_list.add(entry);
            this.entries.set(entry_list, index);
        }
        else {
            Entry entry = new Entry(key, value);
            this.keys.add(key);

            List entry_list = (List) this.entries.get(index);
            entry_list.add(entry);
            this.entries.set(entry_list, index);
        }
    };

    public Object get(Object key) {
        int index = key.hashCode() & (capacity - 1);

        List entries = (List) this.entries.get(index);
        for (int i = 0; i < entries.size(); ++i) {
            if (key.equals(((Entry) entries.get(i)).getKey())) {
                return ((Entry) entries.get(i)).getValue();
            }
        }
        return null;
    };

    public Object get(Object key, Object bydefault) {
        int index = key.hashCode() & (capacity - 1);

        List entries = (List) this.entries.get(index);

        if (entries == null) {
            put(key, bydefault);
            return bydefault;
        }

        for (int i = 0; i < entries.size(); ++i) {
            if (key.equals(((Entry) entries.get(i)).getKey())) {
                return (Entry) ((Entry) entries.get(i)).getValue();
            }
        }

        return bydefault;
    };

    public Object remove(Object key) {
        int index = key.hashCode() & (capacity - 1);

        List entries = (List) this.entries.get(index);
        Object value = null;

        for (int i = 0; i < entries.size(); ++i) {
            if (key.equals(((Entry) entries.get(i)).getKey())) {
                value = ((Entry) entries.get(i)).getValue();
                entries.remove(i);
                keys.remove(keys.indexOf(key));
                --this.size;
            }
        }
        return value;
    };

    public boolean keyContains(Object key) {
        return this.keys.contains(key);
    };

    public List getKeys() {
        return this.keys;
    };
    public List getValues() {
        List values = new List();
        for (int i = 0; i < this.capacity; ++i) {
            if (this.entries.get(i) != null) {
                List temp = (List) this.entries.get(i);
                for (int j = 0; j < temp.size(); ++j) {
                    values.add(((Entry) temp.get(j)).getValue());
                }
            }
        }
        return values;
    };
    public List getEntries() {
        List entries = new List();
        for (int i = 0; i < this.capacity; ++i) {
            if (this.entries.get(i) != null) {
                List temp = (List) this.entries.get(i);
                for (int j = 0; j < temp.size(); ++j) {
                    entries.add(temp.get(j));
                }
            }
        }
        return entries;
    };

    public int size() {
        return size;
    };
    public boolean isEmpty() {
        return size == 0;
    };

    public void printMap() {
        List entries = this.getEntries();
        System.out.println("{");
        for (int i = 0; i < entries.size(); ++i) {
            Entry temp = (Entry)entries.get(i);
            System.out.println("\t" + temp.getKey() + ": " + temp.getValue());
        }
        System.out.println("}");
    }

    @Override
    public String toString() {
        String mapS = "{\n";
        List entries = this.getEntries();
        for (int i = 0; i < entries.size(); ++i) {
            Entry temp = (Entry)entries.get(i);
            mapS += "\t" + temp.getKey() + ": " + temp.getValue() + "\n";
        }
        mapS += "}";
        return mapS;
    }
}
