package Encoder;

import Gadget.Gadget;
import Instruction.AddInstr;
import Instruction.HaltInstr;
import Instruction.Instr;

import Instruction.SubInstr;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public class Encoding {

  //-----Decode Process-----//
  @NotNull
  public static Gadget decode(BigDecimal index) {
    List<BigDecimal> elems = new ArrayList<>();
    while (index.compareTo(BigDecimal.ZERO) != 0) {
      List<BigDecimal> pair = decodePair(index);
      //Second factor of plusEncode
      index = pair.get(1);
      //First factor of plusEncode
      elems.add(pair.get(0));
    }
    List<Instr> instrs = new ArrayList<>();
    elems.forEach(e -> instrs.add(decodeElem(e, elems.indexOf(e))));
    return new Gadget(instrs, "program");
  }

  @NotNull
  private static Instr decodeElem(BigDecimal e, int index) {
    if (e.compareTo(BigDecimal.ZERO) == 0) {
      return new HaltInstr(index);
    }

    List<BigDecimal> pair = decodePair(e);
    BigDecimal regIndex = pair.get(0);
    BigDecimal two = new BigDecimal(2);
    BigDecimal instrIndex = pair.get(1);

    if (isDivisible(regIndex, two)) {
      //Case for add instruction
      regIndex = regIndex.divide(two);
      return new AddInstr(index, regIndex.intValue(), instrIndex.intValue());
    }

    //Case for sub instruction
    regIndex = regIndex.subtract(BigDecimal.ONE).divide(two);
    //Decode instruction index.
    List<BigDecimal> subInstrIndex = decodePair(instrIndex.add(BigDecimal.ONE));
    BigDecimal nextIndex = subInstrIndex.get(0);
    BigDecimal alterIndex = subInstrIndex.get(1);
    return new SubInstr(index, regIndex.intValue(), nextIndex.intValue(), alterIndex.intValue());
  }

  private static List<BigDecimal> decodePair(BigDecimal elem) {
    List<BigDecimal> result = new ArrayList<>();
    int fstFactor = 0;
    BigDecimal two = new BigDecimal(2);
    while (isDivisible(elem, two)) {
      elem = elem.divide(two);
      fstFactor++;
    }
    //First factor of plusEncode
    result.add(new BigDecimal(fstFactor));
    //Second factor of plusEncode
    result.add(elem.subtract(BigDecimal.ONE).divide(two));
    return result;
  }

  private static boolean isDivisible(BigDecimal number, BigDecimal divisor) {
    return number.remainder(divisor) == BigDecimal.ZERO;
  }
  //----End Decode Process---//


  //-----Encode Process------//
  public static BigDecimal listEncode(List<BigDecimal> elems) {
    if (elems.size() == 0) {
      return new BigDecimal(0);
    }
    return plusEncode(elems.get(0), listEncode(elems.subList(1, elems.size())));
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
  //----End Encode Process---//
}
