public class LR2 {
    public static void main(String[] args) {

        // Создание 3-х индивидуальных точек.
        Point3d FirstPoint = new Point3d(58, 8, 26);
        Point3d SecondPoint = new Point3d(98, 4, 15);
        Point3d ThirdPoint = new Point3d(58, 8, 26);

        // Вызов функции для проверки на равенство.
        chekPoints(FirstPoint, SecondPoint, ThirdPoint);
    }

    public static void chekPoints(Point3d FirstPoint, Point3d SecondPoint, Point3d ThirdPoint) {

        /* Если одна точка равна другой, то выводит "Точки равны!".
           Проверка происходит функций EqualityCheck(), которая создана в классе Point3d.java. */
        if (FirstPoint.EqualityCheck(SecondPoint) || SecondPoint.EqualityCheck(ThirdPoint) || ThirdPoint.EqualityCheck(FirstPoint))
            System.out.println("Odinakovie tochki!");

            // Если точки неравны, то запускается функция computeArea, которая рассчитывает площадь.
        else
            System.out.println("The area of the triangle: " + computeArea(FirstPoint, SecondPoint, ThirdPoint));
    }

    /* Статический метод computeArea, который принимает три объекта типа Point3d и вычисляет площадь треугольника,
    образованного этими точками. */
    public static double computeArea(Point3d FirstPoint, Point3d SecondPoint, Point3d aThirdPoint) {
        double a = FirstPoint.distanceTo(SecondPoint);
        double b = SecondPoint.distanceTo(aThirdPoint);
        double c = aThirdPoint.distanceTo(FirstPoint);
        // Расчёт полупериметра треугольника.
        double p = (a+b+c)/2;
        // Расчёт площади треугольника по формуле Герона.
        return (Math.sqrt(p*(p-a)*(p-b)*(p-c)));
    }
}
