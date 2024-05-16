package AlgVillage.Level15;

import java.util.BitSet;

public class HugeDataset {
    public static void main(String[] args) {

    }
    public void FindDuplicates(int[] array) {
        BitSet bs = new BitSet(32000);
        for (int i = 0; i < array.length; i++) {
            int num = array[i];
            int num0 = num - 1;
            if (bs.get(num0)) {
                System.out.println(num);
            } else {
                bs.set(num0);
            }

        }

    }

    class
}
