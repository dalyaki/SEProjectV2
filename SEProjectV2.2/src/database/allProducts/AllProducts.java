package database.allProducts;

import java.util.ArrayList;

import database.shelf.Shelf;
import database.singleProduct.Product;

public class AllProducts { //The Class of the Full Database
	
	public ArrayList<Shelf> shelfs = new ArrayList<Shelf>(); //TODO change to private (use getter/setter)
	
	public AllProducts() {
		for (int ii=0; ii<999; ii++) {
			Shelf newShelf = new Shelf();
			shelfs.add(newShelf);
		}
		try{
			loadFile();
		} catch (Exception e) { 
			//TODO
		}
	}
	
	public void addProduct2(int shelfNr, Product p) throws Exception{

		try{
			testNewProduct(p);// Test Syntax
			shelfs.get(shelfNr).addProduct(p);//Weight Tests in ShelfTests Class
			
		} catch (Exception e) {}
	}
	
	public void changeProduct(Product oldVersion, Product newVersion, int oldShelfNr, int newShelfNr) throws Exception {

		try {
			shelfs.get(oldShelfNr).removeProduct(oldVersion);
			addProduct2(newShelfNr, newVersion);		
			} catch(Exception e) {throw e;}
	}
	
	public static ArrayList<Integer> addProduct(String description, String newCategory, String stocknumber, String weight, String price, String quantity) {
	    //check if Input is valid
	    boolean descriptionOK = false;
	    boolean newCategoryOK = false;
	    boolean stocknumberOK = false;
	    boolean priceOK = false;
	    boolean weightOK = false;
	    boolean quantityOK = false;
	    ArrayList<Integer> Fehlermeldungen = new ArrayList<Integer>();
	    
	    //descriptionOK
	    int desc = checkProductname(description);
	    if (desc == 0) {descriptionOK = true;}
	    if (desc == 1) {Fehlermeldungen.add(1);}
	    if (desc == 2) {Fehlermeldungen.add(11);}

	    //newCategoryOK   
	    int cat = checkCategoryname(newCategory);
	    if (cat == 0) {newCategoryOK = true;}
	    if (cat == 1) {Fehlermeldungen.add(2);}
	    if (cat == 2) {Fehlermeldungen.add(22);}
	        
	    //stocknumberOK
	    int sto = checkStocknumber(stocknumber);
	    if (sto == 0) {stocknumberOK = true;}
	    if (sto == 1) {Fehlermeldungen.add(3);}
	    if (sto == 2) {Fehlermeldungen.add(4);}
	    
	    //priceOK
	    int pri = checkPrice(price);
	    if (pri == 0) {priceOK = true;}
	    if (pri == 1) {Fehlermeldungen.add(5);}
	    
	    //weightOK
	    int wei = checkWeight(weight);
	    if (wei == 0) {weightOK = true;}
	    if (wei == 1) {Fehlermeldungen.add(6);}
	    
	    //quantityOK
	    int qua = checkQuantity(quantity);
	    if (qua == 0) {quantityOK = true;}
	    if (qua == 1) {Fehlermeldungen.add(7);}

	    

	    System.out.println(Fehlermeldungen);
	    
	    System.out.println(descriptionOK);
	    System.out.println(newCategoryOK);
	    System.out.println(stocknumberOK);
	    System.out.println(priceOK);
	    System.out.println(weightOK);
	    System.out.println(quantityOK); 
	    
	    if (descriptionOK&newCategoryOK&stocknumberOK&priceOK&weightOK &quantityOK == true) {
	      //System.out.println(description + weight + price+ newCategory+ stocknumber+ quantity);
	      Fehlermeldungen.add(0);
	    }
	    return Fehlermeldungen;
	  }

	  
	  
	  static int checkProductname(String name) {
	    //List<Character> Zeichen = new List<Character>();
	    ArrayList<Character> Zeichen = new ArrayList<Character>();
	    Zeichen.add('a'); Zeichen.add('b'); Zeichen.add('c'); Zeichen.add('d'); Zeichen.add('e'); Zeichen.add('f');
	    Zeichen.add('g'); Zeichen.add('h'); Zeichen.add('i'); Zeichen.add('j'); Zeichen.add('k'); Zeichen.add('l'); 
	    Zeichen.add('m'); Zeichen.add('n'); Zeichen.add('o'); Zeichen.add('p'); Zeichen.add('q'); Zeichen.add('r');
	    Zeichen.add('s'); Zeichen.add('t'); Zeichen.add('u'); Zeichen.add('v'); Zeichen.add('w'); Zeichen.add('x');
	    Zeichen.add('y'); Zeichen.add('z');
	    Zeichen.add('A'); Zeichen.add('B'); Zeichen.add('C'); Zeichen.add('D'); Zeichen.add('E'); Zeichen.add('F');
	    Zeichen.add('G'); Zeichen.add('H'); Zeichen.add('I'); Zeichen.add('J'); Zeichen.add('K'); Zeichen.add('L');
	    Zeichen.add('M'); Zeichen.add('N'); Zeichen.add('O'); Zeichen.add('P'); Zeichen.add('Q'); Zeichen.add('R');
	    Zeichen.add('S'); Zeichen.add('T'); Zeichen.add('U'); Zeichen.add('V'); Zeichen.add('W'); Zeichen.add('X');
	    Zeichen.add('Y'); Zeichen.add('Z');
	    Zeichen.add('0'); Zeichen.add('1'); Zeichen.add('2'); Zeichen.add('3'); Zeichen.add('4'); Zeichen.add('5');
	    Zeichen.add('6'); Zeichen.add('7'); Zeichen.add('8'); Zeichen.add('9');
	    Zeichen.add('-'); Zeichen.add('!'); Zeichen.add('?'); Zeichen.add('.'); Zeichen.add('('); Zeichen.add(')');
	    
	    //char[] chara = name.toCharArray();
	    for (char ch: name.toCharArray()) {
	      if (Zeichen.contains(ch) == false) return 2; //wrong character  
	    }
	    if (name.length() > 256 | name.length() <= 1) {return 1;}
	    else return 0;
	  } 
	  
	  static int checkCategoryname(String name) {
	    //List<Character> Zeichen = new List<Character>();
	    ArrayList<Character> Zeichen = new ArrayList<Character>();
	    Zeichen.add('a'); Zeichen.add('b'); Zeichen.add('c'); Zeichen.add('d'); Zeichen.add('e'); Zeichen.add('f');
	    Zeichen.add('g'); Zeichen.add('h'); Zeichen.add('i'); Zeichen.add('j'); Zeichen.add('k'); Zeichen.add('l'); 
	    Zeichen.add('m'); Zeichen.add('n'); Zeichen.add('o'); Zeichen.add('p'); Zeichen.add('q'); Zeichen.add('r');
	    Zeichen.add('s'); Zeichen.add('t'); Zeichen.add('u'); Zeichen.add('v'); Zeichen.add('w'); Zeichen.add('x');
	    Zeichen.add('y'); Zeichen.add('z');
	    Zeichen.add('A'); Zeichen.add('B'); Zeichen.add('C'); Zeichen.add('D'); Zeichen.add('E'); Zeichen.add('F');
	    Zeichen.add('G'); Zeichen.add('H'); Zeichen.add('I'); Zeichen.add('J'); Zeichen.add('K'); Zeichen.add('L');
	    Zeichen.add('M'); Zeichen.add('N'); Zeichen.add('O'); Zeichen.add('P'); Zeichen.add('Q'); Zeichen.add('R');
	    Zeichen.add('S'); Zeichen.add('T'); Zeichen.add('U'); Zeichen.add('V'); Zeichen.add('W'); Zeichen.add('X');
	    Zeichen.add('Y'); Zeichen.add('Z');
	    Zeichen.add('0'); Zeichen.add('1'); Zeichen.add('2'); Zeichen.add('3'); Zeichen.add('4'); Zeichen.add('5');
	    Zeichen.add('6'); Zeichen.add('7'); Zeichen.add('8'); Zeichen.add('9');
	    
	    //char[] chara = name.toCharArray();
	    for (char ch: name.toCharArray()) {
	      if (Zeichen.contains(ch) == false) return 2; //wrong character  
	    }
	    if (name.length() > 256 | name.length() <= 1) {return 1;}
	    else return 0;
	  } 
	  
	  static int checkStocknumber(String Stocknumber) {
	    try {
	      int x = Integer.parseInt(Stocknumber);
	      if (Stocknumber.length() == 6) return 0;
	      else return  1;// else: Zahl zu groß  
	      }
	    catch(NumberFormatException ee) {
	      return 2; //print: keine Buchstaben   
	    }
	  }
	  
	  public static int checkPrice(String price)  {
	    String[] teil = price.split(",");
	    if (teil.length == 2) {
	      String i = teil[0];
	      String a = teil[1];
	      
	      try {
	        int inti = Integer.parseInt(i);
	        int inta = Integer.parseInt(a);
	        if ((i.length() <= 5) & (a.length() <= 2)) { return 0;}
	        else return 1;
	      }
	      catch(NumberFormatException ee) {
	        return 1;
	      }
	    }
	    else if (teil.length == 1) {
	      String u = teil[0];   
	      try {
	        int intu = Integer.parseInt(u);
	        if (u.length() <= 5) { return 0;}
	        else return 1;
	      }
	      catch(NumberFormatException ee) {
	        return 1;
	      }
	      
	    }
	    else return 1;
	  }
	  
	  public static int checkWeight(String weight)  {  //Input in kg
	    String[] teil = weight.split(",");
	    if (teil.length == 2) {
	      String i = teil[0];
	      String a = teil[1];
	      
	      try {
	        int inti = Integer.parseInt(i);
	        int inta = Integer.parseInt(a);
	        if ((i.length() <= 5) & (a.length() <= 4)) { return 0;}
	        else return 1;
	      }
	      catch(NumberFormatException ee) {
	        return 1;
	      }
	    }
	    else if (teil.length == 1) {
	      String u = teil[0];   
	      try {
	        int intu = Integer.parseInt(u);
	        if (u.length() <= 4 | u == "10000") { return 0;}
	        else return 1;
	      }
	      catch(NumberFormatException ee) {
	        return 1;
	      }
	      
	    }
	    else return 1;
	  }
	  
	  static int checkQuantity(String quantity) {
	    try {
	      int zahl2 = Integer.parseInt(quantity);
	      if (zahl2 <= 100000000) return 0;
	      else return 1;// else: Zahl zu groß 
	      }
	    catch(NumberFormatException ee) {
	      return 1; //print: keine Buchstaben   
	    }
	  }
	  
	  //a
	  
	public static int parseToInt (String a) {
		String[] teil = a.split(",");
		String ganz = "";
		for(int i = 0;i<(teil.length);i++) {
			ganz = ganz + teil[i];
		}
		int zahl = Integer.parseInt(ganz);
		return zahl;
	}
	  

	
	
	private Boolean testNewProduct(Product p) throws Exception{
		//TODO
		return true;
	}
	
	public void saveFile() {
		//TODO
	}
	
	private void loadFile() throws Exception {
		//TODO
	}
	
	
	
	
	
	
	/*public void save() {				
		// for testing
		try {
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm");
			FileWriter writer = new FileWriter(formatter.format(new Date()));
			// save to specific file
			//FileWriter writer = new FileWriter("specificfile");
			for (Product p : data) {
				writer.write(p.getDescription() + "\n");
				writer.write(p.getCategory() + "\n");
				writer.write(p.getQuantity() + "\n");
				writer.write(p.getWeight() + "\n");
				writer.write(p.getPrice() + "\n");
				writer.write(p.getStockNumber() + "\n");
			}
			writer.close();
		}
		catch (IOException e) {
			System.out.println("got it:\n" + e.getMessage());
		}	
	} //save*/
}
