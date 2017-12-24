package Instruction;

public class HaltInstr extends Instr {

  public HaltInstr(int index) {
    super(InstrType.HALT, index);
  }

  @Override
  public void execute() {
    //Halt do nothing
  }
}
