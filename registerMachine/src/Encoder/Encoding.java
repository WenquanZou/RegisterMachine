package Encoder;

import Gadget.Gadget;
import Instruction.Instr;

import java.math.BigDecimal;
import java.util.List;

public class Encoding {
  public static Gadget decode(BigDecimal index) {
    return null;
  }

  public static String encode(Gadget program) {
    //Encode each instruction of program body.
    List<Instr> instrs =  program.getInstructions();
    instrs.forEach(Instr::encode);
    return null;
  }

  public static BigDecimal plusEncode(BigDecimal i, BigDecimal j) {
    BigDecimal binPower = new BigDecimal(2);
    BigDecimal max = new BigDecimal(999999999);
    while (i.compareTo(max) > 0) {
      binPower = binPower.pow(max.intValue());
      i = i.subtract(max);
    }
    binPower = binPower.pow(i.intValue());
    BigDecimal factor = j.multiply(BigDecimal.valueOf(2)).add(BigDecimal.valueOf(1));
    return binPower.multiply(factor);
  }

  public static BigDecimal natureEncode(BigDecimal i, BigDecimal j) {
    return plusEncode(i, j).subtract(BigDecimal.valueOf(1));
  }
}
