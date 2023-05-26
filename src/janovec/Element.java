/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package janovec;

/**
 *
 * @author ul
 */
public class Element implements Weightable,Comparable<Element>{
    private String name;
    private String symbol;
    private int protonN;
    private double relativeAtomW;
    private double relativeElementW;
    private boolean hasYear=false;
    private int discoverYear;
    
    public Element(String name, String symbol, int protonN, double relativeAtomW){
        this.name = name;
        this.symbol = symbol;
        this.protonN = protonN;
        this.relativeAtomW = relativeAtomW;
    }
    public void setDiscoverYear(int year){ //JV nastavit, jen když ještě nemá
        this.discoverYear = year;
        this.hasYear = true;
    }
    public String getSymbol(){
        return this.symbol;
    }
    @Override
    public String toString(){
        getWeight();
        return String.format("%s %s %d %f %s",name,symbol,protonN,relativeElementW,(hasYear)?Integer.toString(discoverYear):"neuvedeno");
    }

    @Override
    public double getWeight() {
        this.relativeElementW = relativeAtomW;
        return this.relativeElementW;
    }
    public String getName(){
        return this.name;
    }
    public int getYear(){
        if(hasYear){
            return this.discoverYear;
        }
        return 0;
    }
    public boolean hasYear(){
        return this.hasYear;
    }
    @Override
    public int compareTo(Element o) {
        return this.protonN-o.protonN;
    }

    
    
}
