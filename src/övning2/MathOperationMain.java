package övning2;




        public class MathOperationMain {

            private static int operate(int a, int b, MathOperation mathOperation) {

                return mathOperation.operation(a, b);
            }

            public static void main(String args[]) {

      MathOperation addition = (a,b) -> a+b;
      MathOperation subtraction = (a,b) -> a-b;
      MathOperation multiplication = (int a, int b) -> {int j = 5 ;
      return a*b; };
      MathOperation division = (a,b) -> a/b;
      System.out.println("10 + 5 = " + operate(10, 5, addition));
      System.out.println("10 - 5 = " + operate(10, 5, subtraction));
      System.out.println("10 x 5 = " + operate(10, 5, multiplication));
      System.out.println("10 / 5 = " + operate(10, 5, division));
    }
}