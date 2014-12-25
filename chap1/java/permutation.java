import java.io.*;

public class permutation{


    /* My Implementation:
    *  drawbacks: No check for space
    *             is not case sensative
    *  O(1) space, O(n) time
    */
    private static String permutationCheck(String s1, String s2){
      // If it is a ascii string
      int[] charList1 = new int[256];
      int[] charList2 = new int[256];

      String ans = "Yes";
      if (s1.length() == s2.length()){
        for(int i=0; i<s1.length(); i++){
          int pos = s1.charAt(i);
          charList1[pos]++;
        }

        for(int i=0; i<s2.length(); i++){
          int pos = s2.charAt(i);
          charList2[pos]++;
        }

        for(int i=0; i< 256; i++){
          if(charList1[i] != charList2[i]){
            ans = "No";
            break;
          }
        }
      } else {
        ans = "No";
      }
      return ans;
    }


    /* Answer's Implementation:
    *  O(n) space, O(nlgn) time worst case
    */
    private static String sort(String s){
      char[] charList = s.toCharArray();
      java.util.Arrays.sort(charList);
      return new String(charList);
    }

    private static String sortPermuationCheck(String s1, String s2){
      String ans = "No";
      if (s1.length() == s2.length()){
        ans = sort(s1).equals(sort(s2))?"Yes":"No";
      }
      return ans;
    }

    /* Answer's Implementation :
    *  almost the same as my implementation except it will run faster than mine, because it uses less comparisons
    */
    private static String betterPermuationCheck(String s1, String s2){
      String ans = "Yes";
      if (s1.length() != s2.length()){
        return "No";
      }

      int[] charList = new int[256];
      char[] char1 = s1.toCharArray();

      for(char i:char1){
        charList[i]++;
      }

      for(int i=0; i<s2.length(); i++){
        int chari = (int)s2.charAt(i);
        if (--charList[chari] < 0){
          ans = "No";
          break;
        }
      }
      return ans;
    }

    public static void main(String[] args) throws Exception{
      String input = "";
      String input1 = "";
      InputStreamReader reader = new InputStreamReader(System.in);
      BufferedReader br = new BufferedReader(reader);

      while(!input.equals("enough")){
        System.out.println("Please Input String 1:");
        input1 = br.readLine();
        System.out.println("Please Input String 2:");
        input = br.readLine();
        System.out.println("This two Strings are permutation : " + permutationCheck(input1,input));
        System.out.println("This two Strings are permutation : " + sortPermuationCheck(input1,input));
        System.out.println("This two Strings are permutation : " + betterPermuationCheck(input1,input));
      }
    }
}
