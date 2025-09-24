package org.dsa.validateBST;

public class ValidateBst {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(50);
        root.left = new TreeNode(30);
        root.right = new TreeNode(70);
        root.left.left = new TreeNode(20);
        root.left.right = new TreeNode(40);
        root.right.left = new TreeNode(60);
        root.right.right = new TreeNode(10);

        System.out.println(isValidBST(root));
    }

    public static boolean isValidBST(TreeNode root){
        if(root == null){
            return true;
        }
        if((root.left != null && root.timeStamp <= root.left.timeStamp) || (root.right != null && root.timeStamp >= root.right.timeStamp)){
            return false;
        }

        return isValidBST(root.left) && isValidBST(root.right);
    }
}
