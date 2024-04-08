class Node{
	/**
     * Constructor to initialize a Node with a given value.
     * @param value The value of the node.
     */
	   int value;
	   Node left, right;
	   
	   public Node(int value){
	      this.value = value;
	      left = null;
	      right = null;
	   }

	}

	class BinarySearchTree{

	   Node root;
	  
	   
	   /*
	   recursive insert method
		
	   */
	   /**
	   inserts a node into the tree
	    @param value The value to be inserted into the tree.
	   */
	   public void insert(int value){
	      //tree is empty
	      if(root == null){
	         root = new Node(value);
	         return;
	      }else{
	         Node current = root;
	         Node parent = null;
	         
	         while(true){
	            parent = current;
	            
	            if(value < current.value){
	               current = current.left;
	               if(current == null){
	                  parent.left = new Node(value);
	                  return;
	               }
	            }else{
	               current = current.right;
	               if(current == null){
	                  parent.right = new Node(value);
	                  return;
	               }
	            }
	           
	         }//closing while
	      
	      }//closing main if-else 
	   }
	   
	   /**
	     * Performs pre-order traversal of the binary search tree.
	     * Prints the value of every node in preorder.
	     * @param root The root of the subtree to be traversed.
	     */
	   public void preOrderTraversal(Node root){
		
		   if (root != null) {
	            System.out.print(root.value + " ");
	            preOrderTraversal(root.left);
	            preOrderTraversal(root.right);
	        }
	   }


	   
	   
	   /**
	     * Performs in-order traversal of the binary search tree.
	     * @param root The root of the subtree to be traversed.
	     */
	   public void inOrderTraversal(Node root){
		   if(root != null) {
	            inOrderTraversal(root.left);
	            System.out.print(root.value + " ");
	            inOrderTraversal(root.right);
	        }
		
	   }
	   
	   
	   
	   
	   /**
	     * Performs post-order traversal of the binary search tree.
	     * @param root The root of the subtree to be traversed.
	     */
	  
	   public void postOrderTraversal(Node root){
   
		   if (root != null) {
			   postOrderTraversal(root.left);
			   postOrderTraversal(root.right);
			   System.out.print(root.value + " ");
		   }
		   
	   }
	   
	   
	   
	  /**
	     * Searches for a node with a specific value in the binary search tree.
	     * @param root The root of the subtree to search in.
	     * @param key The value to search for.
	     * @return true if the key is found in the tree, otherwise false.
	     */
	   public boolean find(Node root, int key){
		 //implement in here
		  if (root == null) {
			  return false;
		  }
		  if(root.value == key) {
			  return true;
		  }
		  if (key < root.value) {
			  return find(root.left,key);
		  }else {
			  return find (root.right,key);
		  }
	   }
	   
	   
	   
	   
	 /**
	     * Finds the node with the smallest value in the binary search tree.
	     * @param root The root of the subtree to search in.
	     * @return The smallest value in the tree.
	     */
	   public int getMin(Node root){
      //implement in here
		   if (root.left == null) {
			   return root.value;
			   
		   }else {
			   return getMin(root.left);
		   }
	      
	   }
	  
	  
	  
	   /**
	     * Finds the node with the largest value in the binary search tree.
	     * @param root The root of the subtree to search in.
	     * @return The largest value in the tree.
	     */
	   public int getMax(Node root){
      //implement in here
		   if(root.right == null) {
			   return root.value;
		   }else {
			   return getMax(root.right);
		   }
	   }
	   
	   
	   
	  /**
     * Deletes a node with a specific value from the binary search tree.
     * @param root The root of the subtree to delete from.
     * @param key The value of the node to be deleted.
     * @return The root of the modified subtree after deletion.
     */
	   public Node delete(Node root, int key){
	      
	      if(root == null){
	         return root;
	      }else if(key < root.value){
	         root.left = delete(root.left, key);
	      }else if(key > root.value){
	         root.right = delete(root.right, key);
	      }else{
	         //node has been found
	         if(root.left==null && root.right==null){
	            //case #1: leaf node
	            root = null;
	         }else if(root.right == null){
	            //case #2 : only left child
	            root = root.left;
	         }else if(root.left == null){
	            //case #2 : only right child
	            root = root.right;
	         }else{
	            //case #3 : 2 children
	            root.value = getMax(root.left);
	            root.left = delete(root.left, root.value);
	         }
	      }
	      return root;  
	   }
	   
	   
	   
	}



	public class TreeDemo{
	   public static void main(String[] args){
	      BinarySearchTree t1  = new BinarySearchTree();
	      t1.insert( 24);
	      t1.insert(80);
	      t1.insert(18);
	      t1.insert(9);
	      t1.insert(90);
	      t1.insert(22);
	            
	      System.out.print("in-order :   ");
	      t1.inOrderTraversal(t1.root);
	      System.out.println();
	           
	      
	   }  
	}
