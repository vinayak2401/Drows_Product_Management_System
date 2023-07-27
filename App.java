package JDBC.PMS;

import java.sql.SQLException;
import java.util.Scanner;
import com.pms.dao.ProductDao;
import com.pms.dao.ProductDaoImpl;
import com.pms.dao.SaleDaoImpl;
import com.pms.dao.SupplierDaoImpl;
import com.pms.entity.Product;
import com.pms.entity.Sale;
import com.pms.entity.Supplier;

public class App {
    public static void main(String[] args) throws SQLException {
        Scanner s = new Scanner(System.in);
        int take;
        System.out.println("==========Drow's Product Management System==========");
        System.out.println("\nEnter role:(Admin/Supplier/User)");
        String role = s.next();
        
        if (role.equalsIgnoreCase("admin")) {
        	
			do {
            System.out.println("\n1. Add Supplier and Sale info");
            System.out.println("2. Update Supplier and Sale info");
            System.out.println("3. Search Product, Supplier, Sale info");
            System.out.println("4. Sort Product");
            System.out.println("5. Delete Supplier");
            System.out.println("6. Exit");

            System.out.println("Enter your choice");

             take = s.nextInt();
        	

            
                ProductDao dao = new ProductDaoImpl();
                SupplierDaoImpl dao1 = new SupplierDaoImpl();
                SaleDaoImpl dao2 = new SaleDaoImpl();

                switch (take) {
                    case 1: {
                    	System.out.println("\nEnter Supplier/Sale");
                    	String b=s.next();
                    	if(b.equalsIgnoreCase("Supplier")) {
                    		System.out.println("Enter Supplier details (supplier_id, name, phone_no, email, address)");
                            Supplier sup = new Supplier(s.nextInt(), s.next(), s.next(), s.next(), s.next());
                            try {
                                boolean supplierAdded = dao1.addSupplier(sup);
                                if (supplierAdded) {
//                                  dao.addProduct(pru);
                                  System.out.println("Supplier info Added");
                              } else {
                                  System.out.println("Not added");
                              }
                          } catch (Exception e) {
                              System.out.println(e);
                          }
                    	}else if(b.equalsIgnoreCase("Sale")) {
                    		System.out.println("Enter Sale details (sale_id, date, quantity, total_revenue, p_id)");
                            Sale sal = new Sale(s.nextInt(), s.next(), s.nextInt(), s.nextDouble(), s.nextInt());
                    	try {
                    		 boolean saleAdded = dao2.addSale(sal);
                    		 if(saleAdded) {
                    			 System.out.println("Sale info Added");
                    		 }else {
                    			 System.out.println("Not added"); 
                    		 }
                    	}catch(Exception e) {
                    		System.out.println(e);
                    	}
                    	}else {
                    		System.out.println("Invalid choice");
                    	}
                        
                       
                       

                          
                       // System.out.println("Enter Product details (name, description, quantity, price, supplier_id, p_id)");
//                        Product pru = new Product(s.next(), s.next(), s.nextInt(), s.nextDouble(), s.nextInt(), s.nextInt());
                        

                       
                        break;
                    }
                    case 2: {
                        try {
                        	System.out.println("Enter name to update in supplier:");
                            dao1.updateSupplier(s.next());
                            System.out.println("Enter quantity to update in sale:");
                            dao2.updateSale(s.nextInt());
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                        break;
                    }
                    case 3: {
                        try {
                        	System.out.println("Enter Product/Supplier/Sale");
                        	String check=s.next();
                        	if(check.equalsIgnoreCase("product")) {
                        		dao.searchProduct();
                        	}else if(check.equalsIgnoreCase("supplier")) {
                        		 dao1.searchSupplier();
                        	}else if(check.equalsIgnoreCase("Sale")) {
                        		dao2.searchSale();
                        	}else {
                        		System.out.println("Invalid choice");
                        	}
                            
                           
                            
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                        break;
                    }
                    case 4: {
                        try {
                            dao.sortProduct();
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                        break;
                    }
                    case 5:{
                        try {
                        	System.out.println("\nEnter Product/Supplier to delete");
                        	String choice1=s.next();
                        	if(choice1.equalsIgnoreCase("product")) {
                        		System.out.println("Enter supplier_id to delete:");
                                dao.deleteProduct(s.nextInt());
                        	}else if(choice1.equalsIgnoreCase("supplier")) {
                        		System.out.println("Enter supplier_id to delete:");
                                dao1.deleteSupplier(s.nextInt());
                        	}else {
                        		System.out.println("Invalid choice");
                        	}
                        	
                            
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                        break;
                    }
                    case 6: {
                        System.out.println("Thank you");
                        break;
                    }
                    default: {
                        System.out.println("Invalid choice");
                        break;
                    }
                }
            
        }while(take!=6);
//            else {
//                System.out.println("Invalid choice");
//            }
//        

        }
        
   
        else if (role.equalsIgnoreCase("Supplier")) {
        	
			do {
            System.out.println("\n1. Add Product");
            System.out.println("2. Update Product");
            System.out.println("3. Search Product, Supplier");
            System.out.println("4. Sort Product");
            System.out.println("5. Exit");
            System.out.println("Enter your choice");
             take = s.nextInt();
            
                ProductDao dao = new ProductDaoImpl();
                SupplierDaoImpl dao1 = new SupplierDaoImpl();
                SaleDaoImpl dao2 = new SaleDaoImpl();

                switch (take) {
                    case 1: {
                    	System.out.println("Enter Supplier details (supplier_id, name, phone_no, email, address)");
                        Supplier sup = new Supplier(s.nextInt(), s.next(), s.next(), s.next(), s.next());
                        System.out.println("Enter Product details (name, description, quantity, price, supplier_id, p_id)");
                        Product pru = new Product(s.next(), s.next(), s.nextInt(), s.nextDouble(), s.nextInt(), s.nextInt());
//                        System.out.println("Enter Sale details (sale_id, date, quantity, total_revenue, p_id)");
//                        Sale sal = new Sale(s.nextInt(), s.next(), s.nextInt(), s.nextDouble(), s.nextInt());

                        try {
                            boolean result = dao.addProduct(pru);

                            if (result) {
                                System.out.println("Added");
                            } else {
                                System.out.println("Not added");
                            }
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                        break;
                    }
                    case 2: {
                        try {
                        	System.out.println("Enter name to update:");
                            dao.updateProduct(s.next());
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                        break;
                    }
                    case 3: {
                        try {
                        	System.out.println("\nEnter Product/Supplier");
                        	String choice2=s.next();
                        	if(choice2.equalsIgnoreCase("Product")) {
                        		dao.searchProduct();
                        	}else if(choice2.equalsIgnoreCase("Supplier")) {
                        		dao1.searchSupplier();
                        	}else {
                        		System.out.println("Invalid choice");
                        	}
                            
                            
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                        break;
                    }
                    case 4: {
                        try {
                            dao.sortProduct();
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                        break;
                    }

                    case 5: {
                        System.out.println("Thank you");
                        break;
                    }
                    default: {
                        System.out.println("Invalid choice");
                        break;
                    }
                }
//            } else {
//                System.out.println("Invalid choice");
//            }
        	}while(take!=5);
        } else {
        	
        	do {
            System.out.println("\n1. Search Product");
            System.out.println("2. Sort Product");
            System.out.println("3. Search Supplier");
            System.out.println("4. Exit");
            take=s.nextInt();
           
                ProductDao dao = new ProductDaoImpl();
                SupplierDaoImpl dao1 = new SupplierDaoImpl();

                switch (take) {
                    case 1: {
                        try {
                            dao.searchProduct();
                            dao1.searchSupplier();
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                        break;
                    }
                    case 2: {
                        try {
                            dao.sortProduct();
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                        break;
                    }
                    case 3:{
                        try {
                            dao1.searchSupplier();
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                        break;
                    }
                    case 4:{
                    	System.out.println("Thank You");
                    	break;
                    }
                    default: {
                        System.out.println("Invalid choice");
                        break;
                    }
                }
            
        }while(take!=4);
        
        }
    }
}
