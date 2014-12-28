import java.io.*;

public class compression{

  // My Implementation which require backwards checking which is ugly.
  public static String compress(String str){
    int alphaCount = 1;
    char[] resultArray = str.toCharArray();
    int length = str.length();
    String finalS = "";
    for(int i=0; i<length-1; i++){
      if(resultArray[i] == resultArray[i+1]){
        alphaCount++;
      } else {
        finalS += resultArray[i];
        finalS += alphaCount;
        alphaCount = 1;
      }
    }

    finalS += resultArray[length - 1];
    if(resultArray[length - 2] != resultArray[length - 1]){
      finalS += 1;
    } else {
      finalS += alphaCount;
    }

    if(finalS.length() < length){
      return finalS;
    } else {
      return str;
    }
  }

  // Answer's solution 1
  // However the running time for this solution is not good enough because of string concatenation
  public static String compressSOne(String str){
    int alphaCount = 0;
    char[] resultArray = str.toCharArray();
    int length = str.length();
    String finalS = "";
    char lastChar = resultArray[0];
    for(int i=0; i<length; i++){
      if(resultArray[i] == lastChar){
        alphaCount++;
      } else {
        finalS += lastChar;
        finalS += alphaCount;
        alphaCount = 1;
        lastChar = resultArray[i];
      }
    }

    finalS += lastChar;
    finalS += alphaCount;

    if(finalS.length() < length){
      return finalS;
    } else {
      return str;
    }
  }


  // Answer's solution 2
  // Using String Buffer
  public static String compressSTwo(String str){
    int size = checkNeedSize(str);
    if (size >= str.length()){
      return str;
    }

    StringBuffer bf = new StringBuffer();
    char lastChar = str.charAt(0);
    int count = 0;
    for(int i=0; i<str.length(); i++){
      if (str.charAt(i) == lastChar){
        count++;
      } else {
        bf.append(lastChar);
        bf.append(count);
        count = 1;
        lastChar = str.charAt(i);
      }
    }

    bf.append(lastChar);
    bf.append(count);
    return bf.toString();
  }

  public static int checkNeedSize(String str){
    int size = 0;
    if (str == null || str.length() == 0){
      return size;
    }

    int count = 0;
    char lastChar = str.charAt(0);
    for(int i=0; i<str.length(); i++){
      if (lastChar == str.charAt(i)){
        count++;
      } else {
        size = size + 1 + String.valueOf(count).length();
        count = 1;
        lastChar = str.charAt(i);
      }
    }

    size = size + 1 + String.valueOf(count).length();
    return size;
  }

  public static void main(String[] args) throws Exception{
    // Main for test
    InputStreamReader reader = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(reader);

    String input = "";
    while(!input.equals("enough")){
      System.out.println("please input a string:");
      input = br.readLine();
      System.out.println("Output is : " + compressSTwo(input));
    }

    br.close();
    reader.close();
  }
}
