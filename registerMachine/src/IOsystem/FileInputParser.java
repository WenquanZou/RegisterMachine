package IOsystem;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileInputParser {
  private List<String> strings;

  public FileInputParser(String fileName) throws FileNotFoundException {
    this.strings = fileInput(fileName);
  }

  public List<String> getStrings() {
    return strings;
  }

  private static List<String> fileInput(String arg) throws FileNotFoundException {
    Scanner file = new Scanner(new File(arg));
    List<String> strings = new ArrayList<>();
    while (file.hasNext()) {
      strings.add(file.nextLine());
    }
    return strings;
  }
}
