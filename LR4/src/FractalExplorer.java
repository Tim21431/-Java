import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Rectangle2D;
import javax.swing.*;
public class FractalExplorer {
    private int displaySize;
    private JImageDisplay display;
    private FractalGenerator generator;
    private Rectangle2D.Double range;

    FractalExplorer(int size){
        displaySize = size;
        generator = new Mandelbrot();
        range = new Rectangle2D.Double(0, 0, 0, 0);
        generator.getInitialRange(this.range);
    }
    public static void main(String[] args) throws InterruptedException {
        FractalExplorer explorer = new FractalExplorer(750);
        explorer.createAndShowGUI();
        explorer.drawFractal();
    }
    // Окно отрисовки
    private void createAndShowGUI(){
        JFrame frame = new JFrame("Fractal Generator");
        JButton button = new JButton("Reset");
        display = new JImageDisplay(displaySize, displaySize);
        display.addMouseListener(new MouseListener());

        button.addActionListener(new ActionHandler());

        frame.setLayout(new BorderLayout());
        frame.add(display, BorderLayout.CENTER);
        frame.add(button, BorderLayout.NORTH);
        //Операция закрытия окна выхода из приложения по умолчанию
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Данные операции правильно разметят содержимое окна, сделают его видимым
        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
    }
    // Отрисовка фрактала
    private void drawFractal(){
        double xCoord = 0;
        double yCoord = 0;
        for(int x = 0; x < displaySize; x++){
            for(int y = 0; y < displaySize; y++){
                xCoord = FractalGenerator.getCoord(range.x, range.x + range.width, displaySize, x);
                yCoord = FractalGenerator.getCoord(range.y, range.y + range.height, displaySize, y);
                int am = generator.numIterations(xCoord, yCoord);
                if(am == -1){
                    display.drawPixel(x, y, 0);
                }
                else{
                    float hue = 0.7f + (float) am/200f;
                    int rgbColor = Color.HSBtoRGB(hue, 1f, 1f);
                    display.drawPixel(x, y, rgbColor);
                }
            }
        }
        //Команда для обновления экрана
        display.repaint();
    }
    // Кнопка reset
    public class ActionHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            generator.getInitialRange(range);
            drawFractal();
        }
    }
    // Нажатие мыши
    public class MouseListener extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e){
            double x = FractalGenerator.getCoord(range.x, range.x + range.width, displaySize, e.getX());
            double y = FractalGenerator.getCoord(range.y, range.y + range.height, displaySize, e.getY());
            generator.recenterAndZoomRange(range, x, y, 0.5);
            drawFractal();
        }
    }
}
