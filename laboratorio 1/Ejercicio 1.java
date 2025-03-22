

import java.util.*;
public class Coordenada {
    //Variables
    private Double x;
    private Double y;
    public Coordenada() {
        this.x = 0.0;
        this.y = 0.0;
    }
    public Coordenada(Double x, Double y) {
        this.x = x;
        this.y = y;
    }
    public Coordenada(Coordenada c) {
        this.x = c.x;
        this.y = c.y;
    }

    //Getters y Setters
    public void setX(double x) { this.x = x; }
    public void setY(double y) { this.y = y; }
    public double getX() { return x; }
    public double getY() { return y; }
    public double distancia(Coordenada c) {
        return Math.sqrt(Math.pow(c.x - this.x, 2) + Math.pow(c.y - this.y, 2));
    }

    public static double distancia(Coordenada c1, Coordenada c2) {
        return Math.sqrt(Math.pow(c2.x - c1.x, 2) + Math.pow(c2.y - c1.y, 2));
    }

    @Override
    public String toString(){
        return "(" + x + ", " + y + ")";
    }
}


>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>


public class Rectangulo {
    private Coordenada esquina1;
    private Coordenada esquina2;

    public Rectangulo(Coordenada c1, Coordenada c2) {
        this.esquina1 = new Coordenada(c1);
        this.esquina2 = new Coordenada(c2);
    }
    //Getters y Setters
    public void setEsquina1(Coordenada c1) {
        this.esquina1 = new Coordenada(c1);
    }
    public void setEsquina2(Coordenada c2) {
        this.esquina2 = new Coordenada(c2);
    }
    public Coordenada getEsquina1() {
        return esquina1;
    }
    public Coordenada getEsquina2() {
        return esquina2;
    }

    public Coordenada getCentro() {
        double centroX = (esquina1.getX() + esquina2.getX()) / 2;
        double centroY = (esquina1.getY() + esquina2.getY()) / 2;
        return new Coordenada(centroX, centroY);
    }

    public double area() {
        double ancho = Math.abs(esquina2.getX() - esquina1.getX());
        double alto = Math.abs(esquina2.getY() - esquina1.getY());
        return ancho * alto;
    }

    @Override
    public String toString() {
        return "Coordenadas de esquinas: " + esquina1 + ", " + esquina2;
    }
}



>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>



  public class ContenedorRect {
    private int n; // Capacidad máxima de rectángulos
    private Rectangulo[] listaRectangulos; // Lista de rectángulos almacenados
    private double[] listaDistancias; // Lista de distancias entre los rectángulos
    private double[] listaAreas; // Lista de áreas de los rectángulos
    private int numRec; // Número actual de rectángulos almacenados

    public ContenedorRect(int n) {
        this.n = n;
        this.listaRectangulos = new Rectangulo[n];
        this.listaDistancias = new double[n];
        this.listaAreas = new double[n];
        this.numRec = 0;
    }
    public Rectangulo[] getRectangulos() {
        return listaRectangulos;
    }
    public void agregarRectangulo(Rectangulo r) {
        if (numRec < n) {
            listaRectangulos[numRec] = r;
            listaAreas[numRec] = r.area();
            listaDistancias[numRec]=Coordenada.distancia(r.getEsquina1(),r.getEsquina2());
            numRec++;
        } else {
            System.out.println("No se pueden agregar más rectángulos.");
        }
    }
    private double calcularDistancia(Rectangulo r1, Rectangulo r2) {
        Coordenada c1 = r1.getCentro();
        Coordenada c2 = r2.getCentro();
        return Math.sqrt(Math.pow(c2.getX() - c1.getX(), 2) + Math.pow(c2.getY() - c1.getY(), 2));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Rectángulo  Coordenadas  Distancia  Área\n");

        for (int i = 0; i < numRec; i++) {
            sb.append((i + 1) + "  " +
                    "(" + listaRectangulos[i].getEsquina1() + ", " + listaRectangulos[i].getEsquina2() + ")  " +
                    listaDistancias[i] + "  " + listaAreas[i] + "\n");
        }

        return sb.toString();
    }
}



>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

  
import javax.swing.*;
import java.awt.*;

public class RectanguloVisualizer extends JFrame {
    private ContenedorRect contenedor;

    public RectanguloVisualizer(ContenedorRect contenedor) {
        this.contenedor = contenedor;
        setTitle("Visualización de Rectángulos");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        if (contenedor != null) {
            for (Rectangulo rect : contenedor.getRectangulos()) {
                if (rect != null) {
                    int x = (int) Math.min(rect.getEsquina1().getX(), rect.getEsquina2().getX());
                    int y = (int) Math.min(rect.getEsquina1().getY(), rect.getEsquina2().getY());
                    int width = (int) Math.abs(rect.getEsquina2().getX() - rect.getEsquina1().getX());
                    int height = (int) Math.abs(rect.getEsquina2().getY() - rect.getEsquina1().getY());
                    g.drawRect(x + 50, 450 - (y + height), width, height);
                }
            }
        }
    }

    public static void mostrar(ContenedorRect contenedor) {
        SwingUtilities.invokeLater(() -> new RectanguloVisualizer(contenedor));
    }
}

>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>



public class Verificador {
    public static Rectangulo normalizar(Rectangulo r) {
        double minX = Math.min(r.getEsquina1().getX(), r.getEsquina2().getX());
        double maxX = Math.max(r.getEsquina1().getX(), r.getEsquina2().getX());
        double minY = Math.min(r.getEsquina1().getY(), r.getEsquina2().getY());
        double maxY = Math.max(r.getEsquina1().getY(), r.getEsquina2().getY());

        return new Rectangulo(new Coordenada(minX, minY), new Coordenada(maxX, maxY));
    }
    public static boolean esSobrePos(Rectangulo r1, Rectangulo r2) {
        r1 = normalizar(r1);
        r2 = normalizar(r2);

        boolean sobreponeX = r1.getEsquina2().getX() > r2.getEsquina1().getX() &&
                r1.getEsquina1().getX() < r2.getEsquina2().getX();

        boolean sobreponeY = r1.getEsquina2().getY() > r2.getEsquina1().getY() &&
                r1.getEsquina1().getY() < r2.getEsquina2().getY();

        return sobreponeX && sobreponeY;
    }

    public static boolean esJunto(Rectangulo r1, Rectangulo r2) {
        r1 = normalizar(r1);
        r2 = normalizar(r2);

        boolean tocaVertical = (r1.getEsquina2().getX() == r2.getEsquina1().getX() ||
                r1.getEsquina1().getX() == r2.getEsquina2().getX()) &&
                (r1.getEsquina2().getY() > r2.getEsquina1().getY() &&
                        r1.getEsquina1().getY() < r2.getEsquina2().getY());

        boolean tocaHorizontal = (r1.getEsquina2().getY() == r2.getEsquina1().getY() ||
                r1.getEsquina1().getY() == r2.getEsquina2().getY()) &&
                (r1.getEsquina2().getX() > r2.getEsquina1().getX() &&
                        r1.getEsquina1().getX() < r2.getEsquina2().getX());

        boolean tocaEsquina = (r1.getEsquina2().getX() == r2.getEsquina1().getX() &&
                r1.getEsquina2().getY() == r2.getEsquina1().getY()) ||
                (r1.getEsquina1().getX() == r2.getEsquina2().getX() &&
                        r1.getEsquina1().getY() == r2.getEsquina2().getY());

        return (tocaVertical || tocaHorizontal || tocaEsquina) && !esSobrePos(r1, r2);
    }
    public static boolean esDisjunto(Rectangulo r1, Rectangulo r2) {
        return !esSobrePos(r1, r2) && !esJunto(r1, r2);
    }
}

>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new RectanguloInputGUI());
    }
}

class RectanguloInputGUI extends JFrame {
    private ContenedorRect contenedor;
    private JTextField x1Field, y1Field, x2Field, y2Field;
    private JTextArea outputArea;
    private int rectCount = 0, maxRects;
    private JButton verificarButton;

    public RectanguloInputGUI() {
        setTitle("Ingreso de Rectángulos");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(9, 2, 5, 5));
        
        add(new JLabel("Número máximo de rectángulos:"));
        JTextField maxRectsField = new JTextField();
        add(maxRectsField);
        
        JButton startButton = new JButton("Iniciar");
        add(startButton);
        add(new JLabel());
        
        add(new JLabel("Esquina 1 - X:"));
        x1Field = new JTextField();
        add(x1Field);
        
        add(new JLabel("Esquina 1 - Y:"));
        y1Field = new JTextField();
        add(y1Field);
        
        add(new JLabel("Esquina 2 - X:"));
        x2Field = new JTextField();
        add(x2Field);
        
        add(new JLabel("Esquina 2 - Y:"));
        y2Field = new JTextField();
        add(y2Field);
        
        JButton addButton = new JButton("Agregar Rectángulo");
        add(addButton);
        
        JButton visualizeButton = new JButton("Visualizar");
        add(visualizeButton);
        
        verificarButton = new JButton("Verificar");
        verificarButton.setEnabled(false);
        add(verificarButton);
        add(new JLabel());
        
        outputArea = new JTextArea(5, 20);
        outputArea.setEditable(false);
        add(new JScrollPane(outputArea));
        
        startButton.addActionListener(e -> {
            maxRects = Integer.parseInt(maxRectsField.getText());
            contenedor = new ContenedorRect(maxRects);
            outputArea.append("Máximo de " + maxRects + " rectángulos configurado.\n");
        });
        
        addButton.addActionListener(e -> {
            if (rectCount < maxRects) {
                double x1 = Double.parseDouble(x1Field.getText());
                double y1 = Double.parseDouble(y1Field.getText());
                double x2 = Double.parseDouble(x2Field.getText());
                double y2 = Double.parseDouble(y2Field.getText());
                
                Rectangulo rect = new Rectangulo(new Coordenada(x1, y1), new Coordenada(x2, y2));
                contenedor.agregarRectangulo(rect);
                rectCount++;
                
                outputArea.append("Rectángulo agregado: " + rect + "\n");
                
                x1Field.setText("");
                y1Field.setText("");
                x2Field.setText("");
                y2Field.setText("");
                
                if (rectCount >= 2) {
                    verificarButton.setEnabled(true);
                }
            } else {
                outputArea.append("Se ha alcanzado el límite de rectángulos.\n");
            }
        });
        
        visualizeButton.addActionListener(e -> {
            RectanguloVisualizer.mostrar(contenedor);
        });
        
        verificarButton.addActionListener(e -> {
            if (rectCount >= 2) {
                Rectangulo r1 = contenedor.getRectangulos()[0];
                Rectangulo r2 = contenedor.getRectangulos()[1];
                
                boolean sobreponen = Verificador.esSobrePos(r1, r2);
                boolean juntos = Verificador.esJunto(r1, r2);
                boolean disjuntos = Verificador.esDisjunto(r1, r2);
                
                outputArea.append("\nVerificación:\n");
                outputArea.append("¿Se sobreponen? " + sobreponen + "\n");
                outputArea.append("¿Se tocan? " + juntos + "\n");
                outputArea.append("¿Están separados? " + disjuntos + "\n");
            }
        });
        
        setVisible(true);
    }
}
