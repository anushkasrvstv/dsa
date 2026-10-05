import java.util.Scanner;
public class binarytree{
    public binarytree(){

    }
    private static class Node{
        int value;
        Node left;
        Node right;
    
    public  Node(int value){
        this.value = value;
    }
}
    private  Node root;
    public void populate(Scanner sc){
        System.out.println("Enter the value of the root node");
        int value = sc.nextInt();
        root = new Node(value);
        populate(sc ,root);
    }
    private void populate( Scanner sc, Node node){
        System.out.println("Do you want value at left "+ node.value + " node");
        boolean left=sc.nextBoolean();
        if(left){
        System.out.println("Enter the value of the left node" + node.value);
        int value=sc.nextInt();
        node.left=new Node(value);
        populate(sc, node.left);
    
    }
    
        System.out.println("Do you want value at right"+ node.value + " node");
        boolean right=sc.nextBoolean();
        if(right){
        System.out.println("Enter the value of the right node" + node.value);
        int value=sc.nextInt();
        node.right=new Node(value);
        populate(sc, node.right);
    
    }
    }
    public void display(){
        display(this.root,  " ");
}
private void display(Node node, String indent){
    if(node==null){
        return;
    }System.out.println(indent + node.value);
    display(node.left, indent + " ");
    display(node.right, indent + " ");
}
public void prettyDisplay(){
    prettyDisplay(root, 0);
}
private void prettyDisplay(Node node, int level){
    if(node==null){
        return;
    }
    prettyDisplay(node.right,level+1);
    if(level !=0){
        for(int i=0;i<level-1;i++){
            System.out.print("|\t");
        }
        System.out.println("|-------->"+node.value);
    }
    else{
        System.out.println(node.value);
    }
    prettyDisplay(node.left,level+1);
}
    

    
    

        
    
    
    
           public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
         binarytree tree = new binarytree();
          tree.populate(sc);
          //tree.display();
          tree.prettyDisplay();
    }
}
