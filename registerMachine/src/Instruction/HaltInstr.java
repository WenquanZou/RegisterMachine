package Instruction;

public class HaltInstr extends Instr {

  public HaltInstr() {
    super(InstrType.HALT);
  }

  @Override
  public void execute() {
    //Halt do nothing
  }
}
