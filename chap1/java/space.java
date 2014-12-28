
import java.io.*;

public class space{

  private static String replace(char[] str, int length){
    int spaceCount = 0;
    for(int i=0; i<length; i++){
      if (str[i] == ' ') {
        spaceCount++;
      }
    }

    int newLength = length + spaceCount*2;
    //Here we copy from behind, which will be more accurate.
    for(int i=length-1; i>=0; i--){
      if (str[i] == ' ') {
        str[newLength - 1] = '0';
        str[newLength - 2] = '2';
        str[newLength - 3] = '%';
        newLength = newLength - 3;
      } else {
        str[newLength - 1] = str[i];
        newLength = newLength - 1;
      }
    }

    String result = new String(str);
    return result;
  }

  public static void main(String[] args) throws Exception{
    InputStreamReader r = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(r);
    String input = "";
    while(!input.equals("stop")){
      System.out.println("Please input a string:");
      input = br.readLine();
      System.out.println(String.format("Out put is %s length %d",input, input.length()));
      System.out.println(String.format("Result is %s",replace(input.toCharArray(), input.length() - 9)));
    }
  }
}
