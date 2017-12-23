package Instruction;

public class AddInstr extends Instr {
  Register operand;
  int next;

  public AddInstr(Register operand, int next) {
    super(InstrType.ADD);
    this.next = next;
  }

  @Override
  public void execute() {
    this.operand.increment();
  }
}
