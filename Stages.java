import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.*;
import javax.imageio.ImageIO;
import javax.swing.*;

class Stages{
    
    Scanner scan = new Scanner(System.in);          //wpisywanie 
    BufferedReader bf = new BufferedReader(
        new InputStreamReader(System.in)
    );
    BufferedImage imgg = null;
    Random rand = new Random();
    Gra gra = new Gra(); 
    JFrame okno;
    JButton butt[] = new JButton[9];
    Window wind[] = {null, null, null, null, null};
    
    String str1;
    String password = "neon";                       //stringi nie sa zmienialne
    String smth = "";
    String pass[] = {"p", "8", "g", "H", "3"};
    Image img;
    
    int check;
    double x0, a=0, b=0, c=0;
    
    public void paint(Graphics g){
        g.drawImage(img, 0, 0, null);
    }
    void test(){
        boolean a = true;
        wind[0] = new Window();
        wind[0].create("test");
        wind[0].visible(a);
        Gra.wait(2000);
        a = false;
        wind[0].visible(a);
        wind[0] = null;
        if (a == false){
            System.exit(0);
        }
    }

    void check1(int a, String smth, String password){
        if(smth.equals(password) || smth.equals("Neon") || smth.equals("NEON")){
            System.out.println("Dobrze.");
            a=7;
            check=7;
        }
        else if(a==6){
            int check=20;
            System.out.println("Hmm kreatywnie");
            System.out.println("0 - Dalej");
            System.out.println("1 - Hasło");
            this.check=10;
            while(check != 0 && check != 1){
                check = scan.nextInt();
            }
            if (check == 1){
                System.out.println("Haslo to: "+password);
                Gra.wait(2000);
            }
        }  
    }
    void genStg2(){
        int t;
        t = rand.nextInt(10)+1;
        a = rand.nextInt(10)+1;
        b = t*a;
        c = b*b/(4*a);
        x0=-b/(2*a);
    }
    void stage1(){
        int a = 5;
        while (a<=5 && (check!=10 || check!=7) && (!smth.equals(password) && (!smth.equals("Neon")) && (!smth.equals("NEON")))){
            System.out.println("Podaj hasło. Pozostało prób: "+a);
            System.out.print("Haslo: ");
            smth = scan.nextLine();
            check1(a, smth, password);
            a--;
            if (a == 0){
                System.out.println("Wzbroniono dostepu.");
                System.exit(0);
            }
            else if(a==5){
                a=6;
            }
            else if(a>5 || a<0){
                System.out.println("Wzbroniono dostepu.");
                System.exit(0);
            }
        }
    }
    void prepStage2(){
        if(check==7){
            Gra.comp[0] = true;
        }
        else{
            password = password.replaceAll("neon", "p8gH3");
            Gra.comp[0] = false;
        }
    }
    void stage2(){
        int result;
        String var = "";
        int i=24, j=33, res;
        genStg2();
        result =(int)a;
        Gra.cls();
        System.out.println("Poziom 2!");
        do{
            System.out.println(
                    String.format("%-20s"+"%s", "x0=-b/(2a)", "Delta=0")
            );
            i = i-12;
            Gra.wait(2000);
            Gra.cls();
            System.out.println("Aby powtorzyc wpisz: /rep");
            System.out.println("Aby podac odpowiedz nacisnij enter");
            var = scan.nextLine();
            if (i==0 && var.equals("/rep")){
                System.out.println("Koniec podpowiedzi. Przejście do zadania.");
                Gra.wait(2000);
            }
            else if(!var.equals("/rep")){
                System.out.println("Przechodzenie do zadania");
                i=0;
                Gra.wait(500);
            }
        }
        while(var.equals("/rep") && i>0);
        Gra.cls();
        System.out.println("a*x^(2)+"+b+"*x+"+c+"=0     x0="+x0);
        System.out.println("Oblicz wartosc a. Ignorujemy przecinek!");
        while((j/11)>0){
            try{
                res=Integer.parseInt(scan.nextLine());
            }
            catch (NumberFormatException ex){
                System.out.println("Wprowadz liczbe");
                res=1;
                continue;
            }
           if(res==result){
               j=-1;
           }
           else{
               j-=11;
               System.out.println("Zle. Pozostalo prob: "+(j/11));
           }
        }
        if(j==0){
             System.out.println("Przegrana");
             System.exit(0);
        }
        System.out.println("Dobrze!");
        Gra.comp[1] = true;
    }
    void altStage2(){
        int j=0, k=0;
        int number1[] = new int[5];
        int number2[] = {20, 20, 20, 20, 20};
        String tab[] = {"X", "X", "X", "X", "X"};
        System.out.println("\"Freeze! Don't move!\"");
        System.out.println("Uwaga. Poczekac dwa takty");
        Gra.wait(2500);
        for (int i=0; i<60; i++){
            Gra.cls();
            
            if (k<5){
                number1[k] = number2[k];
            }
            number2[k] = rand.nextInt(9);
            if (number1[k]!=number2[k]){
                System.out.println("Liczba: "+number2[k]);
                System.out.println(tab[0]+tab[1]+tab[2]+tab[3]+tab[4]);
                Gra.wait(2000);
                Gra.cls();
                if (number2[k]==number1[k]){
                    switch (j) {
                        case 0:
                            tab[j] = "p";
                            j++;
                            k++;
                            break;
                        case 1:
                            tab[j] = "8";
                            j++;
                            k++;
                            break;
                        case 2:
                            tab[j] = "g";
                            j++;
                            k++;
                            break;
                        case 3:
                            tab[j] = "H";
                            j++;
                            k++;
                            break;
                        case 4:
                            tab[j] = "3";
                            j++;
                            k++;
                            break;
                        default:
                            break;
                    }
                    
                }
            }
            if(j==5){
                i=61;
            }
        }
        System.out.println("Haslo wprowadzone. Firewall wylaczony");
        System.out.println(tab[0]+tab[1]+tab[2]+tab[3]+tab[4]);
        Gra.comp[1] = false;
    }
    void prepStage3(){
    }
    void stage3() {
       System.out.println("Stage 3");
       System.out.println("Comming soon!"); 
    }
    void altStage3() {
        System.out.println("Stage 3");
        System.out.println("Comming soon!");
        //code injection. dodawanie otwiera wiecej okienek, odejmowanie zamyka
    }
}
