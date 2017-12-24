import Instruction.Instr;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {

  public static void main(String[] args) throws FileNotFoundException {
    Scanner file = new Scanner(new File(args[0]));
    List<String> strings = new ArrayList<>();
    while (file.hasNext()) {
      strings.add(file.nextLine());
    }

    List<Instr> instrs = new ArrayList<>();
    strings.forEach(s -> instrs.add(Instr.parse(s, strings.indexOf(s))));
    return;
  }
}
