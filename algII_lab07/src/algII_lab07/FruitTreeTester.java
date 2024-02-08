//Lea Frost
package algII_lab07;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class FruitTreeTester {
	public static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		LinkedBST<Fruit> tree = new LinkedBST<Fruit>();
		System.out.println("Welcome to the fruit tree!\nEnter the file name to be read:");
		String file = scan.nextLine();
		try {
			Scanner fileScanner = new Scanner(new FileInputStream(file));
			while(fileScanner.hasNextLine())
			{
				String[] line = fileScanner.nextLine().split("\t");
				Fruit fruit = new Fruit(line[0], Double.parseDouble(line[1]));
				tree.add(fruit);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("Populating tree file...\nPrinting the In-Order traversal");
		tree.printInorder();
		System.out.println("\nPrinting the Pre-Order traversal");
		tree.printPreorder();
		System.out.println("\nPrinting the Post-Order traversal");
		tree.printPostorder();
		System.out.println("\nRemoving Apple 0.4859853412170728\nPrinting In-Order traversal");
		Fruit fruit = new Fruit("Apple", 0.4859853412170728);
		tree.remove(fruit);
		tree.printInorder();
		
		

	}

}
