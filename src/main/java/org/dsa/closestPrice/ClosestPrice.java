package org.dsa.closestPrice;

public class ClosestPrice {
    public static void main(String[] args) {
        // Build BST of trades (by price)
        TreeNode root = new TreeNode(50);
        root.left = new TreeNode(30);
        root.right = new TreeNode(70);
        root.left.left = new TreeNode(20);
        root.left.right = new TreeNode(40);
        root.right.left = new TreeNode(60);
        root.right.right = new TreeNode(80);

        double target = 65;
        TreeNode closest = findClosest(root, target);
        System.out.println("Closest to " + target + " = " + closest.price); // should print 70

        target = 66;
        closest = findClosest(root, target);
        System.out.println("Closest to " + target + " = " + closest.price); // should print 70

        target = 62;
        closest = findClosest(root, target);
        System.out.println("Closest to " + target + " = " + closest.price); // should print 60

        target = 70;
        closest = findClosest(root, target);
        System.out.println("Closest to " + target + " = " + closest.price); // should print 70
    }

    public static TreeNode findClosest(TreeNode root, double target){
        TreeNode current = root;
        TreeNode closest = root;
        double maxDouble = Double.MAX_VALUE;
        while(current != null){
            double diff = Math.abs(current.price-target);
            if(diff < maxDouble){
                maxDouble = diff;
                closest = current;
            }

            if(current.price > target){
                current = current.left;
            }
            else if(current.price < target){
                current = current.right;
            }
            else{
                return current;
            }
        }
        return closest;
    }
}
