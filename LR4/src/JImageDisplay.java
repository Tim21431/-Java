import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
public class JImageDisplay extends JComponent{
    private BufferedImage image;

    /**Конструктор принимает целочисленные значения ширины и высоты и инициализирует
     * объект BufferedImage новым
     * изображением с этой шириной и высотой, и типом изображения
     * TYPE_INT_RGB.
     */
    JImageDisplay(int width, int height){
        image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Dimension dimension = new Dimension(width, height);
        super.setPreferredSize(dimension);
    }
    /** Функция отрисовки
     * Мы передаем значение null для ImageObserver, поскольку данная
     функциональность не требуется.**/
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(image, 0, 0, image.getWidth(), image.getHeight(), null);
    }

    /** Очистка изображения
     *  Данный метод устанавливает все пиксели
     * изображения в черный цвет (значение RGB 0)
     */
    public void clearImage(){
        for (int i = 0; i < image.getWidth(); i++) {
            for (int j = 0; j < image.getHeight(); j++) {
                image.setRGB(i,j,0);
            }
        }
    }

    //Метод который устанавливает пиксель в определенный цвет.
    public void drawPixel(int x, int y, int rgbColor){
        image.setRGB(x, y, rgbColor);
    }
}
