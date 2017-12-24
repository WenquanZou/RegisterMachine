package Gadget;

import Instruction.Instr;

import java.util.List;

public class Gadget {
  private List<Instr> instrs;
  String name;

  public Gadget(List<Instr> instrs, String name) {
    this.instrs = instrs;
    this.name = name;
  }

  public void run() {
    instrs.get(0).execute();
  }
}
