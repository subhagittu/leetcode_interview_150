class Solution {
public:
    void countingTraversal(TreeNode* root, int& num) {
        if(root == nullptr) return;
        num++;
        countingTraversal(root->left, num);
        countingTraversal(root->right, num);
    }
    int countNodes(TreeNode* root) {
        int res = 0;
        countingTraversal(root, res);
        return res;
    }
};
