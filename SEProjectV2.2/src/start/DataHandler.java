package start;


 import java.io.BufferedReader;
 import java.io.BufferedWriter;
 import java.io.File;
 import java.io.FileReader;
 import java.nio.file.Files;
 import java.nio.file.Path;
 import java.nio.file.Paths;
 import javax.swing.table.DefaultTableModel;

 final class DataHandler {
 	final public static String HOMEDIR = System.getProperty("user.home"); // home directory on local pc
 	final public static String NEWLINE = System.getProperty("line.separator");
 	public static String MYPATH; // path to file
 	private static String filename = "\\table_data.txt";

 	static void make_directory() {
 		MYPATH = (HOMEDIR + "\\penfactory");
 		new File(MYPATH).mkdir();

 	}

 	static void save(DefaultTableModel model) {
		File file=new File(MYPATH+filename);
		file.setWritable(true);
 		Path path = Paths.get(MYPATH + filename);
 		try (BufferedWriter writer = Files.newBufferedWriter(path)) {
 			for (int row = 0; row < model.getRowCount(); row++) {
 				String content = "";
 				for (int column = 0; column < model.getColumnCount(); column++) {
 					content += model.getValueAt(row, column).toString() + ";";

 				}
 				writer.write(content + NEWLINE);
				writer.flush();
 			}
 			writer.close();
 		} catch (Exception e) {
 			e.printStackTrace();
 		}
		file.setReadOnly(true);
 	}

 	static DefaultTableModel load() {
 		String[] columnNames = {"Produktbezeichnung", "Anzahl", "Kategorie", "Stückpreis(in Cent)","Lagernummer", "Gewicht"};
		DefaultTableModel model = new DefaultTableModel(columnNames, 0);
 		File file = new File(MYPATH + filename);
 		String line;
 		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
 			while (((line = br.readLine()) != null) && (line.length)>3) { //temporary Bug fix for final line garbage
 				String[] data = line.split(";");
 				model.addRow(data);
				br.flush();
 			}
 			br.close();
 		} catch (Exception e) {
 			e.printStackTrace();
 		}
 		return model;
 	}

 }
