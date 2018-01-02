package Memory;


import java.util.StringTokenizer;

public class Register{
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
    StringTokenizer st = new StringTokenizer(string, " Rr");
    int index = Integer.parseInt(st.nextToken());
    int value = 0;
    if (st.hasMoreTokens()) {
      value = Integer.parseInt(st.nextToken());
    }
    return new Register(index, value);
  }

  public int getIndex() {
    return index;
  }

  public boolean isZero() {
    return value == 0;
  }

  @Override
  public String toString() {
    return "R" + index + " " + value;
  }
}
