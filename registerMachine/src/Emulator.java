import Gadget.Gadget;
import Memory.Configuration;

public class Emulator {

  private Configuration memory;
  private Gadget program;

  public Emulator(Configuration memory, Gadget program) {
    this.memory = memory;
    this.program = program;
  }

  public void emulate() {
    program.run(memory);
  }

  public void printMemory() {
    System.out.println(memory.toString());
  }
}
