package Instruction;

import Memory.Configuration;

import java.util.List;
import java.util.StringTokenizer;

public abstract class Instr {

  final InstrType type;
  final int index;

  Instr(InstrType type, int index) {
    this.type = type;
    this.index = index;
  }

  public abstract void execute(Configuration memory, List<Instr> instrs);

  public static Instr parse(String s, int index) {
    StringTokenizer tokenizer = new StringTokenizer(s, " ,Rr");
    //Declare variable for add and sub.
    int regIndex;
    int next;
    switch (tokenizer.nextToken().toUpperCase()) {
      case "ADD":
        //Parse register from string.
        regIndex = Integer.parseInt(tokenizer.nextToken());
        //Get the index of next instruction.
        next = Integer.parseInt(tokenizer.nextToken());
        return new AddInstr(index, regIndex, next);
      case "SUB":
        //Parse register from string.
        regIndex = Integer.parseInt(tokenizer.nextToken());
        //Get the index of next instruction.
        next = Integer.parseInt(tokenizer.nextToken());
        int alter = Integer.parseInt(tokenizer.nextToken());
        return new SubInstr(index, regIndex, next, alter);
      default:
        return new HaltInstr(index);
    }
  }
}
