package Instruction;

import Memory.Configuration;

import java.util.List;

public class SubInstr extends Instr {

  private int regIndex;
  private int next;
  private int alter;

  public SubInstr(int index, int regIndex, int next, int alter) {
    super(InstrType.SUB, index);
    this.regIndex = regIndex;
    this.next = next;
    this.alter = alter;
  }

  @Override
  public void execute(Configuration memory, List<Instr> instrs) {
    if (!memory.getReg(regIndex).isZero()) {
      memory.getReg(regIndex).decrement();
      instrs.get(next).execute(memory, instrs);
    } else {
      instrs.get(alter).execute(memory, instrs);
    }
  }
}
