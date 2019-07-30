package me.justinlane.simplecsv;

class CSVReader {
  
  private String delimit = ",";
  private ArrayList<ArrayList<String>> lines = new ArrayList<ArrayList<String>>();
  
  public Reader(String filePath, String delimit) {
    setDelimit(delimit);
    try {
      this.lines = readFile(filePath);
    } catch (FileNotFoundException e) {
      System.out.println("ERR: File not found.");
    }
  }
  
  public Reader(String filePath) {
    try {
      this.lines = readFile(filePath);
    } catch (FileNotFoundException e) {
      System.out.println("ERR: File not found.");
    }
  }
  
  public String getDelimit() {
    return this.delimit;
  }
  
  private void setDelimit(String delimit) {
    this.delimit = delimit;
  }
  
  public ArrayList<ArrayList<String>> getLines() {
    return this.lines;    
  }
  
  /**
   * This will ignore delimiters found within quotes and 
   * remove the quote characters.
   * 
   * Most code from: https://stackoverflow.com/a/2120714
   */  
  private List<String> handleQuotes(String str) {
    List<String> result = new ArrayList<String>();
    int start = 0;
    boolean inQuotes = false;
    for (int current = 0; current < str.length(); current++) {
        if (str.charAt(current) == '\"') inQuotes = !inQuotes; // toggle state
        boolean atLastChar = (current == str.length() - 1);
        if(atLastChar) result.add(str.substring(start));
        else if (str.charAt(current) == this.delimit.charAt(0) && !inQuotes) {
            result.add(str.substring(start, current).replace("\"", ""));
            start = current + 1;
        }
    }
    return result;
  }  
   
  private ArrayList<ArrayList<String>> readFile(String filePath) throws FileNotFoundException {
    Scanner scanner = new Scanner(new File(filePath));
    while (scanner.hasNextLine()) {
      ArrayList<String> columnData = new ArrayList<String>();
      for (String data : handleQuotes(scanner.nextLine())) {
        columnData.add(data); 
      }    
      this.lines.add(columnData);        
    }
    scanner.close();
    
    return this.lines;
  }
  
  public void printLines() {
    if (this.lines.size() > 0) {
      for (ArrayList<String> line : this.lines) {
        System.out.println(String.join(delimit, line));
      }
    }
  }
    
} 