package btree;

public class BTree<E extends Comparable<E>> {
    private BNode<E> root;
    private int orden;
    private boolean up;
    private BNode<E> nDes;

    public BTree(int orden) {
        this.orden = orden;
        this.root = null;
    }

    public boolean isEmpty() {
        return this.root == null;
    }

    public void insert(E cl) {
        up = false;
        E mediana;
        BNode<E> pnew;
        mediana = push(this.root, cl);
        if (up) {
            pnew = new BNode<E>(this.orden);
            pnew.count = 1;
            pnew.keys.set(0, mediana);
            pnew.childs.set(0, this.root);
            pnew.childs.set(1, nDes);
            if (this.root != null) this.root.parent = pnew;
            if (nDes != null) nDes.parent = pnew;
            this.root = pnew;
            pnew.parent = null;
        }
    }

    private E push(BNode<E> current, E cl) {
        int[] pos = new int[1];
        E mediana;
        if (current == null) {
            up = true;
            nDes = null;
            return cl;
        } else {
            boolean fl = searchNodeWithPos(current, cl, pos);
            if (fl) {
                System.out.println("Item duplicado\n");
                up = false;
                return null;
            }
            mediana = push(current.childs.get(pos[0]), cl);
            if (up) {
                if (current.nodeFull()) {
                    mediana = dividedNode(current, mediana, pos[0]);
                } else {
                    putNode(current, mediana, nDes, pos[0]);
                    up = false;
                }
            }
            return mediana;
        }
    }

    private void putNode(BNode<E> current, E cl, BNode<E> rd, int k) {
        int i;
        for (i = current.count - 1; i >= k; i--) {
            current.keys.set(i + 1, current.keys.get(i));
            current.childs.set(i + 2, current.childs.get(i + 1));
        }
        current.keys.set(k, cl);
        current.childs.set(k + 1, rd);
        if (rd != null) rd.parent = current; // Actualizar padre
        current.count++;
    }

    private E dividedNode(BNode<E> current, E cl, int k) {
        BNode<E> rd = nDes;
        int i, posMdna;
        posMdna = (k <= this.orden / 2) ? this.orden / 2 : this.orden / 2 + 1;
        nDes = new BNode<E>(this.orden);
        nDes.parent = current.parent; // Nuevo nodo, mismo padre
        for (i = posMdna; i < this.orden - 1; i++) {
            nDes.keys.set(i - posMdna, current.keys.get(i));
            nDes.childs.set(i - posMdna + 1, current.childs.get(i + 1));
            if (current.childs.get(i + 1) != null) current.childs.get(i + 1).parent = nDes;
        }
        nDes.count = (this.orden - 1) - posMdna;
        current.count = posMdna;
        if (k <= this.orden / 2)
            putNode(current, cl, rd, k);
        else
            putNode(nDes, cl, rd, k - posMdna);
        E median = current.keys.get(current.count - 1);
        nDes.childs.set(0, current.childs.get(current.count));
        if (current.childs.get(current.count) != null) current.childs.get(current.count).parent = nDes;
        current.count--;
        return median;
    }

    // Busca la posición donde debe ir 'cl' en el nodo 'current'.
    // Devuelve true si lo encuentra, false si no, y actualiza pos[0] con la posición.
    private boolean searchNodeWithPos(BNode<E> current, E cl, int[] pos) {
        int i = 0;
        while (i < current.count && cl.compareTo(current.keys.get(i)) > 0) {
            i++;
        }
        pos[0] = i;
        if (i < current.count && cl.compareTo(current.keys.get(i)) == 0) {
            return true; // Duplicado
        }
        return false;
    }

    //ejercicio 1
    public boolean search(E cl) {
        return searchRecursive(this.root, cl);
    }

    private boolean searchRecursive(BNode<E> current, E cl) {
        if (current == null) return false;
        int i = 0;
        while (i < current.count && cl.compareTo(current.keys.get(i)) > 0) {
            i++;
        }
        if (i < current.count && cl.compareTo(current.keys.get(i)) == 0) {
            System.out.println(cl + " se encuentra en el nodo " + current.getIdNode() + " en la posición " + i);
            return true;
        } else if (current.childs.get(i) != null) {
            return searchRecursive(current.childs.get(i), cl);
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        String s = "";
        if (isEmpty())
            s += "BTree is empty...";
        else
            s = writeTree(this.root);
        return s;
    }


    private String writeTree(BNode<E> current) {
        if (current == null) return "";
        StringBuilder sb = new StringBuilder();
        // IdNodo
        sb.append("Id.Nodo: ").append(current.getIdNode()).append("\t");
        // Claves Nodo
        sb.append("Claves Nodo: (");
        for (int i = 0; i < current.count; i++) {
            sb.append(current.keys.get(i));
            if (i < current.count - 1) sb.append(", ");
        }
        sb.append(")\t");
        // Id.Padre
        if (current.parent != null) {
            sb.append("Id.Padre: ").append(current.parent.getIdNode()).append("\t");
        } else {
            sb.append("Id.Padre: --\t");
        }

        sb.append("Id.Hijos: [");
        boolean hasChild = false;
        for (int i = 0; i <= current.count; i++) {
            BNode<E> child = current.childs.get(i);
            if (child != null && !child.nodeEmpty()) {
                if (hasChild) sb.append(", ");
                sb.append(child.getIdNode());
                hasChild = true;
            }
        }
        sb.append("]\n");
        // Recursivo para hijos
        for (int i = 0; i <= current.count; i++) {
            BNode<E> child = current.childs.get(i);
            if (child != null && !child.nodeEmpty()) {
                sb.append(writeTree(child));
            }
        }
        return sb.toString();
    }

    //ejercicio2
    public void remove(E cl) {
        removeRecursive(this.root, cl);
        // Si la raíz queda vacía y tiene hijos, la nueva raíz será su primer hijo
        if (root != null && root.count == 0) {
            if (root.childs.get(0) != null) {
                root = root.childs.get(0);
            } else {
                root = null;
            }
        }
    }

    private void removeRecursive(BNode<E> node, E cl) {
        if (node == null) return;
        int pos = 0;
        while (pos < node.count && cl.compareTo(node.keys.get(pos)) > 0) pos++;
        if (pos < node.count && cl.compareTo(node.keys.get(pos)) == 0) {
            // Caso 1: clave encontrada en nodo interno o hoja
            if (node.childs.get(pos) == null) {
                // Es hoja: eliminar directamente
                for (int i = pos; i < node.count - 1; i++) {
                    node.keys.set(i, node.keys.get(i + 1));
                }
                node.keys.set(node.count - 1, null);
                node.count--;
            } else {
                // Es interno: buscar predecesor o sucesor para reemplazar
                BNode<E> pred = node.childs.get(pos);
                while (pred.childs.get(pred.count) != null) pred = pred.childs.get(pred.count);
                E predKey = pred.keys.get(pred.count - 1);
                node.keys.set(pos, predKey);
                removeRecursive(node.childs.get(pos), predKey);
            }
        } else {
            // Caso 2: clave no está en este nodo
            if (node.childs.get(pos) == null) return; // No existe
            removeRecursive(node.childs.get(pos), cl);
            // Verificar si el hijo quedó con menos del mínimo
            int min = (orden - 1) / 2;
            BNode<E> child = node.childs.get(pos);
            if (child.count < min) {
                // Intentar redistribuir con hermano izquierdo
                if (pos > 0 && node.childs.get(pos - 1) != null && node.childs.get(pos - 1).count > min) {
                    borrowFromLeft(node, pos);
                }
                // Intentar redistribuir con hermano derecho
                else if (pos < node.count && node.childs.get(pos + 1) != null && node.childs.get(pos + 1).count > min) {
                    borrowFromRight(node, pos);
                }
                // Si no se puede redistribuir, fusionar
                else {
                    if (pos > 0) {
                        merge(node, pos - 1);
                    } else {
                        merge(node, pos);
                    }
                }
            }
        }
    }

    // Redistribuir: tomar una clave del hermano izquierdo
    private void borrowFromLeft(BNode<E> parent, int idx) {
        BNode<E> child = parent.childs.get(idx);
        BNode<E> left = parent.childs.get(idx - 1);
        // Mover claves y hijos en child a la derecha
        for (int i = child.count; i > 0; i--) {
            child.keys.set(i, child.keys.get(i - 1));
            child.childs.set(i + 1, child.childs.get(i));
        }
        child.childs.set(1, child.childs.get(0));
        // Traer clave del padre
        child.keys.set(0, parent.keys.get(idx - 1));
        child.childs.set(0, left.childs.get(left.count));
        child.count++;
        // Subir clave del hermano izquierdo al padre
        parent.keys.set(idx - 1, left.keys.get(left.count - 1));
        left.keys.set(left.count - 1, null);
        left.childs.set(left.count, null);
        left.count--;
    }

    // Redistribuir: tomar una clave del hermano derecho
    private void borrowFromRight(BNode<E> parent, int idx) {
        BNode<E> child = parent.childs.get(idx);
        BNode<E> right = parent.childs.get(idx + 1);
        // Traer clave del padre
        child.keys.set(child.count, parent.keys.get(idx));
        child.childs.set(child.count + 1, right.childs.get(0));
        child.count++;
        // Subir clave del hermano derecho al padre
        parent.keys.set(idx, right.keys.get(0));
        for (int i = 0; i < right.count - 1; i++) {
            right.keys.set(i, right.keys.get(i + 1));
            right.childs.set(i, right.childs.get(i + 1));
        }
        right.childs.set(right.count - 1, right.childs.get(right.count));
        right.keys.set(right.count - 1, null);
        right.childs.set(right.count, null);
        right.count--;
    }

    // Fusionar child[idx] y child[idx+1] en child[idx]
    private void merge(BNode<E> parent, int idx) {
        BNode<E> left = parent.childs.get(idx);
        BNode<E> right = parent.childs.get(idx + 1);
        // Traer clave del padre
        left.keys.set(left.count, parent.keys.get(idx));
        left.count++;
        // Copiar claves y hijos del derecho
        for (int i = 0; i < right.count; i++) {
            left.keys.set(left.count, right.keys.get(i));
            left.childs.set(left.count, right.childs.get(i));
            if (right.childs.get(i) != null) right.childs.get(i).parent = left;
            left.count++;
        }
        left.childs.set(left.count, right.childs.get(right.count));
        if (right.childs.get(right.count) != null) right.childs.get(right.count).parent = left;
        // Mover claves e hijos en el padre
        for (int i = idx; i < parent.count - 1; i++) {
            parent.keys.set(i, parent.keys.get(i + 1));
            parent.childs.set(i + 1, parent.childs.get(i + 2));
        }
        parent.keys.set(parent.count - 1, null);
        parent.childs.set(parent.count, null);
        parent.count--;
    }

    // ejercicio 3
    public static <E extends Comparable<E>> BTree<E> building_Btree(String filename, java.util.function.Function<String, E> parseKey) throws Exception {
        java.util.List<String> lines = java.nio.file.Files.readAllLines(java.nio.file.Paths.get(filename));
        if (lines.isEmpty()) throw new Exception("Archivo vacío");
        int orden = Integer.parseInt(lines.get(0).trim());
        BTree<E> tree = new BTree<>(orden);
        java.util.Map<Integer, BNode<E>> idToNode = new java.util.HashMap<>();
        java.util.Map<Integer, Integer> idToLevel = new java.util.HashMap<>();
        java.util.Map<Integer, java.util.List<Integer>> levelToIds = new java.util.HashMap<>();
        // Crear nodos y asignar claves
        for (int i = 1; i < lines.size(); i++) {
            String[] parts = lines.get(i).split(",");
            int nivel = Integer.parseInt(parts[0].trim());
            int idNodo = Integer.parseInt(parts[1].trim());
            BNode<E> node = new BNode<>(orden);
            node.parent = null;
            node.count = parts.length - 2;
            for (int j = 2; j < parts.length; j++) {
                node.keys.set(j - 2, parseKey.apply(parts[j].trim()));
            }
            idToNode.put(idNodo, node);
            idToLevel.put(idNodo, nivel);
            levelToIds.computeIfAbsent(nivel, k -> new java.util.ArrayList<>()).add(idNodo);
        }
        // Asignar hijos y padres
        for (int nivel = 0; levelToIds.containsKey(nivel); nivel++) {
            for (int idPadre : levelToIds.get(nivel)) {
                BNode<E> padre = idToNode.get(idPadre);
                int hijoIdx = 0;
                for (int nivelHijo = nivel + 1; levelToIds.containsKey(nivelHijo); nivelHijo++) {
                    for (int idHijo : levelToIds.get(nivelHijo)) {
                        BNode<E> hijo = idToNode.get(idHijo);
                        if (hijo.parent == null) {
                            E min = hijo.keys.get(0);
                            E max = hijo.keys.get(hijo.count - 1);
                            E left = (hijoIdx == 0) ? null : padre.keys.get(hijoIdx - 1);
                            E right = (hijoIdx < padre.count) ? padre.keys.get(hijoIdx) : null;
                            boolean inRange = (left == null || min.compareTo(left) > 0) && (right == null || max.compareTo(right) < 0);
                            // Solo asignar si hay espacio para más hijos
                            if (inRange && hijoIdx < padre.childs.size() && hijoIdx <= padre.count) {
                                padre.childs.set(hijoIdx, hijo);
                                hijo.parent = padre;
                                hijoIdx++;
                            }
                        }
                    }
                }
            }
        }
        // Buscar raíz (nivel 0)
        BNode<E> root = null;
        if (levelToIds.containsKey(0) && !levelToIds.get(0).isEmpty()) {
            root = idToNode.get(levelToIds.get(0).get(0));
        }
        tree.root = root;
        // Verificar propiedades de BTree
        if (!tree.verifyBTreeProperties()) {
            throw new Exception("ItemNoFound: El árbol no cumple las propiedades de BTree");
        }
        return tree;
    }

    // ejercicio 3
    private boolean verifyBTreeProperties() {
        if (root == null) return true;
        int min = (orden - 1) / 2;
        java.util.Queue<BNode<E>> queue = new java.util.LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            BNode<E> node = queue.poll();
            // Raíz puede tener menos claves
            if (node != root && node.count < min) return false;
            if (node.count > orden - 1) return false;
            for (int i = 0; i <= node.count; i++) {
                BNode<E> child = node.childs.get(i);
                if (child != null) {
                    if (child.parent != node) return false;
                    queue.add(child);
                }
            }
        }
        return true;
    }

    // Buscar nombre de estudiante por código
    public String buscarNombre(int codigo) {
        return buscarNombreRecursivo(root, codigo);
    }

    private String buscarNombreRecursivo(BNode<E> current, int codigo) {
        if (current == null) return "No encontrado";
        for (int i = 0; i < current.count; i++) {
            E key = current.keys.get(i);
            if (key instanceof RegistroEstudiante) {
                RegistroEstudiante reg = (RegistroEstudiante) key;
                if (reg.getCodigo() == codigo) {
                    return reg.getNombre();
                } else if (codigo < reg.getCodigo()) {
                    return buscarNombreRecursivo(current.childs.get(i), codigo);
                }
            }
        }
        return buscarNombreRecursivo(current.childs.get(current.count), codigo);
    }
}