import java.util.Scanner;
public class bst{
    public class Node{
        int value;
        Node left;
        Node right;
        int height;
        public Node(int value){
            this.value=value;

        }
        public int getValue(){
            return value;
        }
    }
        private Node root;
        public bst(){

        }
        public int height(Node node){
            if(node==null){
                return -1;
            }
            return node.height;
        }
        public boolean isEmpty(){
            if(root==null){
                return true;
            }
            return false;

        }
        public void insert(int value){
            root=insert(value,root);

        }
        private Node insert(int value, Node node){
            if(node==null){
                return new Node(value);
            }
            if(value<node.value){
                node.left=insert(value,node.left);
            }else if(value>node.value){
                node.right=insert(value,node.right);
            }else{
                return node;
            }
            node.height=Math.max(height(node.left),height(node.right))+1;
            return node;
        }
        public void populate(int[] nums){
            for(int i=0;i<nums.length;i++){
             this.insert(nums[i]);
            }
        }
        public void populateSorted(int[] nums,int start,int end){
            if(start<=end){
                int mid=(start+end)/2;
                this.insert(nums[mid]);
                populateSorted(nums,start,mid-1);
                populateSorted(nums,mid+1,end);
            }

        }
        public boolean balanced(Node node){
            if(node==null){
                return true;
            }
            int leftHeight=height(node.left);
            int rightHeight=height(node.right);
            return (Math.abs(leftHeight-rightHeight)<=1 && balanced(node.left) && balanced(node.right));
        }
        public void display(){
            display(this.root,  " ");
        }
        public void display(Node node,String details){
            if(node==null){
                return;
            }
           System.out.println(details + node.value);
    display(node.left, "Left child of " + node.value + " : ");
    display(node.right, "Right child of " + node.value + " : ");
        }

    



    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        bst tree=new bst();
        System.out.println("Enter the number of nodes");
        int n=sc.nextInt();
        int[] nums=new int[n];
        System.out.println("Enter the values of the nodes");
        for(int i=0;i<n;i++){
            nums[i]=sc.nextInt();
        }
        tree.populate(nums);
        tree.display();
    }

    
}
