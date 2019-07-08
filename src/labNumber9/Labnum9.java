package labNumber9;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Labnum9 {
	


	    public static void printMenu( HashMap<String ,Double> menuItems){
	        //getting the menu items in a set that we can loop over
	        Set<String> items = menuItems.keySet();
	        
	        System.out.println("Welcome to Guenther's Market! \n");
	        System.out.println( "Item               Price");
			System.out.println("====================================");
			
			//looping over the entire menu
			for (String item : items){
			    System.out.printf("%-15s   $%.2f\n", item, menuItems.get(item));
			}
	        
	        System.out.println();
	        
	    }


	    //find the average price from the purchased items
	    public static double averagePrice(List<Double> prices){
	        double sum = 0.0;
	        
	        for(int i = 0; i< prices.size(); i++){
	            sum += prices.get(i);
	        }
	        
	        return sum / prices.size();
	    }
	    
	    //find the maximum price from the purchased items
	    public static double maxPrice(List<Double> prices){
	        double max = 0.0;
	        
	        for(int i = 0; i< prices.size(); i++){
	            if(prices.get(i) > max)
	                max = prices.get(i);
	        }
	        
	        return max;
	    }
	    
	    //find the minimum price from the purchased items
	    public static double minPrice(List<Double> prices){
	        double min = 0.0;
	        
	        if(prices.size() > 0){
	            min = prices.get(0);
	        }
	        
	        for(int i = 1; i< prices.size(); i++){
	            if(prices.get(i) < min)
	                min = prices.get(i);
	        }
	        
	        return min;
	    }


		public static void main(String[] args) {
			 
			 HashMap<String ,Double> Items = new HashMap<>();
			
			 Scanner scnr = new Scanner(System.in);
			 
			 List<String> OrderedItems = new ArrayList<>();
			 List<Double> OrderedPrices = new ArrayList<>();
			 
			 Items.put("Apple", 0.99);
			 Items.put("banana", 0.59);
			 Items.put("cauliflower", 1.59);
			 Items.put("dragonfruit", 2.19);
			 Items.put("Elderberry", 1.79);
			 Items.put("figs", 2.09);
			 Items.put("grapefruit", 1.99);
			 Items.put("honeydew", 3.49);
			 
			 try{
			 
	    		 boolean contin = true;
	    		 
	    		 while(contin){
	        		 
	        		 printMenu(Items);
	        		 
	        		 boolean Valid = false;
	        		 String UserChoice = "";
	        		 
	        		 System.out.print("Please enter an Item name: ");
	        		 UserChoice = scnr.next();
	        		 System.out.println();
	        		 
	        		 Set<String> itemNames = Items.keySet();
	        		 for(String item : itemNames){
	        		     if(item.equalsIgnoreCase(UserChoice)){
	        		         UserChoice = item;
	        		         Valid = true;
	        		     }
	        		 }
	        		 
	        		 if(! Valid){
	        		     System.out.println("Sorry we don't have those. Please try again.\n");
	        		 }
	        		 
	        		 else{
	        		     double choicePrice = Items.get(UserChoice);
	        		     System.out.printf("Adding %s to cart at $%.2f\n", UserChoice,choicePrice);
	        		     OrderedItems.add(UserChoice);
	        		     OrderedPrices.add(choicePrice);
	        		     
	        		     System.out.print("Would you like to order anything else (y/n) ? ");
	        		     UserChoice = scnr.next();
	        		     
	        		    System.out.println();
	        		 
	        		     if(UserChoice.equalsIgnoreCase("y")){
	        		         contin = true;
	        		     }
	        		     else{
	        		         contin = false;
	        		     }
	        		     
	        		 }
	        		 
	    		 }
	    		 
	    		 scnr.close();
	    		 
			 } catch (Exception e){
			     
			     System.out.println("ERROR - exception caught! Shopping Menu closing.\n");
			 }
			 
			 //user ended loop
			 System.out.println("Thanks for your order!\nHere's what you got:");
			 
			 for(int i = 0; i < OrderedItems.size(); i++){
			     
	            System.out.printf("%-15s   $%.2f\n", 
	                OrderedItems.get(i), OrderedPrices.get(i));
			     
			 }
			 
			 double aver = averagePrice(OrderedPrices);
			 System.out.printf("Average price per item in the order was $%.2f\n", aver);
			 double max = maxPrice(OrderedPrices);
			 System.out.printf("Maximum price for an item in the order was $%.2f\n", max);
			 double min = minPrice(OrderedPrices);
			 System.out.printf("Minimum price for an item in the order was $%.2f\n", min);
			 
			 
		}
		
		
		
	    

	}




