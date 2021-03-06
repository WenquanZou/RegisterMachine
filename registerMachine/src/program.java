import static Encoder.Encoding.decode;

import Gadget.Gadget;
import IOsystem.FileInputParser;
import Instruction.Instr;
import Memory.Configuration;
import Memory.Register;

import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public static void main(string[] args) {
  here is the change please solve the merge conflicts
}

public class program {
  public static void main(String[] args) throws FileNotFoundException {
    //Get the instructions of program.
    List<Instr> instrs = new ArrayList<>();
    List<String> s1 = new FileInputParser(args[0]).getStrings();
    s1.forEach(s -> instrs.add(Instr.parse(s, s1.indexOf(s))));

    //Get the configuration of registers.
    Map<Integer, Register> regs = new HashMap<>();
    List<String> s2 = new FileInputParser(args[1]).getStrings();
    s2.forEach(s -> {
      Register r = Register.parse(s);
      regs.put(r.getIndex(), r);
    });

    //Run emulator
    Emulator emulator = new Emulator(new Configuration(regs), new Gadget(instrs, "program"));
    emulator.emulate();
    emulator.printMemory();
    BigDecimal encode = emulator.getProgram().encode();
    Emulator emulator2 = new Emulator(new Configuration(regs), decode(encode));
    emulator2.emulate();
    emulator2.printMemory();
  }
}
