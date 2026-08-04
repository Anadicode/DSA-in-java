class BinaryTree{

 //116 Populating Next Right Pointers in Each Node

    public Node connect(Node root) {

        // optimal approach

        if(root==null)return root;
        if(root.left!=null) root.left.next=root.right;
        if(root.right!=null && root.next!=null) root.right.next=root.next.left;

        connect(root.left);
        connect(root.right);

        return root;
    }

    //117 Populating Next Right Pointers in Each Node ii
    public Node connect(Node root) {

        // Level order solution
            Queue<Node> q =new LinkedList<>();

            if(root == null) return root;

            q.add(root);
            while(!q.isEmpty()){
                List<Node> l = new ArrayList<>();
                int n = q.size();

                for(int i=0;i<n;i++){
                    Node front = q.poll();
                    l.add(front);

                    if(front.left!=null)q.add(front.left);
                    if(front.right!=null)q.add(front.right);

                }

                for(int i=0;i<l.size()-1;i++){
                    Node temp = l.get(i);
                    temp.next=l.get(i+1);

                }

            }

               return root;
    }

}