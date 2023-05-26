/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package janovec;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
/**
 *
 * @author ul
 */
public class PeriodicTable{
    
    private ArrayList<Element> table;
    public PeriodicTable(){
        this.table = new ArrayList();
    }
    public void addElement(String name, String symbol, int protonN, double relativeAtomWeight){
        table.add(new Element(name,symbol,protonN,relativeAtomWeight));
    }
    public Element getElement(int n){
        return table.get(n);
    }
    public Element getElement(String symbol){
        for (Element element : table) {
            if(element.getSymbol().equals(symbol)){
                return element;
            }
        }
        return null;
    }
    public void setSymbolElementsProtonN(int year,String symbol){
        for (Element element : table) {
            if(element.getSymbol().equals(symbol)){
                element.setDiscoverYear(year);
            }
            
        }
    }
    //u pretizenych metod volat se navzajem, nekopirovat kod
    public void setSymbolElementsProtonN(String year,String symbol){
        if(!year.equals("N")){
            for (Element element : table) {
                if(element.getSymbol().equals(symbol)){

                    element.setDiscoverYear(Integer.parseInt(year));
                }

            }
        }
    }
    public void sortByProtonN(){
        Collections.sort(table);
    }
    public void sortByHighestProtonN(){
        Collections.sort(table);
        Collections.reverse(table);
    }
    public String listByProtonN(){
        sortByProtonN();
        return listElements();
    }
    public String listByProtonN(int n){
        sortByProtonN();
        return listElements(n);
    }
    public String listByHighestProtonN(){
        sortByHighestProtonN();
        return listElements();
    }
    public String listByHighestProtonN(int n){
        sortByHighestProtonN();
        return listElements(n);
    }
    public String listElements(int n){ //môze pripadne vracet i kopie listu elementu
        String buff = "";
        for (int i = 0; i < n; i++) {
            buff+=table.get(i).toString()+"\n";
            
        }
        return buff;
    }
    public Element findOldestElement(){
        int min = Integer.MAX_VALUE;
        Element el = null;
        for (Element element : table) {
            if(element.hasYear()){
                if(element.getYear()<min){
                    min = element.getYear();
                    el = element;
                }
            }
        }
        return el;
    }
    public String listElements(){ //JV lepsi pomoci StringBuildera
        String buff = "";
        for (Element element : table) {
            buff+=element.toString() + "\n";
            
        }
        return buff;
    }
    public void loadElements(File f) throws IOException{
        try(BufferedReader bf = new BufferedReader(new FileReader(f))){
            String line;
            line=bf.readLine();
            ArrayList<String> alreadyAdded= new ArrayList();
            while((line=bf.readLine())!=null){
                String[] buffs = line.split(",");
                if(!alreadyAdded.contains(buffs[0])){
                    alreadyAdded.add(buffs[0]);
                    String name = buffs[0];
                    int cislo = Integer.parseInt(buffs[1]);
                    String symbol = buffs[2];
                    double hmotnost = Double.parseDouble(buffs[3]);
                    //table.addElement(name, symbol, cislo, hmotnost);
                    //table.add(new Element(name, symbol, cislo, hmotnost));
                    addElement(name, symbol, cislo, hmotnost);
                }
            }
            
        }
    }
    public void loadYears(File f) throws FileNotFoundException{
        try(Scanner sc = new Scanner(f)){
           // System.out.println(sc.findInLine(" "));
            //System.out.println(sc.findAll(" "));
            sc.nextLine();
            while(sc.hasNext()){
                sc.next();
                sc.next();
                String symbol = sc.next();
                String year = sc.next();
                setSymbolElementsProtonN(year, symbol);
            }
        }
    }
   
}
