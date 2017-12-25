package Instruction;

import Memory.Configuration;

import java.util.List;

public class AddInstr extends Instr {
  private int regIndex;
  private int next;

  public AddInstr(int index, int regIndex, int next) {
    super(InstrType.ADD, index);
    this.regIndex = regIndex;
    this.next = next;
  }

  @Override
  public void execute(Configuration memory, List<Instr> instrs) {
    memory.getReg(regIndex).increment();
    instrs.get(next).execute(memory, instrs);
  }
}
