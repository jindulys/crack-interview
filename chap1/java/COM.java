import java.io.*;

public class compression{
  public static void main(String[] args) throws Exception{
    // Main for test
    InputStreamReader reader = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(reader);

    String input = "";
    while(!input.equals("enough")){
      System.out.println("please input a string:");
      input = br.readLine();
    }

    br.close();
    reader.close();
  }
}
