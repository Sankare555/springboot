package program;

public class SteppingStones {

    public static void main(String args[]) throws Exception {
        canReachBlock(3);
        canReachBlock(4134973344876d);
        canReachBlock(473243613928344876d);
    }

    private static void canReachBlock(double blockNo) {
        double steps = formulate(blockNo);
        if (isInteger(steps)) {
            System.out.println("Go On Bob " + new Double(steps).intValue());
        } else {
            System.out.println("Better Luck Next Time " + new Double(steps).intValue());
        }
    }

    private static double formulate(double total) {
        //n(n+1)/2 = x
        //solving the above quadratic using "completing the squares" approach, we derive the following result
        //n = sqrt(2x+1/4)-1/2
        double sqrt = Math.sqrt(((8 * total) + 1) / 4);
        return sqrt-0.5;
    }

    private static boolean isInteger(double total) {
        double rem = (total)%1;
        return rem == 0;
    }
}
