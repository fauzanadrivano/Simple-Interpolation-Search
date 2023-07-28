import java.util.ArrayList;
import java.util.Scanner;

public class rumus {
    public static void main(String[] args) {
        Scanner y = new Scanner(System.in);
        ArrayList<Integer> data = new ArrayList<>();
        data.add(1);
        data.add(3);
        data.add(5);
        data.add(6);
        data.add(7);
        data.add(8);
        data.add(9);
        data.add(10);
        data.add(15);


        int indexTerkecil = 0;
        int indexTerbesar = data.size() - 1;
        int indexTengah;
        int key;

        System.out.print("\nMasukkan angka yang ingin dicari : ");
        key = y.nextInt();

        System.out.println(data);

        while (indexTerkecil <= indexTerbesar) {
            indexTengah = indexTerkecil + ((key - data.get(indexTerkecil)) * (indexTerbesar - indexTerkecil)
                    / (data.get(indexTerbesar) - data.get(indexTerkecil)));

            System.out.println();
            System.out.println(indexTengah);
            System.out.println(data.get(indexTengah));

            if (key == data.get(indexTengah)) {
                System.out.println("\nAngka ditemukan di indeks ke " + indexTengah);
                indexTerkecil = 100;
            } else if (key < data.get(indexTengah)) {
                indexTerbesar = indexTengah - 1;
            } else if (key > data.get(indexTengah)) {
                indexTerkecil = indexTengah + 1;
            }
        }
        System.out.println("\nTerima kasih");
    }
}
