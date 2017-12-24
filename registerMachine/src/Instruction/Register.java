package Instruction;

import java.util.StringTokenizer;

public class Register {
  final int index;
  int value;

  public Register(int index, int value) {
    this.index = index;
    this.value = value;
  }

  public Register(int index) {
    this.index = index;
    this.value = 0;
  }

  public void increment() {
    this.value++;
  }

  public void decrement() {
    this.value--;
  }

  public static Register parse(String string) {
    StringTokenizer st = new StringTokenizer(string, "R");
    return new Register(Integer.parseInt(st.nextToken()), 0);
  }
}
