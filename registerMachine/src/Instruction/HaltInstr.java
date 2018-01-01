package Instruction;

import Memory.Configuration;

import java.math.BigDecimal;
import java.util.List;

public class HaltInstr extends Instr {

  public HaltInstr(int index) {
    super(InstrType.HALT, index);
  }

  @Override
  public void execute(Configuration memory, List<Instr> instrs) {
    //Halt do nothing
  }

  @Override
  public BigDecimal encode() {
    return new BigDecimal(0);
  }
}
