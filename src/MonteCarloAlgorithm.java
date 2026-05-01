import java.util.Random;

public class MonteCarloAlgorithm {
    private int[] veriDizisi;
    private Random random;
    private int iterasyonLimiti;

    public MonteCarloAlgorithm(int[] veriDizisi, long seed, int iterasyonLimiti) {
        this.veriDizisi = veriDizisi;
        // Seçimleri yaparken de aynı seed üzerinden türetilen rastgeleliği kullanıyoruz
        this.random = new Random(seed);
        this.iterasyonLimiti = iterasyonLimiti;
    }

    // Problem koşulumuz: 7'ye tam bölünen sayıyı bulmak
    private boolean kosuluSagliyorMu(int sayi) {
        return sayi % 7 == 0;
    }

    public boolean calistir() {
        int boyut = veriDizisi.length;

        for (int j = 0; j < iterasyonLimiti; j++) {
            // Diziden rastgele bir index seçiyoruz
            int rastgeleIndex = random.nextInt(boyut);

            if (kosuluSagliyorMu(veriDizisi[rastgeleIndex])) {
                return true; // Hedef başarıyla bulundu
            }
        }
        return false; // k iterasyon bitti, hedef bulunamadı (error)
    }
}