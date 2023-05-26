/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package janovec;

/**
 *
 * @author ul
 */
public class PeriodicTableTest {
    public static void main(String[] args) {
        PeriodicTable table = new PeriodicTable();
        table.addElement("Vodik", "H", 1, 1.1);
        table.addElement("Chlor", "Cl", 17, 35.45);
        table.addElement("Kyslik", "O", 8, 16.0);
        table.getElement("Cl").setDiscoverYear(1774);
        table.setSymbolElementsProtonN(1774, "Cl");
        System.out.println(table.listByProtonN());
        MoleculeSame vodikM = new MoleculeSame(table.getElement("H"),2);
        MoleculeSame ozon = new MoleculeSame(table.getElement("O"),3);
        System.out.println(vodikM.getWeight());
        System.out.println(ozon.getWeight());
    }
}
