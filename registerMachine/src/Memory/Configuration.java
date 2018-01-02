package Memory;

import java.util.Map;

public class Configuration {
  Map<Integer, Register> registers;

  public Configuration(Map<Integer, Register> registers) {
    this.registers = registers;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    for (Register r : registers.values()) {
      sb.append(r.toString()).append("\n");
    }
    return sb.toString();
  }

  public Register getReg(int regIndex) {
    if (!registers.containsKey(regIndex)) {
      registers.put(regIndex, new Register(regIndex));
    }
    return registers.get(regIndex);
  }
}
