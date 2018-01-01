package Instruction;

import static Encoder.Encoding.plusEncode;

import Memory.Configuration;

import java.math.BigDecimal;
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

  @Override
  public BigDecimal encode() {
    return plusEncode(new BigDecimal(2 * this.regIndex), new BigDecimal(next));
  }
}
