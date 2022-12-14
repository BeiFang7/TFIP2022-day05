package milton;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class Main{

  public static final String HEADER = "Word, Count"; //constants not changed
  public static void main(String[] args) throws Exception{
    // java -cp classes milton.Main paradise_lost.txt
    
    String fileName = args[0];

    System.out.printf("Processing %s\n", fileName);

    //Open the file
    // Read the first 100 lines, print out each line
    //Close the file when done
    //if the file is less than 100 lines, close when done

    
    FileReader fr = new FileReader(fileName);
    BufferedReader br = new BufferedReader(fr);

    //Count the number of words in the first 100 line.
    //Total words
    //how many each words appears?
    //no of unique words

    Integer totalWords = 0;
    Map<String, Integer> wordMap = new HashMap<>();

    for(Integer i = 1;i<=100;i++){
      String line;
      line = br.readLine();
  
      if(null == line){
        break;
      } //System.out.printf("%d: %s\n",(i),line.toUpperCase());
        String[] words = line.trim().split(" ");
        totalWords += words.length;

        /*for(String w: words){
          if(wordMap.containsKey(w)){
            wordMap.put(w,wordMap.get(w)+1);
          } else{
            wordMap.put(w,1);
          }
        }*/

        for(String w:words){
          String clearword = w.replaceAll(",","");
          Integer v = wordMap.getOrDefault(w, 0);
          v++;
          wordMap.put(w,v);
        }
          
      }//for
        
    
    br.close();
    fr.close();

    Set <String> uniqueWords = wordMap.keySet();
    
    for(String w:uniqueWords){
    System.out.printf(">%s: %d\n", w, wordMap.get(w));
    System.out.println();
    }

    System.out.printf("The number of words in first 100 lines: %d\n",totalWords);
    System.out.printf("The number of unique words: %d\n",uniqueWords.size());

    // Create CSV file
    FileOutputStream fos = new FileOutputStream(args[1]);
    OutputStreamWriter osw = new OutputStreamWriter(fos);

    osw.write(HEADER);
    for(String w:wordMap.keySet()){
      String line = String.format("%s, %d\n",w,wordMap.get(w));
      osw.write(line);
    }
    osw.flush();
    osw.close();
    fos.close();


    // Path p = Paths.get("day-05-class/paradise_lost.txt");
    // InputStream is = new FileInputStream(p.toFile());
    // GZIPInputStream gis = new GZIPInputStream(is);
    // InputStreamReader isr = new InputStreamReader(gis);
    // LineNumberReader lnr = new LineNumberReader(isr);
    // String line;

    // while (null != (line = lnr.readLine())){
    //   System.out.println(line+ lnr.getLineNumber());
    // }
    // is.close();


  }


}//main