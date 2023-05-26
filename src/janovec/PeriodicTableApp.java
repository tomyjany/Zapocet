/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package janovec;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
import javax.swing.plaf.TableUI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
/**
 *
 * @author ul
 */
public class PeriodicTableApp {
//    public static PeriodicTable loadElements(File f) throws IOException{
//        try(BufferedReader bf = new BufferedReader(new FileReader(f))){
//            PeriodicTable table = new PeriodicTable();
//            String line;
//            line=bf.readLine();
//            ArrayList<String> alreadyAdded= new ArrayList();
//            while((line=bf.readLine())!=null){
//                String[] buffs = line.split(",");
//                if(!alreadyAdded.contains(buffs[0])){
//                    alreadyAdded.add(buffs[0]);
//                    String name = buffs[0];
//                    int cislo = Integer.parseInt(buffs[1]);
//                    String symbol = buffs[2];
//                    double hmotnost = Double.parseDouble(buffs[3]);
//                    table.addElement(name, symbol, cislo, hmotnost);
//                }
//            }
//            
//        return table;
//        }
//    }
//    public static void loadYears(File f, PeriodicTable table) throws FileNotFoundException{
//        try(Scanner sc = new Scanner(f)){
//           // System.out.println(sc.findInLine(" "));
//            //System.out.println(sc.findAll(" "));
//            sc.nextLine();
//            while(sc.hasNext()){
//                sc.next();
//                sc.next();
//                String symbol = sc.next();
//                String year = sc.next();
//                table.setSymbolElementsProtonN(year, symbol);
//            }
//        }
//    }
    public static void main(String[] args) {
        //String ls = System.getProperty("line.separator");
        //System.out.println(ls+"ahoj"+ls);
        PeriodicTable table = new PeriodicTable();
        File fPrvky = new File(System.getProperty("user.dir")+"/data/prvky.csv");
        File froky = new File(System.getProperty("user.dir")+"/data/rokObjeveni.txt");
        //System.out.println((System.getProperty("user.dir")+ls+"data"+ls+"prvky.csv"));
        try{
            table.loadElements(fPrvky);
            System.out.println(table.listByHighestProtonN(10));
            try{
                table.loadYears(froky);
                System.out.println(table.findOldestElement());
            }catch(FileNotFoundException e){
                System.out.println("Soubor nebyl nalezen " + e.getMessage());
            }
        }catch(IOException e){
            System.out.println("Nepodarilo se nacist soubor "+e.getMessage());
        }
    }
}
