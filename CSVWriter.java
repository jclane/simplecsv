package me.justinlane.simplecsv;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple CSV writer.
 *
 * @author Justin Lane
 * @version 4.1
 */
public class CSVWriter {
  
  /**
   * Creates *.CSV file with data as the content using delimit as a delimiter.
   * 
   * @param filePath a Path indicating the path and file name
   * @param data a list of lists with string data to save
   * @param delimit a string use as a delimiter
   */ 
  public static void writeLines(Path filePath, List<List<String>> data, String delimit) 
       throws IOException {
    FileWriter fw = new FileWriter(filePath.toFile());
    for (List<String> row : data) {
      fw.append(String.join(delimit, row));
      fw.append("\n");
    }
    fw.flush();
    fw.close();
  }  
   
  /**
   * Creates *.CSV file with data as the content using comma as a delimiter.
   * 
   * @param filePath a string indicating the path and file name
   * @param data a list of lists with string data to save
   */
  public static void writeLines(Path filePath, List<List<String>> data) 
      throws IOException {
    writeLines(filePath, data, ",");
  }   
   
   
  /**
   * Creates *.CSV file with data as the content using delimit as a delimiter.
   * 
   * @param filePath a string indicating the path and file name
   * @param data a list of lists with string data to save
   * @param delimit a string use as a delimiter
   */ 
  public static void writeLines(String filePath, List<List<String>> data, String delimit) 
       throws IOException {
    FileWriter fw = new FileWriter(filePath);
    for (List<String> row : data) {
      fw.append(String.join(delimit, row));
      fw.append("\n");
    }
    fw.flush();
    fw.close();
  }
  
  /**
   * Creates *.CSV file with data as the content using comma as a delimiter.
   * 
   * @param filePath a string indicating the path and file name
   * @param data a list of lists with string data to save
   */
  public static void writeLines(String filePath, List<List<String>> data) 
      throws IOException {
    writeLines(filePath, data, ",");
  }
  
  /**
   * Gets the path of a file object (creating it if needed) and writing data as
   * the content and delimit as a delimiter.
   * 
   * @param file a File object to write to
   * @param data a list of lists with string data to save
   */
   public static void writeLines(File file, List<List<String>> data, String delimit) 
      throws IOException {
     file.createNewFile();
     writeLines(file.getPath(), data, delimit);
   }
  
  /**
   * Writes to file object with data as the content.
   * 
   * @param file a File object to write to
   * @param data a list of lists with string data to save
   */
   public static void writeLines(File file, List<List<String>> data) 
      throws IOException {
     writeLines(file.getPath(), data, ",");
   }
  
}
