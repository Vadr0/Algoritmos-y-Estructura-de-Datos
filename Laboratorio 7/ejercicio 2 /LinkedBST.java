import bstreeInterface.BinarySearchTree;
import exceptions.ExceptionIsEmpty;
import exceptions.ItemDuplicated;
import exceptions.ItemNotFound;

import java.util.LinkedList;
import java.util.Queue;

public class LinkedBST<E extends Comparable<E>> implements BinarySearchTree<E> {
    // ... (código existente se mantiene igual)

    // a. Método areaBST() - iterativo
    public int areaBST() {
        if (isEmpty()) return 0;
        
        int height = heightIterative(root);
        int leafCount = countLeavesIterative();
        
        return height * leafCount;
    }

    private int countLeavesIterative() {
        if (isEmpty()) return 0;
        
        Queue<Node<E>> queue = new LinkedList<>();
        queue.add(root);
        int leafCount = 0;
        
        while (!queue.isEmpty()) {
            Node<E> current = queue.poll();
            
            if (current.left == null && current.right == null) {
                leafCount++;
            } else {
                if (current.left != null) queue.add(current.left);
                if (current.right != null) queue.add(current.right);
            }
        }
        return leafCount;
    }

    // b. Método drawBST()
    public String drawBST() {
        StringBuilder sb = new StringBuilder();
        if (!isEmpty()) {
            drawBST(root, 0, sb);
        }
        return sb.toString();
    }

    private void drawBST(Node<E> node, int level, StringBuilder sb) {
        if (node != null) {
            drawBST(node.right, level + 1, sb);
            
            for (int i = 0; i < level; i++) {
                sb.append("     ");
            }
            sb.append(node.data).append("\n");
            
            drawBST(node.left, level + 1, sb);
        }
    }

    // ... (el resto del código existente se mantiene igual)
}
