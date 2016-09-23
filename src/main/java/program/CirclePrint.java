package program;

/**
 * Created by sankarge on 14-Sep-16.
 */
public class CirclePrint {

    public static final String str = "@";
    int rightAlign = 30;
    int radius = 5;
    String whitespace1 = "-";
    String whitespace = " ";

    public static void main(String args[]) {
        CirclePrint circlePrint = new CirclePrint();
        circlePrint.print();
        circlePrint.printInverse();
//        circlePrint.print2();
    }

    private void print() {
        for (int i = 0; i < radius; i++) {
            loop(i);
        }
    }

    private void printInverse() {
        for (int i = radius - 1; i >= 0; i--) {
            loop(i);
        }
    }

    private void loop(int i) {
        printWhitSpace(i);
    }

    private void printWhitSpace(int i) {
//        double point = radius + radius * i*0.7;
        double point = Math.sqrt((radius * radius)  - (i*i));

        for (double j = rightAlign-point; j>0; j--) {
            System.out.print(whitespace1);
        }
        System.out.print(str);

        for (int j = 0; j < point*2; j++) {
            System.out.print(whitespace);
        }
        System.out.print(str);

        System.out.println();
    }

    private void print2(){
        for (int i = -radius; i <= radius; i++) {
            for (int j = -radius; j <= radius; j++) {
                if (i*i + j*j <= radius*radius) System.out.print("* ");
                else                  System.out.print(". ");
            }
            System.out.println();
        }
    }
}
