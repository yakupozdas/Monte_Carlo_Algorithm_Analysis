public class Statistics {
    private long[] sureler;

    public Statistics(int kapasite) {
        sureler = new long[kapasite];
    }

    public void sureEkle(int index, long sure) {
        sureler[index] = sure;
    }

    public void sonuclariYazdir() {
        int n = sureler.length;
        long toplamSure = 0;

        for (long sure : sureler) {
            toplamSure += sure;
        }

        double ortalamaSure = (double) toplamSure / n;

        // Standart Sapma Hesaplama
        double varyansToplami = 0;
        for (int i = 0; i < n; i++) {
            varyansToplami += Math.pow(sureler[i] - ortalamaSure, 2);
        }
        double standartSapma = Math.sqrt(varyansToplami / n);

        System.out.println("--- ZAMAN ANALİZİ ---");
        System.out.println("Ortalama Çalışma Süresi: " + String.format("%.2f", ortalamaSure) + " nanosaniye");
        System.out.println("Standart Sapma         : " + String.format("%.2f", standartSapma) + " nanosaniye");
    }
}