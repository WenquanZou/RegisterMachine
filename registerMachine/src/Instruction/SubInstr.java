package Instruction;

public class SubInstr extends Instr {

  Register operand;
  int next;
  int alter;

  public SubInstr(Register operand, int next, int alter) {
    super(InstrType.SUB);
    this.next = next;
    this.alter = alter;
  }

  @Override
  public void execute() {
    this.operand.decrement();
  }
}
