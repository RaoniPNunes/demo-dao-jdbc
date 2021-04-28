
package aplication;

import java.util.Date;
import model.entities.Department;
import model.entities.Sellers;


public class Program {

    
    public static void main(String[] args) {
        
        Department obj = new Department(1, "Books");
        
        Sellers seller = new Sellers(21, "Bob", "bob@gmail.com", new Date(), 3000.0, obj);
        
        System.out.println(seller);
        System.out.println(obj);
    }
    
}
