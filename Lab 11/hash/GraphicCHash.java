package hash;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Interfaz gráfica simple para visualizar y manipular una tabla hash con sondeo lineal (HashC)
 */
public class GraphicCHash extends JFrame {
    private HashC<String> hashTable;
    private final int TABLE_SIZE = 10;
    
    // Componentes de la interfaz
    private JPanel panelFormulario;
    private JPanel panelVisualizacion;
    private JTextField txtClave;
    private JTextField txtValor;
    private JTextField txtClaveOperacion;
    private JTextArea txtAreaResultado;
    private JButton btnInsertar;
    private JButton btnBuscar;
    private JButton btnEliminar;
    private JButton btnMostrar;
    
    // Componentes para visualización
    private JPanel[] celdas;
    private JLabel[] labels;
    
    public GraphicCHash() {
        // Inicializar la tabla hash
        hashTable = new HashC<>(TABLE_SIZE);
        
        // Configurar la ventana principal
        setTitle("Tabla Hash con Sondeo Lineal");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        // Crear paneles
        crearPanelFormulario();
        crearPanelVisualizacion();
        
        // Añadir paneles al frame
        add(panelFormulario, BorderLayout.WEST);
        add(panelVisualizacion, BorderLayout.CENTER);
        
        // Mostrar ventana
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    /**
     * Crea el panel con los formularios para operaciones CRUD
     */
    private void crearPanelFormulario() {
        panelFormulario = new JPanel();
        panelFormulario.setLayout(new BoxLayout(panelFormulario, BoxLayout.Y_AXIS));
        panelFormulario.setBorder(BorderFactory.createTitledBorder("Operaciones"));
        panelFormulario.setPreferredSize(new Dimension(300, 500));
        
        // Panel para insertar
        JPanel panelInsertar = new JPanel(new GridLayout(3, 2, 5, 5));
        panelInsertar.setBorder(BorderFactory.createTitledBorder("Insertar"));
        
        panelInsertar.add(new JLabel("Clave:"));
        txtClave = new JTextField();
        panelInsertar.add(txtClave);
        
        panelInsertar.add(new JLabel("Valor:"));
        txtValor = new JTextField();
        panelInsertar.add(txtValor);
        
        btnInsertar = new JButton("Insertar");
        btnInsertar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                insertarRegistro();
            }
        });
        panelInsertar.add(new JLabel(""));
        panelInsertar.add(btnInsertar);
        
        // Panel para otras operaciones
        JPanel panelOperaciones = new JPanel(new GridLayout(3, 2, 5, 5));
        panelOperaciones.setBorder(BorderFactory.createTitledBorder("Buscar/Eliminar"));
        
        panelOperaciones.add(new JLabel("Clave:"));
        txtClaveOperacion = new JTextField();
        panelOperaciones.add(txtClaveOperacion);
        
        btnBuscar = new JButton("Buscar");
        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarRegistro();
            }
        });
        panelOperaciones.add(btnBuscar);
        
        btnEliminar = new JButton("Eliminar");
        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminarRegistro();
            }
        });
        panelOperaciones.add(btnEliminar);
        
        btnMostrar = new JButton("Mostrar Todo");
        btnMostrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarTodo();
            }
        });
        panelOperaciones.add(btnMostrar);
        
        // Panel para resultados
        JPanel panelResultado = new JPanel(new BorderLayout());
        panelResultado.setBorder(BorderFactory.createTitledBorder("Resultado"));
        
        txtAreaResultado = new JTextArea(10, 20);
        txtAreaResultado.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(txtAreaResultado);
        panelResultado.add(scrollPane, BorderLayout.CENTER);
        
        // Añadir todos los paneles al formulario
        panelFormulario.add(panelInsertar);
        panelFormulario.add(Box.createRigidArea(new Dimension(0, 10)));
        panelFormulario.add(panelOperaciones);
        panelFormulario.add(Box.createRigidArea(new Dimension(0, 10)));
        panelFormulario.add(panelResultado);
    }
    
    /**
     * Crea el panel de visualización de la tabla hash
     */
    private void crearPanelVisualizacion() {
        panelVisualizacion = new JPanel();
        panelVisualizacion.setLayout(new GridLayout(TABLE_SIZE, 1, 5, 5));
        panelVisualizacion.setBorder(BorderFactory.createTitledBorder("Visualización de la Tabla Hash"));
        
        celdas = new JPanel[TABLE_SIZE];
        labels = new JLabel[TABLE_SIZE];
        
        for (int i = 0; i < TABLE_SIZE; i++) {
            celdas[i] = new JPanel(new BorderLayout());
            celdas[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
            
            JLabel indexLabel = new JLabel("Índice " + i);
            indexLabel.setHorizontalAlignment(JLabel.CENTER);
            indexLabel.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
            
            labels[i] = new JLabel("Vacío", JLabel.CENTER);
            labels[i].setForeground(Color.GRAY);
            
            celdas[i].add(indexLabel, BorderLayout.NORTH);
            celdas[i].add(labels[i], BorderLayout.CENTER);
            
            panelVisualizacion.add(celdas[i]);
        }
    }
    
    /**
     * Método para insertar un registro en la tabla hash
     */
    private void insertarRegistro() {
        try {
            int clave = Integer.parseInt(txtClave.getText().trim());
            String valor = txtValor.getText().trim();
            
            if (valor.isEmpty()) {
                mostrarMensaje("Error: El valor no puede estar vacío");
                return;
            }
            
            Register<String> registro = new Register<>(clave, valor);
            
            try {
                hashTable.insert(registro);
                mostrarMensaje("Registro insertado con éxito: " + registro.toString());
                actualizarVisualizacion();
                
                // Limpiar campos
                txtClave.setText("");
                txtValor.setText("");
                
            } catch (ExceptionIsFull e) {
                mostrarMensaje("Error: " + e.getMessage());
            }
            
        } catch (NumberFormatException e) {
            mostrarMensaje("Error: La clave debe ser un número entero");
        }
    }
    
    /**
     * Método para buscar un registro en la tabla hash
     */
    private void buscarRegistro() {
        try {
            int clave = Integer.parseInt(txtClaveOperacion.getText().trim());
            
            Register<String> resultado = hashTable.search(clave);
            
            if (resultado != null) {
                mostrarMensaje("Registro encontrado: " + resultado.toString());
                resaltarCelda(findPositionInTable(clave));
            } else {
                mostrarMensaje("No se encontró ningún registro con clave " + clave);
            }
            
        } catch (NumberFormatException e) {
            mostrarMensaje("Error: La clave debe ser un número entero");
        }
    }
    
    /**
     * Método para eliminar un registro de la tabla hash
     */
    private void eliminarRegistro() {
        try {
            int clave = Integer.parseInt(txtClaveOperacion.getText().trim());
            
            // Primero verificamos si existe
            Register<String> existente = hashTable.search(clave);
            
            if (existente != null) {
                hashTable.delete(clave);
                mostrarMensaje("Registro eliminado con éxito");
                actualizarVisualizacion();
                txtClaveOperacion.setText("");
            } else {
                mostrarMensaje("No se encontró ningún registro con clave " + clave);
            }
            
        } catch (NumberFormatException e) {
            mostrarMensaje("Error: La clave debe ser un número entero");
        }
    }
    
    /**
     * Método para mostrar todos los registros
     */
    private void mostrarTodo() {
        StringBuilder sb = new StringBuilder("Contenido de la tabla:\n");
        boolean hayDatos = false;
        
        for (int i = 0; i < TABLE_SIZE; i++) {
            Register<String> reg = hashTable.getRegisterAt(i);
            if (reg != null) {
                sb.append("[").append(i).append("]: ").append(reg.toString()).append("\n");
                hayDatos = true;
            }
        }
        
        if (!hayDatos) {
            sb.append("La tabla está vacía");
        }
        
        mostrarMensaje(sb.toString());
        actualizarVisualizacion();
    }
    
    /**
     * Actualiza la visualización de la tabla hash
     */
    private void actualizarVisualizacion() {
        for (int i = 0; i < TABLE_SIZE; i++) {
            Register<String> reg = hashTable.getRegisterAt(i);
            
            if (reg != null) {
                labels[i].setText("Clave: " + reg.getKey() + ", Valor: " + reg.getValue());
                labels[i].setForeground(Color.BLACK);
                celdas[i].setBackground(new Color(230, 255, 230)); // Verde claro
            } else {
                // Verificamos si está marcada como eliminada
                // Esto no es directo en HashC, es una suposición
                labels[i].setText("Vacío");
                labels[i].setForeground(Color.GRAY);
                celdas[i].setBackground(Color.WHITE);
            }
        }
    }
    
    /**
     * Encuentra la posición de una clave en la tabla
     */
    private int findPositionInTable(int key) {
        int pos = key % TABLE_SIZE; // Función hash básica
        
        // Esto es una implementación simplificada
        for (int i = 0; i < TABLE_SIZE; i++) {
            int checkPos = (pos + i) % TABLE_SIZE;
            Register<String> reg = hashTable.getRegisterAt(checkPos);
            if (reg != null && reg.getKey() == key) {
                return checkPos;
            }
        }
        
        return -1;
    }
    
    /**
     * Resalta temporalmente una celda específica
     */
    private void resaltarCelda(int pos) {
        if (pos < 0 || pos >= TABLE_SIZE) return;
        
        final Color originalColor = celdas[pos].getBackground();
        celdas[pos].setBackground(Color.YELLOW);
        
        // Timer para restaurar el color original después de un tiempo
        Timer timer = new Timer(1500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                celdas[pos].setBackground(originalColor);
            }
        });
        
        timer.setRepeats(false);
        timer.start();
    }
    
    /**
     * Muestra un mensaje en el área de resultados
     */
    private void mostrarMensaje(String mensaje) {
        txtAreaResultado.setText(mensaje);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GraphicCHash();
            }
        });
    }
}