package me.justinlane.simplecsv;

class CSVWriter {
  
  private String delimit = ",";
  
  public void writeLines(ArrayList<ArrayList<String>> data, String filePath) throws IOException {
    FileWriter fw = new FileWriter(filePath);
    for (ArrayList<String> row : data) {
      fw.append(String.join(this.delimit, row));
      fw.append("\n");
    }
    fw.flush();
    fw.close();
  }
  
}