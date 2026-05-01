public class Main {
    public static void main(String[] args) {
        // Öğrenci numarası (Seed)
        long seed = 1240505034L;
        int n = 100000; // Son hane (4) < 5 olduğu için
        int calistirmaSayisi = 100;
        int k_iterasyon = 15; // Hata oranını belirleyecek iterasyon sınırı

        System.out.println("--- ÖDEV BİLGİLERİ ---");
        System.out.println("Öğrenci No: " + seed);
        System.out.println("Algoritma: Monte Carlo (Çift Sayı)");
        System.out.println("Veri Hacmi: " + n + "\n");

        // 1. Veri dizisini seed ile oluşturuyoruz
        DataGenerator generator = new DataGenerator(seed);
        int[] veriDizisi = generator.diziOlustur(n);

        // 2. Monte Carlo algoritmasını ve İstatistik sınıfını hazırlıyoruz
        MonteCarloAlgorithm algoritma = new MonteCarloAlgorithm(veriDizisi, seed, k_iterasyon);
        Statistics istatistik = new Statistics(calistirmaSayisi);

        // 3. Algoritmayı tam 100 kez çalıştırıyoruz
        int hataSayisi = 0;

        for (int i = 0; i < calistirmaSayisi; i++) {
            long baslangicZamani = System.nanoTime();

            boolean sonuc = algoritma.calistir();

            long bitisZamani = System.nanoTime();
            long gecenSure = bitisZamani - baslangicZamani;

            istatistik.sureEkle(i, gecenSure);

            // Monte Carlo algoritması sonucu false dönerse hedefi bulamamıştır (hata)
            if (!sonuc) {
                hataSayisi++;
            }
        }

        // 4. Sonuçları yazdırıyoruz
        System.out.println("Algoritma " + calistirmaSayisi + " kez çalıştırıldı.");
        istatistik.sonuclariYazdir();

        double pratikHataOrani = ((double) hataSayisi / calistirmaSayisi) * 100;
        System.out.println("Gerçekleşen (Pratik) Hata Sayısı: " + hataSayisi);
        System.out.println("Gerçekleşen Hata Oranı: %" + pratikHataOrani);

        // Teorik değerle kıyas (P = (6/7)^15 ~ %9.9)
        System.out.println("Teorik Hata Oranı (Hesaplanan P(error)): ~%9.9");
    }
}