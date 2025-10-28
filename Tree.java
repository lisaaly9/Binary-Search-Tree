public class Tree {
    private Node root;

    public Tree() {
        this.root = null;
    }

    public boolean add(char key) {
        if (root == null) {
            root = new Node(key);
            return true;
        }
        return addRecursive(root, key);
    }

    private boolean addRecursive(Node current, char key) {
        if (key < current.getKey()) {
            if (current.getLeft() == null) {
                current.setLeft(new Node(key));
                return true;
            } else {
                return addRecursive(current.getLeft(), key);
            }
        } else if (key > current.getKey()) {
            if (current.getRight() == null) {
                current.setRight(new Node(key));
                return true;
            } else {
                return addRecursive(current.getRight(), key);
            }
        } else {
            return false;
        }
    }

    public boolean remove(char key) {
        if (root == null) {
            return false;
        }
        boolean[] found = {false};
        root = removeRecursive(root, key, found);
        return found[0];
    }

    private Node removeRecursive(Node current, char key, boolean[] found) {
        if (current == null) {
            return null;
        }
        if (key < current.getKey()) {
            current.setLeft(removeRecursive(current.getLeft(), key, found));
        } else if (key > current.getKey()) {
            current.setRight(removeRecursive(current.getRight(), key, found));
        } else {
            found[0] = true;
            if (current.getLeft() == null && current.getRight() == null) {
                return null;
            } else if (current.getLeft() == null) {
                return current.getRight();
            } else if (current.getRight() == null) {
                return current.getLeft();
            } else {
                char smallestValue = findSmallestValue(current.getRight());
                Node newNode = new Node(smallestValue);
                newNode.setLeft(current.getLeft());
                newNode.setRight(removeRecursive(current.getRight(), smallestValue, new boolean[]{false}));
                return newNode;
            }
        }
        return current;
    }

    private char findSmallestValue(Node root) {
        return root.getLeft() == null ? root.getKey() : findSmallestValue(root.getLeft());
    }

    public boolean isExist(char key) {
        return isExistRecursive(root, key);
    }

    private boolean isExistRecursive(Node current, char key) {
        if (current == null) {
            return false;
        }
        if (key == current.getKey()) {
            return true;
        }
        return key < current.getKey()
            ? isExistRecursive(current.getLeft(), key)
            : isExistRecursive(current.getRight(), key);
    }

    public void preOrder() {
        preOrderRecursive(root);
        System.out.println();
    }

    private void preOrderRecursive(Node node) {
        if (node != null) {
            System.out.print(node.getKey() + " ");
            preOrderRecursive(node.getLeft());
            preOrderRecursive(node.getRight());
        }
    }

    public void inOrder() {
        inOrderRecursive(root);
        System.out.println();
    }

    private void inOrderRecursive(Node node) {
        if (node != null) {
            inOrderRecursive(node.getLeft());
            System.out.print(node.getKey() + " ");
            inOrderRecursive(node.getRight());
        }
    }

    public void postOrder() {
        postOrderRecursive(root);
        System.out.println();
    }

    private void postOrderRecursive(Node node) {
        if (node != null) {
            postOrderRecursive(node.getLeft());
            postOrderRecursive(node.getRight());
            System.out.print(node.getKey() + " ");
        }
    }

    public void printTree() {
        if (root == null) {
            System.out.println("Tree kosong");
            return;
        }
        printTreeRecursive(root, " ", true, " ");
    }

    private void printTreeRecursive(Node node, String prefix, boolean isTail, String label) {
        if (node != null) {
            System.out.println(prefix + (isTail ? "└── " : "├── ") + node.getKey() + label);
            if (node.getLeft() != null || node.getRight() != null) {
                String newPrefix = prefix + (isTail ? "    " : "│   ");
                if (node.getRight() != null) {
                    printTreeRecursive(node.getRight(), newPrefix, node.getLeft() == null, "(Right)");
                }
                if (node.getLeft() != null) {
                    printTreeRecursive(node.getLeft(), newPrefix, true, "(Left)");
                }
             }
        }
    }

    public void clearTree() {
        root = null;
    }
}