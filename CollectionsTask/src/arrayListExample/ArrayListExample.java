package arrayListExample;

import java.util.ArrayList;

public class ArrayListExample {
	public static void main(String args[]){  
		  ArrayList<String> list=new ArrayList<String>();
		      list.add("Mango");
		      list.add("Apple");    
		      list.add("Banana");    
		      list.add("Grapes");    
		      System.out.println(list);  // 1.adding to list and display
		      list.remove("Mango");//2. remove elements from list
		      System.out.println(list);
		 }    
}  

