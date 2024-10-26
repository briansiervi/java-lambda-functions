package br.com.briansiervi.lambdafunctions;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LambdafunctionsApplication {

  public static void main(String[] args) {
    // SpringApplication.run(LambdafunctionsApplication.class, args);
    evaluate01();
  }

  private static void evaluate01() {
    List<Integer> values = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    final Stream<Integer> temp = values
        .stream()
        .filter(LambdafunctionsApplication::isGreaterThan3SimpleFunction)
        .filter(isGreaterThan3Predicate)
        .filter(isGreaterThan.apply(3))
        .filter(LambdafunctionsApplication::isEven)
        .map(LambdafunctionsApplication::doubleIt);

    System.out.println(temp.findFirst());
  }

  private static boolean isGreaterThan3SimpleFunction(int number) {
    System.out.println("isGreterThan3Function " + number);
    return number > 3;
  }

  private static Predicate<Integer> isGreaterThan3Predicate = number -> number > 3;

  private static Function<Integer, Predicate<Integer>> isGreaterThan = pivot -> number -> number > pivot;

  private static boolean isEven(int number) {
    System.out.println("isEven " + number);
    return number % 2 == 0;
  }

  private static int doubleIt(int number) {
    System.out.println("doubleIt " + number);
    return number * 2;
  }

}
