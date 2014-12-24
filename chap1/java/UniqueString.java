// Question 1.1
import java.io.*;

public class UniqueString{

  // O(n^2) version, iteratively scanning for found
  private static String isUniqueString(String s){
    String anw = "Yes";
    int strL = s.length();
    if (strL > 1) {
      for(int i = 0; i < strL; i++){
        char top = s.charAt(i);
        boolean found = false;

        for(int j = i+1; j < strL; j++){
          char down = s.charAt(j);
          if (top == down){
            anw = "No";
            found = true;
            break;
          }
        }

        if (found == true){
          String format = String.format("Found duplicated elements at %d %c", i, top);
          System.out.println(format);
          break;
        }
      }
    }

    return anw;
  }


  // better solution with the fact that char type is an int, and ascii is a set of 256 unique characters
  private static String smartOneWithArray(String s){
    String ans = "Yes";
    boolean[] existArray = new boolean[256];
    if (s.length() > 256) {
      ans = "No";
    } else {
      if (s.length()>0){
        for(int i=0; i < s.length(); i++){
          int pos = s.charAt(i);
          if(existArray[pos]){
            ans = "No";
            break;
          }
          existArray[pos] = true;
        }
      }
    }
    return ans;
  }

  public static void main(String[] args) throws Exception{
    // Main for test
    InputStreamReader reader = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(reader);

    int asciia = 'a';
    System.out.println(asciia);

    String input = "";
    while(!input.equals("enough")){
      System.out.println("please input a string:");
      input = br.readLine();
      System.out.println("String Unique: " + isUniqueString(input));
      System.out.println("String Unique: " + smartOneWithArray(input));
    }

    br.close();
    reader.close();
  }
}
