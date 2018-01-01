package Gadget;

import static Encoder.Encoding.listEncode;

import Instruction.Instr;
import Memory.Configuration;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Gadget {
  private List<Instr> instrs;
  private String name;

  public Gadget(List<Instr> instrs, String name) {
    this.instrs = instrs;
    this.name = name;
  }

  public void run(Configuration memory) {
    instrs.get(0).execute(memory, instrs);
  }

  public List<Instr> getInstructions() {
    return this.instrs;
  }

  public BigDecimal encode() {
    List<BigDecimal> numbers = new ArrayList<>();
    this.instrs.forEach(instr -> numbers.add(instr.encode()));
    return listEncode(numbers);
  }
}
