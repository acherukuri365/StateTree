import java.util.Scanner;

/**
 * Binary Tree for State Objects
 *
 * @author 	Anirudh Cherukuri
 * @version	
 */
public class BinaryTree {

	private final String DEFAULT_FILE_NAME = "states2.txt"; // Default input file
	private Scanner keyboard;
	
	private TreeNode root;
	
	public BinaryTree() {
		root = null;
		keyboard = FileUtils.openToRead(new Scanner(DEFAULT_FILE_NAME));
	}
	
	/**
	 *	Load data from a text file
	 */
	public void loadData() {
		while(keyboard.hasNextLine()) {
			String n = keyboard.next();
			String a = keyboard.next();
			int p = Integer.parseInt(keyboard.next());
			int ar = Integer.parseInt(keyboard.next());
			int r = Integer.parseInt(keyboard.next());
			String c = keyboard.next();
			int m = Integer.parseInt(keyboard.next());
			int d = Integer.parseInt(keyboard.next());
			int y = Integer.parseInt(keyboard.next());
			State state = new State(n, a, p, ar, r, c, m, d, y);
			insert(state);
			keyboard.nextLine();
		}
	}
	
	/**
	 * Insert State into tree
	 * @param next  State to insert
	 */
	public void insert(State next) {
		if(root == null) {
			root = new TreeNode<E>(next);
			return;
		}
			
		TreeNode<E> node = root;
		TreeNode<E> child = null;
		while(true) {
			if(next.getName().compareTo(node.getValue().getName()) < 0) {
				child = node.getLeft();
				if(child == null) {
					TreeNode<E> newNode = new TreeNode<E>(next);
					node.setLeft(newNode);
					return;
				}
				else
					node = node.getLeft();
			}
			else {
				child = node.getRight();
				if(child == null) {
					TreeNode<E> newNode = new TreeNode<E>(value);
					node.setRight(newNode);
					return;
				}
				else
					node = node.getRight();
			}
		}
	}
	

	/**
	 * Prints the tree as a list in ascending order by state name
	 */
	public void printList() {
		printList(root);
	}
	
	private void printList(TreeNode<E> node) {
		if(node == null)
			return;
		
		printList(node.getLeft());
		
		System.out.println(node.getValue().getName() + " ");
		//~ list.add(node.getValue());
		
		printList(node.getRight());
	}
	
	
	/**
	 * Prompts user for State name to find, then starts search
	 */
	public void testFind() {
		String state = Prompt.getString("Enter state name to search for (Q to quit)");
		TreeNode<E> node = root;
		
		while(true) {
			if(node != null) {
				String name = node.getName();
				if(name.equalsIgnoreCase(state)) {
					System.out.println("\n" + node.getValue() + "\n");
					return;
				}
				else {
					if(node.getLeft() == null && node.getRight() == null) {
						System.out.println("Name = " + state + "  No such state name\n");
						return;
					}
					if(node.getLeft() != null && node.getLeft().getName().compareTo(state) < 0) {
						node = node.getLeft();
					}
					else {
						node = node.getRight();
					}
				}
			}
		}
	}
	

	/**
	 * Prompts user for State name to delete
	 * OPTIONAL: Not included in your grade!
	 */
	public void testDelete() {

	}
	
	/**
	 * Finds the number of nodes starting at the root of the tree
	 * @return  the number of nodes in the tree
	 */
	public int size() {
		int nodes = 0;
		
	}
	
	private int loop(TreeNode<E> node) {
		if(node == null)
			return;
		
		printList(node.getLeft());
		
		System.out.println(node.getValue().getName() + " ");
		//~ list.add(node.getValue());
		
		printList(node.getRight());
	}
	
	/**
	 * Clears the tree of all nodes
	 */
	public void clear() {

	}
	
	/**
	 * Prompts user for level of tree to print.
	 * The top level (root node) is level 0.
	 */
	public void printLevel() {

	}
	
	
	/**
	 * Prints the highest level of the tree (root is level 0),
	 * prints "Tree empty" if empty tree
	 */
	public void testDepth() {

	}

}
