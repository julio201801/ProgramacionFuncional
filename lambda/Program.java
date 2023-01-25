

import java.util.Comparator;

public class Program {

    public static void main(String[] args) {
        //Operation op1 = new Sum();
        Operation op1 = (a,b) -> a + b;
        Operation op2 = (a,b) -> a - b;
        int sum = op1.operate(5, 5);
        int minus = op2.operate(5, 5);
        System.out.println(minus);

    }

}
