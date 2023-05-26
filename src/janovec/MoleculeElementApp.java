/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package janovec;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author ul
 */
public class MoleculeElementApp {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        ArrayList<MoleculeSame> molecules = new ArrayList();
        String buff;
        PeriodicTable table = new PeriodicTable();
        MoleculeSame temp;
        File fPrvky = new File(System.getProperty("user.dir")+"\\data\\prvky.csv");
        try{
            table.loadElements(fPrvky);
        }catch(IOException e){
            System.out.println("Nepodarilo se nacist soubor "+e.getMessage());
        }
        while(!(buff = sc.nextLine()).equals("konec")){
            System.out.println(buff);
            String [] buffs = buff.split(" ");
            if(buffs.length > 1){
                temp = new MoleculeSame(table.getElement(buffs[0]),Integer.parseInt(buffs[1]));
                molecules.add(temp);
            }else{
                temp = new MoleculeSame(table.getElement(buffs[0]));
                molecules.add(temp);
            }
            System.out.println(temp.getWeight());
        }
        System.out.println("Zadejte kam chcete ulozit soubor");
        File f = new File(sc.next());
        if(f.exists()){
            System.out.println("Tento soubor exituje, chcete ho prespat? (a)");
            String choice = sc.next();
            if(choice.equals("a")){
                f.delete();
            }
        }
        try(BufferedWriter bw = new BufferedWriter(new BufferedOutputStream())){
            
        }
        
    }   catch (IOException ex) {
            System.out.println("Nepodarilo se zapsat do souboru");
        }
}
