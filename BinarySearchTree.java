import java.util;
public class BinarySearchTree {
        public Node root;
        
        /**
         * Constructs an empty binary search tree.
         */
        public BinarySearchTree() {
           root = null;
        }
        private boolean add(Node node, Node currentroot){
            if(node.value<currentroot.value){
                if(currentroot.less==null){
                    currentroot.less = node;
                    return true;
                }
                else{
                add(node,currentroot.less);
                }
            }
            else if(node.value>currentroot.value){
                if(currentroot.greater==null){
                    currentroot.greater = node;
                    return true;
                }
                else{
                add(node,currentroot.greater);
                }
            }
            else if(node.value==currentroot.value){
                return false;
            }
        }
        /**
         * Adds an element into the tree.
         * 
         * @param value The element to be inserted in the tree.
         * 
         * @return True if the element was inserted; false if the value was already present.
         */
        public boolean add(int value) {
            Node temp = new Node(value, null, null);
    
            if(root == null) {
                root = temp;
    
                return true;
            }
            else {
                //TODO: Implement this helper method
                return add(temp, root);
                return false;
            }
        }
    
        /**
         * Returns true if the value is contained in the tree.
         * 
         * @param value Value to be searched in the tree.
         * 
         * @return True if the value is contained in the tree.
         */
        public boolean contains(int value) {
            //TODO: Implement this helper method
            //return contains(value, root);
            return false;
        }

        private boolean contains(int value, Node currentRoot){
            if(currentRoot==null){
                return false;
            }
            else if(value==currentRoot.value){
                return true;
            }
            else if(value<currentRoot.value){
                contains(value, currentRoot.less);
            }
            else if(value>currentRoot.value){
                contains(value,currentRoot.greater);
            }
        }
    
        /**
         * Returns the minimum value of the tree.
         * 
         * @return The minimum value of the tree, or -1 if the tree is empty.
         */
        public int minimumValue() {
            if(root == null) {
                return -1;
            }
    
            //TODO: Find the minimum element recursively in the left tree
            //      and then return its value
            return -1;
        }
    
        /**
         * Returns the maximum value of the tree.
         * 
         * @return The maximum value of the tree, or -1 if the tree is empty.
         */
        public int maximumValue() {
            if(root == null) {
                return -1;
            }
    
            //TODO: Find the maximum element recursively in the right tree
            //      and then return its value
            return -1;
        }
    
        /**
         * Removes an element from the tree.
         * 
         * @param value Value to be removed from the tree.
         * 
         * @return True if the value was removed; false if the value was not found.
         */
        public boolean remove(int value) {
            //TODO: Implement this helper method
            //return remove(value, root, null);
            return false;
        }
    
        public static void main(String args[]) {
            /*
            BinarySearchTree tree = new BinarySearchTree();
            
            System.out.println("Minimum: " + tree.minimumValue());
            System.out.println("Maximum: " + tree.maximumValue());
            
            System.out.println("Contains 5: " + tree.contains(5));
            
            System.out.println("Adding 5: " + tree.add(5));
            
            System.out.println("Contains 5:" + tree.contains(5));
    
            System.out.println("Adding 3: " + tree.add(3));
            System.out.println("Adding 7: " + tree.add(7));
            
            System.out.println("Minimum: " + tree.minimumValue());
            System.out.println("Maximum: " + tree.maximumValue());
            
            System.out.println("Adding 1: " + tree.add(1));
            System.out.println("Adding 4: " + tree.add(4));
    
            System.out.println("Removing 9:" + tree.remove(9));
    
            System.out.println("Removing 3:" + tree.remove(3));
            System.out.println("Removing 4:" + tree.remove(4));
            System.out.println("Removing 1:" + tree.remove(1));
            
            */
        }
    }
}
