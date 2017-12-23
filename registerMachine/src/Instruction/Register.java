package Instruction;

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
}
