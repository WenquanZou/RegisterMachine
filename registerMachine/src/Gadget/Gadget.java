package Gadget;

import Instruction.Instr;
import Memory.Configuration;

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
}
