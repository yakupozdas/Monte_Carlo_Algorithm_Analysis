import java.util.Random;

public class DataGenerator {
    private Random random;

    public DataGenerator(long seed) {
        this.random = new Random(seed);
    }

    public int[] diziOlustur(int boyut) {
        int[] dizi = new int[boyut];
        for (int i = 0; i < boyut; i++) {
            // 1 ile 100.000 arasında rastgele sayılar üretiyoruz
            dizi[i] = random.nextInt(100000) + 1;
        }
        return dizi;
    }
}