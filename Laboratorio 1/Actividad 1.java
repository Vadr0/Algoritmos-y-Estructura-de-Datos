// Clase que representa una coordenada en el plano cartesiano
class Coordenada {
    private double x;
    private double y;

    public Coordenada() {
        this.x = 0;
        this.y = 0;
    }

    public Coordenada(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Coordenada(Coordenada c) {
        this.x = c.x;
        this.y = c.y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    // Método de instancia para calcular la distancia euclidiana entre dos
    // coordenadas
    public double distancia(Coordenada c) {
        double dx = this.x - c.x;
        double dy = this.y - c.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    // Método estático para calcular la distancia euclidiana entre dos coordenadas
    // dadas
    public static double distancia(Coordenada c1, Coordenada c2) {
        double dx = c1.getX() - c2.getX();
        double dy = c1.getY() - c2.getY();
        return Math.sqrt(dx * dx + dy * dy);
    }

    @Override
    public String toString() {
        return "[" + x + ", " + y + "]";
    }
}


>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>


import java.awt.*;
import javax.swing.*;
import java.util.Scanner;

public class Principal extends JPanel {
    private Rectangulo rect1, rect2, interseccion;

    // Constructor que recibe los rectángulos y calcula la intersección
    public Principal(Rectangulo rect1, Rectangulo rect2) {
        this.rect1 = rect1;
        this.rect2 = rect2;
        this.interseccion = rectanguloSobre(rect1, rect2);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ContainerRect contenedor = new ContainerRect(3);

        System.out.println("Ingrese la coordenada x de la primera esquina del 1er rectángulo:");
        double x1 = scanner.nextDouble();
        System.out.println("Ingrese la coordenada y de la primera esquina del 1er rectángulo:");
        double y1 = scanner.nextDouble();
        System.out.println("Ingrese la coordenada x de la segunda esquina del 1er rectángulo:");
        double x2 = scanner.nextDouble();
        System.out.println("Ingrese la coordenada y de la segunda esquina del 1er rectángulo:");
        double y2 = scanner.nextDouble();
        Rectangulo rect1 = new Rectangulo(new Coordenada(x1, y1), new Coordenada(x2, y2));

        System.out.println("Ingrese la coordenada x de la primera esquina del 2do rectángulo:");
        double x3 = scanner.nextDouble();
        System.out.println("Ingrese la coordenada y de la primera esquina del 2do rectángulo:");
        double y3 = scanner.nextDouble();
        System.out.println("Ingrese la coordenada x de la segunda esquina del 2do rectángulo:");
        double x4 = scanner.nextDouble();
        System.out.println("Ingrese la coordenada y de la segunda esquina del 2do rectángulo:");
        double y4 = scanner.nextDouble();
        Rectangulo rect2 = new Rectangulo(new Coordenada(x3, y3), new Coordenada(x4, y4));

        contenedor.addRectangulo(rect1);
        contenedor.addRectangulo(rect2);

        System.out.println("\n Contenedor:");
        System.out.println(contenedor);

        System.out.println(rect1);
        System.out.println(rect2);

        // Evaluar las relaciones con los métodos booleanos
        if (Verificador.SobrePuestos(rect1, rect2)) {
            System.out.println("Los rectángulos A y B se sobreponen.");
            Rectangulo interseccion = rectanguloSobre(rect1, rect2);
            if (interseccion != null) {
                System.out.println("Área de sobreposición: " + interseccion.calcularArea());
            }
        } else if (Verificador.esJuntos(rect1, rect2)) {
            System.out.println("Los rectángulos A y B están juntos.");
        } else {
            System.out.println("Los rectángulos A y B son disjuntos.");
        }

        // Crear ventana con el componente gráfico
        JFrame ventana = new JFrame("Dibujo de Rectángulos");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(600, 600);

        // Agregar panel gráfico con los rectángulos
        Principal panel = new Principal(rect1, rect2);
        ventana.add(panel);
        ventana.setVisible(true);

        scanner.close();
    }

    // Método de clase que calcula el rectángulo de sobreposición entre dos
    // rectángulos
    public static Rectangulo rectanguloSobre(Rectangulo a, Rectangulo b) {
        double x1 = Math.max(a.getEsquina1().getX(), b.getEsquina1().getX());
        double y1 = Math.max(a.getEsquina1().getY(), b.getEsquina1().getY());
        double x2 = Math.min(a.getEsquina2().getX(), b.getEsquina2().getX());
        double y2 = Math.min(a.getEsquina2().getY(), b.getEsquina2().getY());

        if (x1 < x2 && y1 < y2) {
            return new Rectangulo(new Coordenada(x1, y1), new Coordenada(x2, y2));
        } else {
            return null;
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Convertir Graphics a Graphics2D para mayor control
        Graphics2D g2d = (Graphics2D) g;

        // Definir el factor de escala para agrandar el dibujo
        double factorEscala = 100.0;

        // Escalar las coordenadas de los rectángulos
        int x1 = (int) (rect1.getEsquina1().getX() * factorEscala);
        int y1 = (int) (rect1.getEsquina1().getY() * factorEscala);
        int x2 = (int) (rect1.getEsquina2().getX() * factorEscala);
        int y2 = (int) (rect1.getEsquina2().getY() * factorEscala);

        // Establecer color y dibujar el primer rectángulo
        g2d.setColor(Color.BLUE);
        g2d.fillRect(x1, y1, x2 - x1, y2 - y1);

        // Escalar las coordenadas del segundo rectángulo
        x1 = (int) (rect2.getEsquina1().getX() * factorEscala);
        y1 = (int) (rect2.getEsquina1().getY() * factorEscala);
        x2 = (int) (rect2.getEsquina2().getX() * factorEscala);
        y2 = (int) (rect2.getEsquina2().getY() * factorEscala);

        // Establecer color y dibujar el segundo rectángulo
        g2d.setColor(Color.RED);
        g2d.fillRect(x1, y1, x2 - x1, y2 - y1);

        // Si hay intersección, escalar las coordenadas y dibujarla con otro color
        if (interseccion != null) {
            x1 = (int) (interseccion.getEsquina1().getX() * factorEscala);
            y1 = (int) (interseccion.getEsquina1().getY() * factorEscala);
            x2 = (int) (interseccion.getEsquina2().getX() * factorEscala);
            y2 = (int) (interseccion.getEsquina2().getY() * factorEscala);

            g2d.setColor(new Color(0, 255, 0, 128)); // Verde semitransparente
            g2d.fillRect(x1, y1, x2 - x1, y2 - y1);
        }
    }

}


>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>


// Clase que representa un rectángulo definido por dos coordenadas
class Rectangulo {
    private Coordenada esquina1;
    private Coordenada esquina2;

    public Rectangulo(Coordenada c1, Coordenada c2) {
        ordenarEsquinas(c1, c2);
    }

    // Método que ordena las esquinas para asegurar que siempre la esquina inferior
    // izquierda
    // sea esquina1 y la superior derecha sea esquina2
    private void ordenarEsquinas(Coordenada c1, Coordenada c2) {
        double xMenor = Math.min(c1.getX(), c2.getX());
        double yMenor = Math.min(c1.getY(), c2.getY());
        double xMayor = Math.max(c1.getX(), c2.getX());
        double yMayor = Math.max(c1.getY(), c2.getY());
        this.esquina1 = new Coordenada(xMenor, yMenor);
        this.esquina2 = new Coordenada(xMayor, yMayor);
    }

    public Coordenada getEsquina1() {
        return esquina1;
    }

    public Coordenada getEsquina2() {
        return esquina2;
    }

    public double calcularArea() {
        return (esquina2.getX() - esquina1.getX()) * (esquina2.getY() - esquina1.getY());
    }

    @Override
    public String toString() {
        return "Rectángulo = (" + esquina1 + ", " + esquina2 + ")";
    }
}


>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>


// Clase que verifica la relación entre dos rectángulos
class Verificador {
    public static boolean SobrePuestos(Rectangulo a, Rectangulo b) {
        // Caso 1: Los rectángulos se sobreponen si comparten un área en común

        if ((a.getEsquina1().getX() < b.getEsquina2().getX() && a.getEsquina2().getX() > b.getEsquina1().getX()) &&
                (a.getEsquina1().getY() < b.getEsquina2().getY() && a.getEsquina2().getY() > b.getEsquina1().getY())) {
            return true;
        }
        return false;
    }

    public static boolean esJuntos(Rectangulo a, Rectangulo b) {

        // Caso 2: Los rectángulos están juntos si comparten un lado en común sin
        // superponerse
        if (((a.getEsquina1().getX() <= b.getEsquina2().getX() && a.getEsquina2().getX() >= b.getEsquina1().getX()) &&
                (a.getEsquina1().getY() <= b.getEsquina2().getY() && a.getEsquina2().getY() >= b.getEsquina1().getY()))

                && ((a.getEsquina2().getX() == b.getEsquina1().getX()
                        || a.getEsquina1().getX() == b.getEsquina2().getX())
                        || (a.getEsquina2().getY() == b.getEsquina1().getY()
                                || a.getEsquina1().getY() == b.getEsquina2().getY()))) {
            return true;
        }
        return false;
    }

    public static boolean Disjuntos(Rectangulo a, Rectangulo b) {
        // Caso 3: Los rectángulos son disjuntos si no tienen contacto ni se sobreponen
        if (esJuntos(a, b) || SobrePuestos(a, b)) {
            return false;
        }
        return true;
    }
}



>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

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
