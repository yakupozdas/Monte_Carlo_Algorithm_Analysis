# Monte Carlo Algoritma Analizi ve İstatistiksel İspat

Bu proje, büyük bir veri seti içerisindeki "özel" bir elemanın (koşulu sağlayan eleman) tespit edilmesini amaçlayan **Monte Carlo** randomize algoritma yaklaşımının deneysel ve teorik analizini içerir. 

Proje kapsamında, rastgeleliğin zaman karmaşıklığı ve doğruluk payı (hata olasılığı) üzerindeki etkileri deneysel olarak ispatlanmıştır.

## 📌 Proje Parametreleri
Ödev yönergeleri ve öğrenci numarası (1240505034) doğrultusunda belirlenen kriterler:

- **Algoritma Tipi:** Monte Carlo Yaklaşımı (Sınırlı iterasyonda olasılıksal sonuç)
- **Veri Hacmi (N):** 100.000 (10^5)
- **Problem Tanımı:** Rastgele üretilmiş dizide `mod 7 == 0` koşulunu sağlayan eleman tespiti.
- **İterasyon Limiti (k):** 15
- **Deneme Sayısı:** İstatistiksel veri toplamak için algoritma 100 kez çalıştırılmıştır.

## 🏗️ Proje Yapısı (OOP)
Proje, Nesne Yönelimli Programlama prensiplerine uygun olarak 4 ana sınıfa ayrılmıştır:

1.  **Main:** Simülasyonu yöneten, 100 kez çalıştırmayı kontrol eden ve sonuçları raporlayan ana sınıf.
2.  **DataGenerator:** Öğrenci numarası ile beslenen (Seed) rastgele veri setini oluşturan sınıf.
3.  **MonteCarloAlgorithm:** Çekirdek algoritma mantığının (sınırlı iterasyonla arama) bulunduğu sınıf.
4.  **Statistics:** Çalışma sürelerini (nanosaniye), ortalamayı ve standart sapmayı hesaplayan analiz sınıfı.

## 📊 Analiz ve Sonuçlar
Proje sonucunda elde edilen veriler şu iki temel noktayı ispatlamaktadır:

### 1. Teorik vs Pratik Hata Oranı
- **Teorik Hata Olasılığı:** P(error) = (6/7)^15 ≈ **%9.9**
- **Deneysel Sonuç:** Yapılan 100 deneme sonucunda hata oranının teorik beklentiye (%10 civarı) çok yakın olduğu gözlemlenmiştir.

### 2. Zaman Analizi ve Standart Sapma
Algoritmanın çalışma süresindeki standart sapmanın ortalama süreden yüksek çıkması, rastgeleliğin süresel istikrarsızlığını (hedefin bazen 1. bazen 15. adımda bulunması) matematiksel olarak kanıtlamıştır. Zaman karmaşıklığı **O(1)** düzeyindedir çünkü veri boyutundan bağımsız olarak sabit bir `k` limiti ile çalışmaktadır.

## 🚀 Nasıl Çalıştırılır?
1. Projeyi bilgisayarınıza clone'layın.
2. Herhangi bir Java IDE'sinde (IntelliJ IDEA, Eclipse vb.) projeyi açın.
3. `Main.java` sınıfını çalıştırın.
4. Konsol çıktısında zaman analizi ve hata oranlarını görebilirsiniz.

---
