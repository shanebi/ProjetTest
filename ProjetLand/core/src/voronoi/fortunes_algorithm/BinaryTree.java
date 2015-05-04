package voronoi.fortunes_algorithm;

import java.util.Comparator;

/**
 * This class represents a simple binary tree for use in the algorithm.
 * It makes use of a generic comparator to decide where in the tree new nodes should be placed.
 */
public class BinaryTree<T> {
	/**
	 * The root of the tree.
	 */
	private Node root;
	
	/**
	 * The comparator to use for the tree.
	 */
	private Comparator<T> comparator;
	
	/**
	 * Internal node class to represent traversal of the tree.
	 */
	public class Node {
		/**
		 * The left side of the node.
		 */
		Node left; 
		
		/**
		 * The right side of the node.
		 */
		Node right;
		
		/**
		 * The data element that this node stores
		 */
		T data;
		 
		public Node(T data) {
			this.left = null;
			this.right = null;
			this.data = data;
		}
	}
	
	/**
	 * Make a new tree based on the data element given and the comparator provided.
	 * 
	 * @param root the data element at the root of the tree
	 * @param comparator the comparator to use when inserting new elements into the tree
	 */
	public BinaryTree(T root, Comparator<T> comparator) {
		this.root = new Node(root);
		this.comparator = comparator;
	}
	
	/**
	 * Insert the given data element into the tree.
	 * 
	 * @param element the element to insert
	 */
	public void insert(T element) {
		insert_under(element, this.root);
	}
	
	/**
	 * Insert this element under the given node.
	 * 
	 * @param element the element to insert
	 * @param node the node to insert under
	 */
	private void insert_under(T element, Node node) {
		int comparison = this.comparator.compare( element, node.data);
		
		// New element less than the test node, insert on the left
		if(comparison == -1) {
			if(node.left == null) {
				node.left = new Node(element);
			} else {
				insert_under(element, node.left);
			}
		} else {
			if(node.right == null) {
				node.right = new Node(element);
			} else {
				insert_under(element, node.right);
			}
		}
	}
}
