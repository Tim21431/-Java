import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Rectangle2D;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FractalExplorer {
    private int displaySize;
    private JImageDisplay display;
    private FractalGenerator generator;
    private Rectangle2D.Double range;
    private JComboBox<FractalGenerator> comboBox;
    FractalExplorer(int size){
        displaySize = size;
        generator = new Mandelbrot();
        range = new Rectangle2D.Double(0, 0, 0, 0);
        generator.getInitialRange(this.range);
    }

    public static void main(String[] args) throws InterruptedException {
        FractalExplorer explorer = new FractalExplorer(700);
        explorer.createAndShowGUI();
        explorer.drawFractal();
    }

    // Окно отрисовки
    private void createAndShowGUI(){
        JFrame frame = new JFrame("Fractal Generator");
        display = new JImageDisplay(displaySize, displaySize);
        display.addMouseListener(new MouseListener());

        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();

        JLabel label = new JLabel("Fractal:");

        comboBox = new JComboBox<>();
        comboBox.addItem(new Mandelbrot());
        comboBox.addItem(new Tricorn());
        comboBox.addItem(new BurningShip());
        comboBox.addActionListener(new ActionHandler());

        JButton buttonReset = new JButton("Reset");
        buttonReset.setActionCommand("Reset");
        buttonReset.addActionListener(new ActionHandler());

        JButton buttonSave = new JButton("Save image");
        buttonSave.setActionCommand("Save");
        buttonSave.addActionListener(new ActionHandler());

        panel1.add(label, BorderLayout.CENTER);
        panel1.add(comboBox, BorderLayout.CENTER);
        panel2.add(buttonReset, BorderLayout.CENTER);
        panel2.add(buttonSave, BorderLayout.CENTER);

        frame.setLayout(new BorderLayout());
        frame.add(display, BorderLayout.CENTER);
        frame.add(panel1, BorderLayout.NORTH);
        frame.add(panel2, BorderLayout.SOUTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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
        display.repaint();
    }

    // Кнопка reset
    public class ActionHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getActionCommand().equals("Reset")){
                generator.getInitialRange(range);
                drawFractal();
            }
            else if(e.getActionCommand().equals("Save")){
                JFileChooser fileChooser = new JFileChooser();//Выбор в какой файл пользователь будет сохранять изображение
                FileNameExtensionFilter fileFilter = new FileNameExtensionFilter("PNG Images", "png");
                fileChooser.setFileFilter(fileFilter);
                fileChooser.setAcceptAllFileFilterUsed(false);
                int t = fileChooser.showSaveDialog(display);
                if(t == JFileChooser.APPROVE_OPTION){
                    try{
                        ImageIO.write(display.getImage(), "png", fileChooser.getSelectedFile());
                    }
                    catch (NullPointerException | IOException ee){
                        JOptionPane.showMessageDialog(display, ee.getMessage(),"Can't save image", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
            else {
                generator = (FractalGenerator) comboBox.getSelectedItem();
                range = new Rectangle2D.Double(0, 0, 0, 0);
                generator.getInitialRange(range);
                drawFractal();
            }

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



