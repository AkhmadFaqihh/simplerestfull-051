/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws.b.project04;

/**
 *
 * @author mwllf
 */
public class Product {
    
    private String Id;
    private String Name;
    private int Price;
    private int Number;
    private int TotalBuy;

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }
    
    public int getPrice(){
        return Price;
    }
    
    public void setPrice(int Price){
        this.Price = Price;
    }
    
    public int getNumber(){
        return Number;
    }
    
    public void setNumber(int Number) {
        this.Number = Number;
    }
    
    public int getTotalBuy(){
        return TotalBuy = Price * Number;
    }
    
    public void setTotalBuy(int TotalBuy) {
        this.TotalBuy = TotalBuy;
    }

    
}

