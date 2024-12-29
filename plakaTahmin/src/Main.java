import javax.swing.*;
import java.util.Random;
import java.util.LinkedHashMap;

public class Main {
     public static void main(String[] args) throws InterruptedException {
        Random random = new Random();
        int kalanHak = 3;
        int puan = 0;
        LinkedHashMap<Integer, String> sehirPlakalari = new LinkedHashMap<>();
         String[] sehirler = {"ADANA", "ADIYAMAN", "AFYON", "AĞRI", "AMASYA", "ANKARA", "ANTALYA",
                 "ARTVİN", "AYDIN", "BALIKESİR", "BİLECİK", "BİNGÖL", "BİTLİS", "BOLU", "BURDUR",
                 "BURSA", "ÇANAKKALE", "ÇANKIRI", "ÇORUM", "DENİZLİ", "DİYARBAKIR", "EDİRNE",
                 "ELAZIĞ", "ERZİNCAN", "ERZURUM", "ESKİŞEHİR", "GAZİANTEP", "GİRESUN", "GÜMÜŞHANE",
                 "HAKKARİ", "HATAY", "ISPARTA", "MERSİN", "İSTANBUL", "İZMİR", "KARS", "KASTAMONU",
                 "KAYSERİ", "KIRIKLARELİ", "KIRŞEHİR", "KOCAELİ", "KONYA", "KÜTAHYA", "MALATYA",
                 "MANİSA", "KAHRAMANMARAŞ", "MARDİN", "MUĞLA", "MUŞ", "NEVŞEHİR", "NİĞDE", "ORDU",
                 "RİZE", "SAKARYA", "SAMSUN", "SİİRT", "SİNOP", "SİVAS", "TEKİRDAĞ", "TOKAT",
                 "TRABZON", "TUNCELİ", "ŞANLIURFA", "UŞAK", "VAN", "YOZGAT", "ZONGULDAK",
                 "AKSARAY", "BAYBURT", "KARAMAN", "KIRIKKALE", "BATMAN", "ŞIRNAK", "BARTIN",
                 "ARDAHAN", "IĞDIR", "YALOVA", "KARABÜK", "KİLİS", "OSMANİYE", "DÜZCE"};

         for (int i = 0; i < sehirler.length; i++) {
             sehirPlakalari.put(i + 1, sehirler[i]);
         }


        String isim = JOptionPane.showInputDialog(null, "Plaka tahmin oyunumuza hoşgeldiniz.\n" +
                "İsminizi girer misiniz?");

        JOptionPane.showMessageDialog(null, "Genel kurallarımızı veriyorum:\n" +
                "1. 3 yanlış hakkınız vardır\n" +
                "2. Her soru 10 puandır\n" +
                "İyi oyunlar dileriz:)");
        while (kalanHak > 0) {
            for (int i = 1; i <= 10; i++) {
                int plaka = random.nextInt(1,81);
                String SehirTahmin;
                SehirTahmin = JOptionPane.showInputDialog(i + ".SORU:\n" +
                        sehirPlakalari.get(plaka) + " şehrinin plaka kodu nedir?");
                if (SehirTahmin == null) {
                    JOptionPane.showMessageDialog(null, "Oyunu sonlandırdınız.");
                    return;
                }
                int tahmin=0;
                if (SehirTahmin != null) {
                    try {
                         tahmin = Integer.parseInt(SehirTahmin);
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Geçerli bir sayı girmediniz!", "Hata", JOptionPane.ERROR_MESSAGE);
                    }
                }

                if (tahmin == plaka) {
                    puan += 10;
                    JOptionPane.showMessageDialog(null, "Tebrikler cevabınız doğru.");
                    Thread.sleep(100);//daha gerçekçi bir deneyim için 0,1 saniyelik bekleme süresi koyduk.
                } else if (tahmin != plaka) {
                    kalanHak = (kalanHak - 1);
                    JOptionPane.showMessageDialog(null, "Cevabınız hatalı!!\n" +
                            "Cevap " + plaka + " olmalıydı ne yazık ki.\n" +
                            "Kalan hakkınız: " + kalanHak);
                    Thread.sleep(100);
                    if (kalanHak <= 0) {
                        break;
                    }
                }
            }

            String tekrar = JOptionPane.showInputDialog(null, "Sayın "+isim+" Toplam Puanınız: " + puan +
                    "\nTekrar oynamak ister misiniz?(Evet/Hayır)");

        if (tekrar!= null &&tekrar.equalsIgnoreCase("evet")) {
            kalanHak = (kalanHak + 3);
        } else if (tekrar!=null && tekrar.equalsIgnoreCase("hayır")) {
            JOptionPane.showMessageDialog(null,"Oyun sonlandırıldı. İyi günler.");
            return;
        } else {
            int tekrarLimit=3;//Yanlış kodlama sonrası tekrar oynamak isteyip istenmediğini sormak içindir
            while (tekrarLimit>0) {

                JOptionPane.showMessageDialog(null, "Yanlış kodlama yaptınız!!! Kalan giriş hakkınız: " + tekrarLimit);
                String tekrar2 = JOptionPane.showInputDialog(null,  "Tekrar oynamak ister misiniz?");

                if (tekrar2!= null && tekrar2.equalsIgnoreCase("evet")) {
                    kalanHak=(kalanHak+3);
                    break;
                } else if (tekrar2!=null && tekrar2.equalsIgnoreCase("hayır")){
                   JOptionPane.showMessageDialog(null,"Oyun sonlandırıldı.");
                    return;
                }
                tekrarLimit--;
                if (tekrarLimit == 0) {
                    JOptionPane.showMessageDialog(null, "Çok fazla yanlış giriş yaptınız. Oyun sonlandırılıyor.");
                    return;
                }
            }
            }
        }
    }
}
