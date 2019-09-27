import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Gra{
    public static final void cls(){
        try{
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        }
        catch (final IOException | InterruptedException e){
            System.out.println("Wystapil blad: "+e);
        }
    }
    public static final void wait(int time){
        try {
            TimeUnit.MILLISECONDS.sleep(time);
        } catch (InterruptedException ex) {
            Logger.getLogger(Gra.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    static boolean comp[] = new boolean[3];

    public static void main(String[] args) throws IOException{
        Stages stg = new Stages();
        
        Gra.cls();
        System.out.println("Znalazles pendrive. Otwierasz plik Readme.txt:");
        System.out.println();
        System.out.println(
                String.format(
                        "%-5s"+"%s"+"%9s", "Ne", "Mendelejew", "Tabela"
                )
        );
        System.out.println();
        Gra.wait(1000);
        System.out.println("Otwierasz drugi plik. To aplikacja.");
        System.out.println();
        Gra.wait(500);
        System.out.println("-- f$#a_6_ggf^5$& --");
        stg.stage1();
        Gra.cls();
        System.out.println("Przyznano dostęp.");
        stg.prepStage2();
        Gra.wait(2000);
        Gra.cls();
        if (comp[0]==true){
            stg.stage2();
        }
        else{
            stg.altStage2();
        }
        if (comp[1]==true){
            stg.stage3();
        }
        else{
            stg.altStage3();
        }
        //stg.test();
    }
}