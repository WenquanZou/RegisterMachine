package Instruction;

import java.util.StringTokenizer;

public abstract class Instr {

  final InstrType type;
  final int index;

  Instr(InstrType type, int index) {
    this.type = type;
    this.index = index;
  }

  public abstract void execute();

  public static Instr parse(String s, int index) {
    StringTokenizer tokenizer = new StringTokenizer(s, " ,");
    //Declare variable for add and sub.
    String operandToken;
    Register operand;
    int next;
    switch (tokenizer.nextToken().toUpperCase()) {
      case "ADD":
        //Parse register from string.
        operandToken = tokenizer.nextToken();
        operand = Register.parse(operandToken);
        //Get the index of next instruction.
        next = Integer.parseInt(tokenizer.nextToken());
        return new AddInstr(index, operand, next);
      case "SUB":
        //Parse register from string.
        operandToken = tokenizer.nextToken();
        operand = Register.parse(operandToken);
        //Get the index of next instruction.
        next = Integer.parseInt(tokenizer.nextToken());
        int alter = Integer.parseInt(tokenizer.nextToken());
        return new SubInstr(index, operand, next, alter);
      case "HALT":
        return new HaltInstr(index);
    }
    return null;
  }
}
