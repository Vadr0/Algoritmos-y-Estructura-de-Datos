package Actividad02;

import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {
        // Crear el marco de la ventana
        JFrame frame = new JFrame("Árbol de Pitágoras");

        // nueva ventana con el árbol de Pitágoras de 6 niveles
        PythagorasTree arbol6 = new PythagorasTree(6);
        
        // Agregar el panel al marco para el árbol de 6 niveles
        frame.add(arbol6);
        frame.setTitle("Árbol de Pitágoras - 6 Niveles");
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        
        // Pausa de 3 segundos
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        // nueva ventana para el árbol de 8 niveles
        JFrame frame8 = new JFrame("Árbol de Pitágoras - 8 Niveles");
        PythagorasTree arbol8 = new PythagorasTree(8);
        frame8.add(arbol8);
        frame8.pack();
        frame8.setLocationRelativeTo(null);
        frame8.setVisible(true);

        // Pausa de 3 segundos
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // nueva ventana para el árbol de 10 niveles
        JFrame frame10 = new JFrame("Árbol de Pitágoras - 10 Niveles");
        PythagorasTree arbol10 = new PythagorasTree(10);
        frame10.add(arbol10);
        frame10.pack();
        frame10.setLocationRelativeTo(null);
        frame10.setVisible(true);
    }
}
