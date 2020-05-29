/*
    Cennet BORAN
    1611012069
*/



import java.util.Random;
import java.util.Scanner;


public class soru2 {
    
    public static void main(String[] args) {
        
        int[] tek={1,3,5,7,9,11,13,15,17,19,21,23,25,27,29,31,33,35,37,39,41,43,45,47,49}; //1 den 49 a kadar olan bütün tek sayılar
        int[] cift={2,4,6,8,10,12,14,16,18,20,22,24,26,28,30,32,34,36,38,40,42,44,46,48}; //1 den 49 a kadar olan bütün çift sayılar
        int tekLength = tek.length; // tek sayılar dizisinin uzunluğu
        int ciftLength = cift.length; // çift sayılar dizisinin uzunluğu
        int kolonSayisi = 0; // kaç kolon oynanacağı kolon sayısı
        int[] kolon = {0,0,0,0,0,0}; // başlangıç kolon dizisi
        boolean kolonKontrol = true; // kolonun kurallara uyup uymadığı kontrolü
        boolean kolonSayisiKontrolu = true; // girilen kolon sayısının kontrolü
        
        // (1) oynanacak kolon sayısı 1 ile 8 arasında mı kontrolü
        while(kolonSayisiKontrolu){
            kolonSayisiKontrolu = false;
            System.out.println("Kaç kolon oynamak istersiniz?");
            Scanner s = new Scanner(System.in);
            kolonSayisi = s.nextInt();
            if(kolonSayisi<1 || kolonSayisi>8){
                System.out.println("1 ile 8 arasında kolon oynayabilirsiniz");
                kolonSayisiKontrolu = true;
            }
        }
        // (1) bitiş
        
        // (2) kaç kolon girildiyse o kadar kolon oluşturuluyor
        for(int i=0;i<kolonSayisi;i++){
            kolonKontrol = true; //kolonda 1-10 11-20 21-30 31-40 41-49 sayıları arasında 2 den fazla olup olmadığının kontrolü
            while(kolonKontrol){
                kolonKontrol = false;
                // (3) random kolon oluşturma
                for(int j=0;j<3;j++){
                Random tr = new Random();
                Random cr = new Random();
                int rand_int1 = tr.nextInt(tekLength);
                int rand_int2 = cr.nextInt(ciftLength);
                kolon[j] = tek[rand_int1];
                kolon[j+3] = cift[rand_int2];
                for(int a=rand_int1;a<tekLength-1;a++){
                    tek[a] = tek[a+1];
                }
                tekLength--;
                for(int b=rand_int2;b<ciftLength-1;b++){
                    cift[b] = cift[b+1]; 
                }
                ciftLength--;
                }
                // (3) bitiş
                
                // (4) oluşturulan kolonda 1-10 11-20 21-30 31-40 41-49 sayıları arasında 
                //      2 den fazla olup olmadığının kontrolü ve varsa kolondaki sayılar
                //      tekrar tek ve çift dizilerine yerleştiriliyor
            if(kontrolDogrumu(kolon)){
                kolonKontrol = true;
                for(int p=0;p<6;p++){
                    if(kolon[p] % 2 == 0){
                        cift[ciftLength] = kolon[p];
                        ciftLength++;
                    }
                    if(kolon[p] % 2 == 1){
                        tek[tekLength] = kolon[p];
                        tekLength++;
                    }
                }
            }
            // (4) bitiş
            }
            
            kolon = sirala(kolon);
            yazdir(kolon, i+1);
            System.out.println("");
        }
        // (2) bitiş
       
    }
    // kolonlar için yazdırma fonksiyonu
   public static void yazdir(int[] dizi, int a){ 
       System.out.println("KOLON " + a + " sayıları:");
       for(int i=0;i<dizi.length;i++){
           System.out.print(dizi[i] + " ");
       }
       System.out.println("");
   }
   
   // kolonları küçükten büyüğe sıralama fonksiyonu
   public static int[] sirala(int[] dizi){ 
        int n = dizi.length; 
        for (int i = 0; i < n-1; i++){
            for (int j = 0; j < n-i-1; j++) {
                if (dizi[j] > dizi[j+1]) 
                { 
                    int temp = dizi[j]; 
                    dizi[j] = dizi[j+1]; 
                    dizi[j+1] = temp; 
                } 
            }
        }
        return dizi;
    } 
   
   // kolonda 1-10 11-20 21-30 31-40 41-49 sayıları arasında 2 den fazla olup olmadığının kontrol fonksiyonu
   public static boolean kontrolDogrumu(int[] kolon){ 
       
       int sayac = 0;
       
       for(int i=0;i<5;i++){
           if(sayac >2){
               return true;
           }
           sayac = 0;
           for(int k=0;k<kolon.length;k++){
               switch(i){
                   case 0:
                       if(kolon[k]>=1 && kolon[k]<=10){
                           sayac++;
                       }
                       break;
                    case 1:
                       if(kolon[k]>=11 && kolon[k]<=20){
                           sayac++;
                       }
                       break;
                    case 2:
                       if(kolon[k]>=21 && kolon[k]<=30){
                           sayac++;
                       }
                       break;
                    case 3:
                       if(kolon[k]>=31 && kolon[k]<=40){
                           sayac++;
                       }
                       break;
                    case 4:
                       if(kolon[k]>=41 && kolon[k]<=49){
                           sayac++;
                       }
                       break;
               }
           }
       }
       return false;
   }
}
