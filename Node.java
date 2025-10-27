public class Node {
    private char key;
    private Node left;
    private Node right;

    public Node(char key) {
        this.key = key;
        this.left = null;
        this.right = null;
    }

    public void setRight(Node right) {
        this.right = right;
    }
    public void setLeft(Node left) {
        this.left = left;
    }
    public Node getRight() {
        return this.right;
    }
    public Node getLeft() {
        return this.left;
    }
    public char getKey() {
        return this.key;
    }
}
