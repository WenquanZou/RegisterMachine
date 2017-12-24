package Instruction;

public class AddInstr extends Instr {
  Register operand;
  int next;

  public AddInstr(int index, Register operand, int next) {
    super(InstrType.ADD, index);
    this.operand = operand;
    this.next = next;
  }

  @Override
  public void execute() {
    this.operand.increment();
  }
}
