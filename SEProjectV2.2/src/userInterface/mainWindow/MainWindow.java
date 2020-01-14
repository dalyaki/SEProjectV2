package userInterface.mainWindow;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

public class MainWindow extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	Layout mainLayout;
	userInterface.editProductInterface.EditProduct addI;
	userInterface.changeCategory.ChangeCategory eddI;
	
	public MainWindow() {
		super("penfactory Lagerverwaltung");
		setLayout(new BorderLayout());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(10000,10000);//=always full screen
		
		Container c = getContentPane();
		
		
		mainLayout = new Layout();
		c.add(mainLayout, BorderLayout.NORTH);
		
		mainLayout.search.addActionListener(this);
		mainLayout.addProduct.addActionListener(this);
		mainLayout.editCategory.addActionListener(this);

		
		this.setVisible(true);
	}

	
	@Override
	public void actionPerformed(ActionEvent event) {

		if(event.getSource() == mainLayout.addProduct){
			addI = new userInterface.editProductInterface.EditProduct();
			addI.addProduct.addActionListener(this);
			
		} else if(event.getSource() == mainLayout.editCategory) {
			eddI = new userInterface.changeCategory.ChangeCategory();
			eddI.deleteCategory.addActionListener(this);
			eddI.okay.addActionListener(this);
			
		} else if(event.getSource() == mainLayout.search) {
			//TODO start	
			
		} else if(event.getSource() == addI.addProduct) {
			addI.addProductToShelf();
			mainLayout.refreshTable();
			

		} else if(event.getSource() == eddI.deleteCategory) {
			//TODO deleteCategory
			
		} else if(event.getSource() == eddI.okay) {
			//TODO whatever this Button does
			
		}
		
	}
	
}
