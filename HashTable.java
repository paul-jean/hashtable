public class HashTable {

    private int length;
    private int[] a;

    public HashTable() {
        length = 100;
        a = new int[length]; 
    }

    public int keyPosition(String key) {
        char[] chars = key.toCharArray();
        int sum = 0;
        for (int c:chars) sum += c;
        return sum % length;
    }

    public void addKeyValuePair(String key, int val) {
        int pos = keyPosition(key);
        a[pos] = val;
    }

    public int getValue(String key) {
        int pos = keyPosition(key);
        return a[pos];
    }

    public void removeKey(String key) {
        int pos = keyPosition(key);
        a[pos] = null;
    }

    public static void main(String[] args) {
        HashTable ht = new HashTable();
        /*
        String key = "key";
        int val = 1;
        ht.addKeyValuePair(key, val);
        int v = ht.getValue(key);
        System.out.println("Value for key " + key  + ": " + v);
        */ 

        String k = ""; 
        int v;
        for (int i = 0; i < 50; i++) {
            k = String.valueOf(i);
            v = i;
            ht.addKeyValuePair(k, v);
            System.out.printf("ht.addKeyValuePair(%s, %d)\n", k, v);
            System.out.printf("ht.getValue(%s): %d\n", k, ht.getValue(k));
        }

    }
}