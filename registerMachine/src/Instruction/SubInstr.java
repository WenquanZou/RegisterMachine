package Instruction;

import static Encoder.Encoding.natureEncode;
import static Encoder.Encoding.plusEncode;

import Memory.Configuration;

import java.math.BigDecimal;
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

  @Override
  public BigDecimal encode() {
    return plusEncode(new BigDecimal(2 * this.regIndex + 1)
        , natureEncode(new BigDecimal(next), new BigDecimal(alter)));
  }
}
