package Jobsheet14;
public class BinaryTree11 {
    String nim, name, className;
    double ipk;
    
    public BinaryTree11(){
    }
    
    public BinaryTree11(String nm, String nama, String kls, double ip){
        nim = nm;
        name = nama;
        className = kls;
        ipk = ip;
    }
    
    void print(){
        System.out.println(nim+" - "+name+" - "+className+" - "+ipk);
    }
}

class Node00 {
    BinaryTree11 data;
    Node00 left;
    Node00 right;
    
    Node00(){
    }
    
    Node00(BinaryTree11 data){
        this.data = data;
        left = null;
        right = null;
    }
}

class BinaryTree00 {
    Node00 root;
    
    public BinaryTree00(){
        root = null;
    }
    
    public boolean isEmpty(){
        return root == null;
    }

    public void add(BinaryTree11 data){
        if(isEmpty()){
            root = new Node00(data);
        } else {
            Node00 current = root;
            while(true){
                if(data.ipk < current.data.ipk){
                    if(current.left != null){
                        current = current.left;
                    } else {
                        current.left = new Node00(data);
                        break;
                    }
                } else if(data.ipk > current.data.ipk){
                    if(current.right != null){
                        current = current.right;
                    } else {
                        current.right = new Node00(data);
                        break;
                    }
                } else {
                    break;
                }
            }
        }
    }
    
    public void addRekursif(BinaryTree11 data){
        root = addRekursifHelper(root, data);
    }
    
    private Node00 addRekursifHelper(Node00 node, BinaryTree11 data){
        if(node == null){
            return new Node00(data);
        }
        
        if(data.ipk < node.data.ipk){
            node.left = addRekursifHelper(node.left, data);
        } else if(data.ipk > node.data.ipk){
            node.right = addRekursifHelper(node.right, data);
        }
        return node;
    }
    
    public BinaryTree11 getMinIPK(){
        if(isEmpty()){
            System.out.println("Tree is empty!");
            return null;
        }
        
        Node00 current = root;
        while(current.left != null){
            current = current.left;
        }
        return current.data;
    }
    
    public BinaryTree11 getMaxIPK(){
        if(isEmpty()){
            System.out.println("Tree is empty!");
            return null;
        }
        
        Node00 current = root;
        while(current.right != null){
            current = current.right;
        }
        return current.data;
    }
    
    public void displayStudentsWithIPKAbove(double threshold){
        System.out.println("Students with IPK above " + threshold + ":");
        displayStudentsWithIPKAboveHelper(root, threshold);
    }
    
    private void displayStudentsWithIPKAboveHelper(Node00 node, double threshold){
        if(node != null){
            displayStudentsWithIPKAboveHelper(node.left, threshold);
            if(node.data.ipk > threshold){
                node.data.print();
            }
            displayStudentsWithIPKAboveHelper(node.right, threshold);
        }
    }
    
    public boolean find(double ipk){
        boolean result = false;
        Node00 current = root;
        while(current != null){
            if(current.data.ipk == ipk){
                result = true;
                break;
            } else if(ipk < current.data.ipk){
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return result;
    }
    
    public void traversePreOrder(Node00 node){
        if(node != null){
            node.data.print();
            traversePreOrder(node.left);
            traversePreOrder(node.right);
        }
    }
    
    public void traverseInOrder(Node00 node){
        if(node != null){
            traverseInOrder(node.left);
            node.data.print();
            traverseInOrder(node.right);
        }
    }
    
    public void traversePostOrder(Node00 node){
        if(node != null){
            traversePostOrder(node.left);
            traversePostOrder(node.right);
            node.data.print();
        }
    }
    
    Node00 getSuccessor(Node00 del){
        Node00 successor = del.right;
        Node00 successorParent = del;
        while(successor.left != null){
            successorParent = successor;
            successor = successor.left;
        }
        if(successor != del.right){
            successorParent.left = successor.right;
            successor.right = del.right;
        }
        return successor;
    }
    
    public void delete(double ipk){
        if(isEmpty()){
            System.out.println("Tree is empty!");
            return;
        }
        Node00 parent = root;
        Node00 current = root;
        boolean isLeftChild = false;
        while(current.data.ipk != ipk){
            parent = current;
            if(ipk < current.data.ipk){
                isLeftChild = true;
                current = current.left;
            } else {
                isLeftChild = false;
                current = current.right;
            }
            if(current == null){
                System.out.println("Couldn't find data!");
                return;
            }
        }
        if(current.left == null && current.right == null){
            if(current == root){
                root = null;
            } else if(isLeftChild){
                parent.left = null;
            } else {
                parent.right = null;
            }
        } else if(current.right == null){
            if(current == root){
                root = current.left;
            } else if(isLeftChild){
                parent.left = current.left;
            } else {
                parent.right = current.left;
            }
        } else if(current.left == null){
            if(current == root){
                root = current.right;
            } else if(isLeftChild){
                parent.left = current.right;
            } else {
                parent.right = current.right;
            }
        } else {
            Node00 successor = getSuccessor(current);
            if(current == root){
                root = successor;
            } else if(isLeftChild){
                parent.left = successor;
            } else {
                parent.right = successor;
            }
            successor.left = current.left;
        }
    }
}

class BinaryTreeArray00 {
    BinaryTree11[] data;
    int idxLast;
    
    public BinaryTreeArray00(){
        data = new BinaryTree11[10];
        idxLast = -1;
    }
    
    void populateData(BinaryTree11[] data, int idxLast){
        this.data = data;
        this.idxLast = idxLast;
    }
    
    public void add(BinaryTree11 student){
        if(idxLast == data.length - 1){
            System.out.println("Tree is full!");
            return;
        }
        
        idxLast++;
        data[idxLast] = student;
        sortArray();
    }
    
    private void sortArray(){
        for(int i = 0; i <= idxLast; i++){
            for(int j = i + 1; j <= idxLast; j++){
                if(data[i] != null && data[j] != null && 
                   data[i].ipk > data[j].ipk){
                    BinaryTree11 temp = data[i];
                    data[i] = data[j];
                    data[j] = temp;
                }
            }
        }
    }
    
    void traverseInOrder(int idxStart){
        if(idxStart <= idxLast){
            if(data[idxStart] != null){
                traverseInOrder(2 * idxStart + 1);
                data[idxStart].print();
                traverseInOrder(2 * idxStart + 2);
            }
        }
    }
    
    public void traversePreOrder(){
        System.out.println("Pre-order traversal (Array-based):");
        traversePreOrderHelper(0);
    }
    
    private void traversePreOrderHelper(int idxStart){
        if(idxStart <= idxLast){
            if(data[idxStart] != null){
                data[idxStart].print();
                traversePreOrderHelper(2 * idxStart + 1);
                traversePreOrderHelper(2 * idxStart + 2);
            }
        }
    }
}

class BinaryTreeMain00 {
    public static void main(String[] args) {
        System.out.println("=== TESTING LINKED LIST BINARY SEARCH TREE ===");
        BinaryTree00 bst = new BinaryTree00();
        bst.add(new BinaryTree11("244107020138", "Devin", "TI-1I", 3.57));
        bst.add(new BinaryTree11("244107020023", "Dewi", "TI-1I", 3.85));
        bst.add(new BinaryTree11("244107020225", "Wahyu", "TI-1I", 3.21));
        bst.add(new BinaryTree11("244107020076", "Angelina", "TI-1I", 3.54));
        
        System.out.println("\n--- Original BST (In-order traversal) ---");
        bst.traverseInOrder(bst.root);
        System.out.println("\n--- Testing Recursive Add ---");
        bst.addRekursif(new BinaryTree11("244107020223", "Andhika", "TI-1I", 3.72));
        bst.addRekursif(new BinaryTree11("244107020226", "Bima", "TI-1I", 3.37));
        System.out.println("After adding Andhika and Bima recursively:");
        bst.traverseInOrder(bst.root);
    
        System.out.println("\n--- Testing Min and Max IPK ---");
        BinaryTree11 minStudent = bst.getMinIPK();
        BinaryTree11 maxStudent = bst.getMaxIPK();
        System.out.print("Student with minimum IPK: ");
        if(minStudent != null) minStudent.print();
        System.out.print("Student with maximum IPK: ");
        if(maxStudent != null) maxStudent.print();
        System.out.println("\n--- Testing IPK Above Threshold ---");
        bst.displayStudentsWithIPKAbove(3.50);
        
        System.out.println("\n=== TESTING ARRAY-BASED BINARY TREE ===");
        BinaryTreeArray00 bta = new BinaryTreeArray00();
        
        BinaryTree11 m1 = new BinaryTree11("244107020138", "Devin", "TI-1I", 3.57);
        BinaryTree11 m2 = new BinaryTree11("244107020023", "Dewi", "TI-1I", 3.85);
        BinaryTree11 m3 = new BinaryTree11("244107020225", "Wahyu", "TI-1I", 3.21);
        BinaryTree11 m4 = new BinaryTree11("244107020076", "Angelina", "TI-1I", 3.54);
        
        BinaryTree11[] dataArray = {m1, m2, m3, m4};
        bta.populateData(dataArray, dataArray.length-1);
        
        System.out.println("\n--- Original Array Tree (In-order) ---");
        bta.traverseInOrder(0);
        System.out.println("\n--- Testing Array Add Method ---");
        bta.add(new BinaryTree11("244107020223", "Andhika", "TI-1I", 3.72));
        System.out.println("After adding Andhika:");
        bta.traverseInOrder(0);
        System.out.println("\n--- Testing Array Pre-order Traversal ---");
        bta.traversePreOrder();
        
        System.out.println("\n=== ALL ASSIGNMENTS COMPLETED ===");
    }
}

class BinaryTreeTestMain00 {
    public static void main(String[] args) {
        System.out.println("=== COMPREHENSIVE BINARY SEARCH TREE TESTING ===");
        
        BinaryTree00 bst = new BinaryTree00();
        System.out.println("\n1. Adding students using recursive method:");
        bst.addRekursif(new BinaryTree11("001", "Alice", "TI-1A", 3.75));
        bst.addRekursif(new BinaryTree11("002", "Bob", "TI-1A", 3.25));
        bst.addRekursif(new BinaryTree11("003", "Charlie", "TI-1A", 3.90));
        bst.addRekursif(new BinaryTree11("004", "Diana", "TI-1A", 3.10));
        bst.addRekursif(new BinaryTree11("005", "Eve", "TI-1A", 3.65));
        bst.addRekursif(new BinaryTree11("006", "Frank", "TI-1A", 3.45));
        
        System.out.println("\nComplete tree (In-order traversal):");
        bst.traverseInOrder(bst.root);
        
        System.out.println("\n2. Finding Min and Max IPK:");
        BinaryTree11 min = bst.getMinIPK();
        BinaryTree11 max = bst.getMaxIPK();
        System.out.print("Minimum IPK: ");
        if(min != null) min.print();
        System.out.print("Maximum IPK: ");
        if(max != null) max.print();
        
        System.out.println("\n3. Students with IPK above 3.50:");
        bst.displayStudentsWithIPKAbove(3.50);
        
        System.out.println("\n4. Students with IPK above 3.80:");
        bst.displayStudentsWithIPKAbove(3.80);
        
        System.out.println("\n5. All traversal methods:");
        System.out.println("\nPre-order:");
        bst.traversePreOrder(bst.root);
        System.out.println("\nIn-order:");
        bst.traverseInOrder(bst.root);
        System.out.println("\nPost-order:");
        bst.traversePostOrder(bst.root);
        
        System.out.println("\n6. Testing deletion:");
        System.out.println("Deleting student with IPK 3.75:");
        bst.delete(3.75);
        System.out.println("Tree after deletion:");
        bst.traverseInOrder(bst.root);
    }
}