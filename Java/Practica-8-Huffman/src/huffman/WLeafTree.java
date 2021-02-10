package huffman;

/**
 * Weighted binary trees with information in the leaves.<br>
 *
 * Data Structures, Grado en Informática. UMA.<br>
 *
 * @author Pablo López
 * @version January, 2021
 */

public class WLeafTree<T> implements Comparable<WLeafTree<T>> {

    private final T elem;
    private final int weight;
    private final WLeafTree<T> left, right;

    public WLeafTree(T i, int w) {
        elem = i;
        weight = w;
        left = null;
        right = null;
    }

    public WLeafTree(WLeafTree<T> l, WLeafTree<T> r) {
        elem = null;
        weight = l.weight + r.weight;
        left = l;
        right = r;
    }

    public boolean isLeaf() {
        return left == null && right == null;
    }

    public int weight() {
        return weight;
    }

    public T elem() {
        return elem;
    }

    public WLeafTree<T> leftChild() {
        return left;
    }

    public WLeafTree<T> rightChild() {
        return right;
    }

    @Override
    public int compareTo(WLeafTree<T> that) {
        return Integer.compare(this.weight, that.weight);
    }

    @Override
    public String toString() {
        return prettyPrint("");
    }

    private String prettyPrint(String margin) {
        if (isLeaf()) {
            return String.format("%s(%s, %s)", margin, elem, weight);
        }
        return String.format("%s\n%s%s\n%s\n", right.prettyPrint(margin + "    "), margin, weight,
                left.prettyPrint(margin + "    "));
    }
}