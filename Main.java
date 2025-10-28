import java.util.Scanner;
import java.util.Random;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {

        Tree bst = new Tree();

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        boolean isRunning = true;
        while (isRunning) {
            System.out.println("\n======= Menu Utama BST =======");
            System.out.println("1. Menu Manual (char A-Z)");
            System.out.println("2. Menu Otomatis (char A-Z)");
            System.out.println("3. Keluar");
            System.out.print("Pilihan: ");

            int pilihan = getInputInt(scanner);

            switch (pilihan) {
                case 1:
                    handleMenuManual(bst, scanner);
                    break;
                case 2:
                    handleMenuOtomatis(bst, scanner, random);
                    break;
                case 3:
                    System.out.println("Keluar dari program.");
                    isRunning = false;
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan pilih 1-3.");
            }
        }
        scanner.close();
    }
    private static void handleMenuManual(Tree bst, Scanner scanner) {

        bst.clearTree();
        boolean isRunning = true;
        while (isRunning) {
            System.out.println("\n======= Menu BST Manual =======");
            System.out.println("1. Tambah Key");
            System.out.println("2. Hapus Key");
            System.out.println("3. Cek Key");
            System.out.println("4. Tampilkan Pohon & Traversal");
            System.out.println("5. Kembali ke Menu Utama");
            System.out.print("Pilihan: ");
            int pilihan = getInputInt(scanner);

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan key yang ingin ditambahkan: ");
                    char addKey = getInputChar(scanner);

                    if (bst.add(addKey)) {
                        System.out.println("Key " + addKey + " berhasil ditambahkan");
                    } else {
                        System.out.println("Key " + addKey + " sudah ada dalam BST");
                    }
                    bst.printTree();
                    break;

                case 2:
                    System.out.print("Masukkan key yang ingin dihapus: ");
                    char removeKey = getInputChar(scanner);
                    if (bst.remove(removeKey)) {
                        System.out.println("Key " + removeKey + " berhasil dihapus");
                        bst.printTree();
                    } else {
                        System.out.println("Key " + removeKey + " tidak ditemukan dalam BST");
                    }
                    break;

                case 3:
                    System.out.print("Masukkan key yang ingin dicek: ");
                    char checkKey = getInputChar(scanner);
                    if (bst.isExist(checkKey)) {
                        System.out.println("Key " + checkKey + " ditemukan dalam BST");
                    } else {
                        System.out.println("Key " + checkKey + " tidak ditemukan dalam BST");
                    }
                    break;

                case 4:
                    System.out.println("Tampilkan semuanya kembali:");
                    System.out.println();
                    bst.printTree();
                    System.out.println();
                    System.out.println("-------------------------------------------");
                    System.out.print("Pre-Order: ");
                    bst.preOrder();
                    System.out.println();
                    System.out.print("In-Order: ");
                    bst.inOrder();
                    System.out.println();
                    System.out.print("Post-Order: ");
                    bst.postOrder();
                    System.out.println();
                    System.out.println("-------------------------------------------");
                    break;

                case 5:
                    System.out.println("Kembali ke Menu Utama...");
                    isRunning = false;
                    break;

                default:
                    System.out.println("Pilihan tidak valid. Silakan pilih 1-5.");
            }
        }
    }

    /**
     * Mengelola semua logika untuk menu otomatis.
     */
    private static void handleMenuOtomatis(Tree bst, Scanner scanner, Random random) {
        bst.clearTree();
        char[] keys = new char[10];
        System.out.println("\n======= Menu BST Otomatis =======");
        System.out.println("Generate 10 random characters...");
        for (int i = 0; i < 10; i++) {
            keys[i] = (char) (random.nextInt(26) + 'A');
            bst.add(keys[i]);
        }

        System.out.print("Keys yang dimasukkan: ");
        for (char key : keys) {
            System.out.print(key + " ");
        }
        System.out.println();

        bst.printTree();
        System.out.println("-------------------------------------------");
        System.out.print("Pre-Order: "); bst.preOrder(); System.out.println();
        System.out.print("In-Order: "); bst.inOrder(); System.out.println();
        System.out.print("Post-Order: "); bst.postOrder(); System.out.println();
        System.out.println("-------------------------------------------");

        boolean isRunning = true;
        while (isRunning) {
            System.out.println("\nApa yang ingin Anda lakukan dengan pohon ini?");
            System.out.println("1. Cek Key");
            System.out.println("2. Hapus Key");
            System.out.println("3. Tampilkan Pohon Lagi");
            System.out.println("4. Generate Ulang Pohon");
            System.out.println("5. Kembali ke Menu Utama");
            System.out.print("Pilihan: ");

            int pilihan = getInputInt(scanner);

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan key yang ingin dicek: ");
                    char checkKey = getInputChar(scanner);
                    if (bst.isExist(checkKey)) {
                        System.out.println("Key " + checkKey + " ditemukan dalam BST");
                    } else {
                        System.out.println("Key " + checkKey + " tidak ditemukan dalam BST");
                    }
                    break;

                case 2:
                    System.out.print("Masukkan key yang ingin dihapus: ");
                    char removeKey = getInputChar(scanner);
                    if (bst.remove(removeKey)) {
                        System.out.println("Key " + removeKey + " berhasil dihapus");
                        bst.printTree();
                    } else {
                        System.out.println("Key " + removeKey + " tidak ditemukan dalam BST");
                    }
                    break;

                case 3:
                    System.out.println("Tampilkan semuanya kembali:");
                    bst.printTree();
                    System.out.println("-------------------------------------------");
                    System.out.print("Pre-Order: "); bst.preOrder(); System.out.println();
                    System.out.print("In-Order: "); bst.inOrder(); System.out.println();
                    System.out.print("Post-Order: "); bst.postOrder(); System.out.println();
                    System.out.println("-------------------------------------------");
                    break;
                case 4:
                    System.out.println("Generate ulang pohon...");
                    handleMenuOtomatis(bst, scanner, random);
                    isRunning = false;
                    break;
                case 5:
                    System.out.println("Kembali ke Menu Utama...");
                    isRunning = false;
                    break;

                default:
                    System.out.println("Pilihan tidak valid. Silakan pilih 1-5.");
            }
        }
    }
    private static int getInputInt(Scanner scanner) {
        while (true) {
            try {
                String input = scanner.nextLine();
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.print("Input tidak valid. Masukkan angka: ");
            }
        }
    }
    private static char getInputChar(Scanner scanner) {
        while (true) {
            String input = scanner.nextLine().toUpperCase();
            if (input.length() > 0) {
                return input.charAt(0);
            } else {
                System.out.print("Input tidak boleh kosong. Masukkan satu karakter: ");
            }
        }
    }
}