import static java.lang.Math.*;
public class Point3d {
    // Координаты x, y, z
    private double xCoord;
    private double yCoord;
    private double zCoord;

    // Конструктор инициализации.
    public Point3d(double x, double y, double z) {
        this.xCoord = x;
        this.yCoord = y;
        this.zCoord = z;
    }
    // Конструктор по умолчанию.
    public Point3d() {
        this(0, 0, 0);
    }
    // Функция для проверки точек на равенство.
    public boolean EqualityCheck(Point3d point) {
        if (this.xCoord == point.getX()) {
            if (this.yCoord == point.getY()) {
                if (this.zCoord == point.getZ()) {
                    return true;
                }
            }
        }
        return false;
    }
    // Вычисление расстояние между двумя точками.
    public double distanceTo(Point3d point) {
        return sqrt(pow(point.getX() - this.xCoord, 2) + pow(point.getY() - this.yCoord, 2) + pow(point.getZ() - this.zCoord, 2));
    }
    // Возвращение координаты X.
    public double getX() {
        return xCoord;
    }
    // Возвращение координаты Y.
    public double getY() {
        return yCoord;
    }
    // Возвращение координаты Z.
    public double getZ() {
        return zCoord;
    }
    // Установка значения координатам x, y, z.
    public void setX(double x, double y, double z) {
        this.xCoord = x;
        this.yCoord = y;
        this.zCoord = z;
    }
}
