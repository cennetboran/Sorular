
/*
    Cennet BORAN
    1611012069
*/

import java.util.Scanner;

public class soru1 {
    
    public static void main(String[] args) {
        System.out.println("1'den kaça kadar olan sayilarin kareleri toplamı bulunsun?");
        Scanner d = new Scanner(System.in);
        int deger = d.nextInt();
        System.out.println(topla(deger));
    }
    
    public static int topla(int n){
        if(n<1){
            return 0;
        }else{
            return (n*n)+topla(n-1);
        }
    }
}
