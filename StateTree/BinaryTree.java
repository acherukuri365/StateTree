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
		keyboard = FileUtils.openToRead(DEFAULT_FILE_NAME);
	}
	
	/**
	 *	Load data from a text file
	 */
	public void loadData() {
		boolean notLine1 = false;
		while(keyboard.hasNext()) {
			// if(notLine1)
			// 	keyboard.next();
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
			notLine1 = true;
		}

		System.out.println("Loading file " + DEFAULT_FILE_NAME + "\n");
	}
	
	/**
	 * Insert State into tree
	 * @param next  State to insert
	 */
	public void insert(State next) {
		if(root == null) {
			root = new TreeNode<State>(next);
			return;
		}
			
		TreeNode<State> node = root;
		TreeNode<State> child = null;
		while(true) {
			if(next.getName().compareTo(node.getValue().getName()) < 0) {
				child = node.getLeft();
				if(child == null) {
					TreeNode<State> newNode = new TreeNode<State>(next);
					node.setLeft(newNode);
					return;
				}
				else
					node = node.getLeft();
			}
			else {
				child = node.getRight();
				if(child == null) {
					TreeNode<State> newNode = new TreeNode<State>(next);
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
	
	private void printList(TreeNode<State> node) {
		if(node == null)
			return;
		
		printList(node.getLeft());
		
		System.out.println(node.getValue() + " ");
		//~ list.add(node.getValue());
		
		printList(node.getRight());
	}
	
	
	/**
	 * Prompts user for State name to find, then starts search
	 */
	public void testFind() { //doesnt loop continuously, doesnt work
		System.out.println("\nTesting search algorithm\n");
		String state = Prompt.getString("Enter state name to search for (Q to quit)");
		System.out.println();
		TreeNode<State> node = root;
		
		while(true) {
		// 	if(node != null) {
		// 		String name = node.getValue().getName();
		// 		if(name.equalsIgnoreCase(state)) {
		// 			System.out.println("\n" + node.getValue() + "\n");
		// 			return;
		// 		}
		// 		else {
			if(node == null) {
				System.out.println("Name = " + state + "  No such state name\n");
				return;
			}
			if(state.equalsIgnoreCase(node.getValue().getName())) {
				System.out.println("\n" + node.getValue() + "\n");
				return;
			}
			if(state.compareTo(node.getValue().getName()) < 0)
				node = node.getLeft();
			else
				node = node.getRight();

					// if(node.getLeft() == null && node.getRight() == null) {
					// 	System.out.println("Name = " + state + "  No such state name\n");
					// 	return;
					// }
					// if(node.getLeft() != null && node.getLeft().getValue().getName().compareTo(state) < 0) {
					// 	node = node.getLeft();
					// }
					// else {
					// 	node = node.getRight();
					// }
				// }
			// }
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
		return loop(root);
	}
	
	private int loop(TreeNode<State> node) {
		// if(node.getLeft() == null && node.getRight() == null)
		// 	return 1;
		// if(node.getLeft() == null)
		// 	return 1 + loop(node.getRight());
		// if(node.getRight() == null)
		// 	return loop(node.getLeft()) + 1;
		
		if(node == null)
			return 0;

		return 1 + loop(node.getLeft()) + loop(node.getRight());
	}
	
	/**
	 * Clears the tree of all nodes
	 */
	public void clear() {
		root = null;
	}
	
	/**
	 * Prompts user for level of tree to print.
	 * The top level (root node) is level 0.
	 */
	public void printLevel() { //doesnt loop continuously
		System.out.println("\nTesting printLevel algorithm\n");
		int level = Integer.parseInt(Prompt.getString("Enter level value to print (-1 to quit)"));
		System.out.printf("\nLevel%5d\n", level);

		getLevel(root, level, 0);

		System.out.println("\n");
	}

	private void getLevel(TreeNode<State> node, int level, int curr) {
		if(node == null)
			return;

		getLevel(node.getLeft(), level, curr + 1);

		if(curr == level)
			System.out.print(node.getValue().getName() + " ");

		getLevel(node.getRight(), level, curr + 1);

		// if(curr == level)
		// 	System.out.println(node.getValue().getName());
		// else
		// 	return getLevel
	}
	
	
	/**
	 * Prints the highest level of the tree (root is level 0),
	 * prints "Tree empty" if empty tree
	 */
	public void testDepth() { //wrong depth
		if(root == null) {
			System.out.println("Tree empty");
			return;
		}

		System.out.println("\nDepth of the tree = " + getDepth(root, 0) + "\n\n");
	}

	public int getDepth(TreeNode<State> node, int level) {
		if(node.getValue() == null)
			return level;

		if(node.getLeft() != null)
			level = getDepth(node.getLeft(), level + 1);
		else if(node.getRight() != null)
			level = getDepth(node.getRight(), level + 1);

		return level;
	}

}
