package datastructure;

public class TheoHash {

    public class Entry {
        public int value;
        public Entry next = null;

        Entry(int value) {
            this.value = value;
        }

        public Entry getNextEntry(){
            return next;
        }
    }

    static final int INITIAL_CAPACITY = 11;
    private int size = INITIAL_CAPACITY;
    private Entry[] hashTable;

    public TheoHash() {
        hashTable = new Entry[size];
    }

    public TheoHash(int size) {
        this.size = size;
        hashTable = new Entry[size];
    }

    public boolean add(int value) {

        if(containValue(value)) return false;
        int index = hasing(value);
        Entry newEntry = new Entry(value);
        Entry cur = hashTable[index];

        if(cur == null){
            cur = newEntry;
            return true;
        }

         while (cur != null) {
            cur = cur.next;
        }

        cur.next = newEntry;
        return true;
    }

    public boolean containValue(int value){
        int index = hasing(value);
        Entry entry = hashTable[index];

        if(entry == null) return false;

        if(entry.value != value){
            if(entry.next==null) return false;
            entry = entry.next;
        }
        return true;
    }

    public boolean remove(int value){
        if(!containValue(value)) return false;

        int index = hasing(value);
        Entry pre = null;
        Entry cur = hashTable[index];

        if(cur.value == value){
            hashTable[index]=cur.next;
            cur=null;
        }

        if(cur.value != value){
            pre = cur;
            cur = cur.next;
        }

        pre.next = cur.next;
        cur = null;

        return true;
    }

    public Entry getEntry(int value){
        return new Entry(1);
    }

    private int hasing(int value) {
        int key = getKey(value);
        return key % size;
    }

    private int getKey(int value) {
        return value;
    }
}
