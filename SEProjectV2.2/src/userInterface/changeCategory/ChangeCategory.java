package userInterface.changeCategory;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class ChangeCategory extends Interface implements ActionListener{
	
	// view of the window
	public ChangeCategory (){
		super();
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(300, 250);
		this.setLocationRelativeTo(null);//Middle of screen
		this.deleteCategory.addActionListener(this);
		this.addCat.addActionListener(this);

	} 
	
	public void refreshList() {
		this.list.removeAll();
		for (String h: start.Main.categoryList) {
		       this.list.add(h);   
		}	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//changeCategory Events
		if(e.getSource() == this.deleteCategory) { //Delete Category to Database
			start.Main.categoryList.remove(this.list.getSelectedItem());
			
		} else if(e.getSource() == this.addCat) { //Add Category
			try {		
				this.addCategory(this.addCategoryTF.getText());
				//changeCategory.list.add(changeCategory.addCategoryTF.getText());
			} catch (Exception error) {
				new exceptions.Exception(error.getMessage());				
				}
			}
		this.refreshList();
		System.out.println(e.getActionCommand()+" pressed in CategoryFrame");
	}
		
	public void addCategory(String name) throws Exception{
		if (start.Main.categoryList.contains(name)) {
			throw new Exception("Category already used");
		} else {
			if (checkCategoryname(name)==0) { start.Main.categoryList.add(name);System.out.println(name + "Product added");} 
			else { throw new Exception("Invalide Eingabe");}
		}
	}

	private int checkCategoryname(String name) {
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

}
