package Actividad_2;

import exceptions.ItemDuplicated;

public class TestAVL {
    public static void main(String[] args) {
        try {
            AVLTree<Integer> avl = new AVLTree<>();

            System.out.println("===== CASOS DE PRUEBA PARA AVLTree =====");

            // --------------------------------------------
            // Caso 1: Rotación Simple Derecha (RSR - LL)
            // Inserción: 30 -> 20 -> 10
            // --------------------------------------------
            System.out.println("\n** Caso 1: RSR (LL) **");
            avl.insert(30);
            avl.insert(20);
            avl.insert(10);  // Desbalance en 30 (bf=-2)
            System.out.println("Árbol: " + avl.toString());
            // Esperado: 20(bf:0) 10(bf:0) 30(bf:0)

            // --------------------------------------------
            // Caso 2: Rotación Simple Izquierda (RSL - RR)
            // Inserción: 10 -> 20 -> 30
            // --------------------------------------------
            System.out.println("\n** Caso 2: RSL (RR) **");
            avl.destroy();
            avl.insert(10);
            avl.insert(20);
            avl.insert(30);  // Desbalance en 10 (bf=2)
            System.out.println("Árbol: " + avl.toString());
            // Esperado: 20(bf:0) 10(bf:0) 30(bf:0)

            // --------------------------------------------
            // Caso 3: Rotación Doble Derecha (RDR - LR)
            // Inserción: 30 -> 10 -> 20
            // --------------------------------------------
            System.out.println("\n** Caso 3: RDR (LR) **");
            avl.destroy();
            avl.insert(30);
            avl.insert(10);
            avl.insert(20);  // Desbalance en 30 (bf=-2)
            System.out.println("Árbol: " + avl.toString());
            // Esperado: 20(bf:0) 10(bf:0) 30(bf:0)

            // --------------------------------------------
            // Caso 4: Rotación Doble Izquierda (RDL - RL)
            // Inserción: 10 -> 30 -> 20
            // --------------------------------------------
            System.out.println("\n** Caso 4: RDL (RL) **");
            avl.destroy();
            avl.insert(10);
            avl.insert(30);
            avl.insert(20);  // Desbalance en 10 (bf=2)
            System.out.println("Árbol: " + avl.toString());
            // Esperado: 20(bf:0) 10(bf:0) 30(bf:0)

            // --------------------------------------------
            // Caso 5: Rotaciones Múltiples (RSR + RSL)
            // Inserción: 50 -> 30 -> 70 -> 20 -> 40 -> 10
            // --------------------------------------------
            System.out.println("\n** Caso 5: RSR + RSL **");
            avl.destroy();
            avl.insert(50);
            avl.insert(30);
            avl.insert(70);
            avl.insert(20);
            avl.insert(40);
            avl.insert(10);  // RSR en 30 y luego en 50
            System.out.println("Árbol: " + avl.toString());
            // Esperado: 30(bf:0) 20(bf:-1) 10(bf:0) 50(bf:1) 40(bf:0) 70(bf:0)

            // --------------------------------------------
            // Caso 6: Rotaciones Múltiples (RDL + RDR)
            // Inserción: 50 -> 30 -> 70 -> 60 -> 80 -> 90
            // --------------------------------------------
            System.out.println("\n** Caso 6: RDL + RDR **");
            avl.destroy();
            avl.insert(50);
            avl.insert(30);
            avl.insert(70);
            avl.insert(60);
            avl.insert(80);
            avl.insert(90);  // RSL en 70, luego RDL en 50
            System.out.println("Árbol: " + avl.toString());
            // Esperado: 70(bf:0) 50(bf:0) 30(bf:0) 60(bf:0) 80(bf:1) 90(bf:0)

            // --------------------------------------------
            // Caso 7: Inserción Sin Rotaciones
            // Inserción: 50 -> 30 -> 70 -> 20 -> 40 -> 60 -> 80
            // --------------------------------------------
            System.out.println("\n** Caso 7: Sin Rotaciones **");
            avl.destroy();
            avl.insert(50);
            avl.insert(30);
            avl.insert(70);
            avl.insert(20);
            avl.insert(40);
            avl.insert(60);
            avl.insert(80);  // Árbol perfectamente balanceado
            System.out.println("Árbol: " + avl.toString());
            // Esperado: 50(bf:0) 30(bf:0) 20(bf:0) 40(bf:0) 70(bf:0) 60(bf:0) 80(bf:0)

            // --------------------------------------------
            // Caso 8: Caso Extremo (Múltiples Rotaciones)
            // Inserción: 40 -> 20 -> 60 -> 10 -> 30 -> 50 -> 70 -> 5 -> 15 -> 25 -> 35
            // --------------------------------------------
            System.out.println("\n** Caso 8: Extremo (RDR + RDL + RSR + RSL) **");
            avl.destroy();
            avl.insert(40);
            avl.insert(20);
            avl.insert(60);
            avl.insert(10);
            avl.insert(30);
            avl.insert(50);
            avl.insert(70);
            avl.insert(5);
            avl.insert(15);
            avl.insert(25);
            avl.insert(35);  // Rotaciones múltiples
            System.out.println("Árbol: " + avl.toString());
            // Esperado: 20(bf:0) 10(bf:-1) 5(bf:0) 15(bf:0) 40(bf:0) 30(bf:0) 25(bf:0) 35(bf:0) 60(bf:1) 50(bf:0) 70(bf:0)

        } catch (ItemDuplicated e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
