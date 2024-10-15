# Deletion of a Node in Binary Search Tree (BST)

## Introduction
 **Deleting a node** from a BST requires special handling to maintain this property.

## Problem Statement
Given the root of a binary search tree and a key, delete the node with the given key in the BST. After deletion, ensure that the binary search tree property is maintained.

## Approach

The deletion of a node in a BST can be broken down into three cases:
1. **Node to be deleted is a leaf:** Simply remove the node.
2. **Node to be deleted has one child:** Replace the node with its child.
3. **Node to be deleted has two children:** Replace the node with its **in-order successor** (smallest node in the right subtree).

![DeleteNodeBST](./Images/DeleteNodeBST.png)
![DeleteNodeBST](./Images/DeleteNodeBST2.png)
### Java Code

```java
class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null){
            return null;
        }
        else if (root.val > key){
            root.left = deleteNode(root.left , key);
        }
        else if (root.val < key){
            root.right = deleteNode(root.right, key);
        }
        else if (root.val == key){

            //Case 1
            if (root.left == null && root.right == null){
                return null;
            }

            //Case 2
            if (root.left == null){
                return root.right;
            }
            if (root.right == null){
                return root.left;
            }

            //Case 3
            TreeNode inorderSuccessor = inorderSuccessor(root.right);
            deleteNode(root , inorderSuccessor.val);
            root.val = inorderSuccessor.val;
        }

        return root;
    }
    public TreeNode inorderSuccessor(TreeNode root){
        while(root.left != null){
            root = root.left;
        }
        return root;
    }
}
