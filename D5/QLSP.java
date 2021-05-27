/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package D5;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ocean-tor
 */
public class QLSP {
    
    
    List<Product> _lst = new ArrayList<>();
    
    public void addSP(){
        _lst.add(new Product("Dell Vostro", "PH-001", "Laptop", 1, 12000000));
        _lst.add(new Product("Iphone X", "PH-002", "Smart Phone", 1, 20000000));
        _lst.add(new Product("Iphone 11", "PH-003", "Smart Phone", 0, 20000000));
    }
    
    public boolean checkTrung(String msv){
        boolean check = false;
        for (int i = 0; i < _lst.size(); i++) {
            if (_lst.get(i).getCodeProduct().equals(msv)) {
                return true;
            }
        }
        return check;
    }
    
    public List<Product> getList(){
        return _lst;
    }
    
    
}
