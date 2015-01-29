import java.util.Arrays;
import java.util.Hashtable;
import java.util.LinkedList;

public class questiontwob {
    // sort a string and return a sorted new string
    private static String sortString(String s) {
        char[] content = s.toCharArray();
        Arrays.sort(content);
        return new String(content);
    }

    public static void sort(String[] array) {
        Hashtable<String, LinkedList<String>> hash = new Hashtable<String, LinkedList<String>>();

        for(String s: array){
            String key = sortString(s);
            if (!hash.containsKey(key)) {
                hash.put(key, new LinkedList<String>());
            }
            LinkedList<String> anagrams = hash.get(key);
            anagrams.push(s);
        }

        int index = 0;
        for(String key: hash.keySet()){
            for(String s: hash.get(key)){
                array[index++] = s;
            }
        }
    }

    public static void main(String[] args) {
        String[] array = {"apple", "banana", "carrot", "ele", "duck", "papel", "tarroc", "cudk", "eel", "lee"};
        sort(array);
        System.out.println(array[0]);
        System.out.println(array[1]);
        System.out.println(array[2]);
        System.out.println(array[3]);
        System.out.println(array[4]);
        System.out.println(array[5]);
        System.out.println(array[6]);
        System.out.println(array[7]);
        System.out.println(array[8]);
        System.out.println(array[9]);
    }
}
