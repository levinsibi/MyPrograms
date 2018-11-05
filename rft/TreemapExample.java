

package rft;

import java.util.*;  
class Book1 {  
int id;  
String name,author,publisher;  
int quantity;  
public Book1(int id, String name, String author, String publisher, int quantity) {  
    this.id = id;  
    this.name = name;  
    this.author = author;  
    this.publisher = publisher;  
    this.quantity = quantity;  
}  
public void show()
{
	System.out.println("id-------"+id);
}
}  
public class TreemapExample {  
public static void main(String[] args) {  
	
	
    TreeMap<String,Book1> tm=new TreeMap<String,Book1>();  
    //Creating Books  
    Book1 b1=new Book1(121,"Let us C","Yashwant Kanetkar","BPB",8);  
    Book1 b2=new Book1(233,"Operating System","Galvin","Wiley",6);  
    Book1 b3=new Book1(101,"Data Communications & Networking","Forouzan","Mc Graw Hill",4); 
    Book1 b4=new Book1(101,"Data Communications & Networking","Forouzan","Mc Graw Hill",4);  
    
    b1.show();
    //Adding Books to TreeSet  
    tm.put("1",b1);  
    tm.put("2",b2);  
    tm.put("3",b3);  
    tm.put("3",b4);
    //Traversing TreeSet  
    /*for(Book b:set){  
    System.out.println(b.id+" "+b.name+" "+b.author+" "+b.publisher+" "+b.quantity);  
    }*/ 
   
    
for(String key:tm.keySet())
{
	Book1 ob=tm.get(key);
	System.out.println(ob.id+"  "+ob.name);
}
    
for(Map.Entry<String, Book1> entry:tm.entrySet()){    
    String key=entry.getKey();  
    Book1 b=entry.getValue();  
    System.out.println(key+" Details:");  
    System.out.println(b.id+" "+b.name+" "+b.author+" "+b.publisher+" "+b.quantity);   
}    
}  
}  