class BSTIterator {
    TreeNode temp;
    Stack<TreeNode> stk = new Stack<>();

    public BSTIterator(TreeNode root) {
        this.temp = root;
    }
    
    public int next() {
        int var = 0;
        while (true) {
            if (temp != null) {
                stk.push(temp);
                temp = temp.left;
            } else if (stk.isEmpty() && temp == null){
                break;
            }else {
                temp = stk.isEmpty() ? null : stk.pop();
                if(temp!=null) var = temp.val;
                temp = temp.right;
                break;
            }
        }
        return var;  
    }

    public boolean hasNext() {
        return temp!=null || (temp==null && !stk.isEmpty());
    }
}
