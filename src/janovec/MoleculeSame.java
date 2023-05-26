/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package janovec;

/**
 *
 * @author ul
 */
public class MoleculeSame implements Weightable{
    private Element ele;
    private String name; //JV pomocne promenne si neni potreba ukladat
    private int nOfElements;
    
    public MoleculeSame(Element ele, int nOfElements){
        this.ele = ele;
        this.nOfElements = nOfElements;
    }
    public MoleculeSame(Element ele){
        this.ele = ele;
        this.nOfElements = 1;
    }
    @Override
    public double getWeight() {
        return nOfElements*ele.getWeight();
    }
    public String getName(){
        return ele.getName()+Integer.toString(this.nOfElements);
    }
    public int getNOfAtoms(){
        return nOfElements;
    }
    
    
    
}
