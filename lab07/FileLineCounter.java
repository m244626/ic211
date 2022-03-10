import java.util.*;
import java.io.*;
public class FileLineCounter {
  public static int countLines(String filename) throws FileNotFoundException{
    int lines = 0;
    
    Scanner sc = null;
    try{
      sc = new Scanner(new FileReader(filename));
    }catch(Exception e){
        System.out.println(e);
        System.exit(1);
    }
    
    while (sc.hasNextLine()) {
      sc.nextLine();
      lines++;
    }
    sc.close();
    return lines;
  }
}
