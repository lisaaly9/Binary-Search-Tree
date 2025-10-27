import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Tree bst = new Tree();
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        char[] keys = new char[10];
        System.out.println("Generate 10 random characters (A-Z):");
        for (int i = 0; i < 10; i++) {
            keys[i] = (char) (random.nextInt(26) + 'A');
            bst.add(keys[i]);
        }

        System.out.print("Keys yang dimasukkan: ");
        for (char key : keys) {
            System.out.print(key + " ");
        }
        System.out.println();

        System.out.print("Pre-Order: ");
        bst.preOrder();

        System.out.print("In-Order: ");
        bst.inOrder();

        System.out.print("Post-Order: ");
        bst.postOrder();

        while (true) {
            System.out.println("\n======= Menu BST =======");
            System.out.println("1. Tambah key (char A-Z)");
            System.out.println("2. Hapus key (char A-Z)");
            System.out.println("3. Cek apakah key ada (char A-Z)");
            System.out.println("4. Tampilkan Pre-Order");
            System.out.println("5. Tampilkan In-Order");
            System.out.println("6. Tampilkan Post-Order");
            System.out.println("7. Tampilkan Struktur Tree (Visual)");
            System.out.println("8. Generate Ulang 10 Random Keys");
            System.out.println("9. Keluar");
            System.out.print("Pilih menu (1-9): ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Masukkan key yang ingin ditambahkan (A-Z): ");
                    char addKey = scanner.nextLine().toUpperCase().charAt(0);
                    if (bst.add(addKey)) {
                        System.out.println("Key " + addKey + " berhasil ditambahkan");
                    } else {
                        System.out.println("Key " + addKey + " sudah ada dalam BST");
                    }
                    break;
                case 2: 
                    System.out.print("Masukkan key yang ingin dihapus (A-Z): ");
                    char removeKey = scanner.nextLine().toUpperCase().charAt(0);
                    if (bst.remove(removeKey)) {
                        System.out.println("Key " + removeKey + " berhasil dihapus");
                    } else {
                        System.out.println("Key " + removeKey + " tidak ditemukan dalam BST");
                    }
                    break;
                case 3:
                    System.out.print("Masukkan key yang ingin dicek (A-Z): ");
                    char checkKey = scanner.nextLine().toUpperCase().charAt(0);
                    if (bst.isExist(checkKey)) {
                        System.out.println("Key " + checkKey + " ditemukan dalam BST");
                    } else {
                        System.out.println("Key " + checkKey + " tidak ditemukan dalam BST");
                    }
                    break;
                case 4:
                    System.out.print("Pre-Order: ");
                    bst.preOrder();
                    break;
                case 5:
                    System.out.print("In-Order: ");
                    bst.inOrder();
                    break;
                case 6:
                    System.out.print("Post-Order: ");
                    bst.postOrder();
                    break;
                case 7:
                    System.out.println("Struktur Tree (Visual):");
                    bst.printTree();
                    break;
                case 8:
                    bst.clearTree();
                    System.out.println("Generate 10 random characters (A-Z):");
                    for (int i = 0; i < 10; i++) {
                        keys[i] = (char) (random.nextInt(26) + 'A');
                        bst.add(keys[i]);
                    }
                    System.out.print("Keys yang dimasukkan: ");
                    for (char key : keys) {
                        System.out.print(key + " ");
                    }
                    System.out.println();
                    System.out.print("Pre-Order: ");
                    bst.preOrder();
                    System.out.print("In-Order: ");
                    bst.inOrder();
                    System.out.print("Post-Order: ");
                    bst.postOrder();
                    break;
                case 9:
                    System.out.println("Keluar dari program.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Pilihan tidak valid. Silakan pilih menu antara 1-7.");
            }
                   

        }
    }
}