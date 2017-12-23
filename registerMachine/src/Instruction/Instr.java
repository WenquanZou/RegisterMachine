package Instruction;

public abstract class Instr {

  final InstrType type;

  Instr(InstrType type) {
    this.type = type;
  }

  public abstract void execute();
}
