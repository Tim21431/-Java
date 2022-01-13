import java.awt.geom.Rectangle2D;
public class Tricorn extends FractalGenerator{
    public static final int MAX_ITERATIONS = 2000;

    // Поиск области
    @Override
    public void getInitialRange(Rectangle2D.Double range) {
        range.x = -2;
        range.y = -2;
        range.width = 4;
        range.height = 4;
    }

    // Итеративная функция
    @Override
    public int numIterations(double x, double y) {
        double curX = x;
        double curY = y;
        int am = 0;
        while (am < MAX_ITERATIONS) {
            am++;
            double newX = curX * curX - curY * curY + x;
            double newY = -2 * curX * curY + y;
            curX = newX;
            curY = newY;
            if (curX * curX + curY * curY > 4) {
                return am;
            }
        }
        return -1;

    }
    @Override
    public String toString(){
        return "Tricorn";
    }
}
