import java.lang.ArrayIndexOutOfBoundsException;

public class HashTable {

    private int length;
    private int[] valuesArray;
    private String[] keysArray;
    private int numKeys;

    public HashTable() {
        length = 100;
        valuesArray = new int[length]; 
        keysArray = new String[length];
        numKeys = 0;
    }

    public int keyPosition(String key) {
        char[] chars = key.toCharArray();
        int sum = 0;
        for (int c:chars) sum += c;
        return sum % length;
    }

    public void addKeyValuePair(String key, int val) {
        if (numKeys == length) {
            throw new ArrayIndexOutOfBoundsException();
        } else {
            int pos = keyPosition(key);

            if (keysArray[pos] != null) {
                
                while (keysArray[pos] != null) {
                    pos += 1;
                
                    if (pos >= length) {
                        pos = 0;
                    }

                }   
        
                keysArray[pos] = key;
                valuesArray[pos] = val;
                numKeys++;
                
            } else {
                keysArray[pos] = key;
                valuesArray[pos] = val;
                numKeys++;
            }
        }
    }

    public int getValue(String key) {
        int pos = keyPosition(key);
        return valuesArray[pos];
    }

    public void removeKey(String key) {
        int pos = keyPosition(key);
        valuesArray[pos] = 0;
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
        for (int i = 0; i < 100; i++) {
            k = String.valueOf(i);
            v = i;
            ht.addKeyValuePair(k, v);
        /*    System.out.printf("ht.addKeyValuePair(%s, %d)\n", k, v);
            System.out.printf("ht.getValue(%s): %d\n", k, ht.getValue(k)); */
        }

        ht.addKeyValuePair("key", 1);
        ht.addKeyValuePair("yek", 2);

        System.out.printf("ht.getValue(%s) = %d\n", "key", ht.getValue("key"));
         System.out.printf("ht.getValue(%s) = %d\n", "yek", ht.getValue("yek"));

       // ht.removeKey("25");

      /*  System.out.printf("ht.getValue(%s) = %d\n", "25", ht.getValue("25")); */

    }
}