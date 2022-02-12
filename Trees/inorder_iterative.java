public static void inorderIterative(Node root)
    {
        // create an empty stack
        Stack<Node> stack = new Stack<>();
    
        // start from the root node (set current node to the root node)
        Node curr = root;
    
        // if the current node is null and the stack is also empty, we are done
        while (!stack.empty() || curr != null)
        {
            // if the current node exists, push it into the stack (defer it)
            // and move to its left child
            if (curr != null)
            {
                stack.push(curr);
                curr = curr.left;
            }
            else {
                // otherwise, if the current node is null, pop an element from
                // the stack, print it, and finally set the current node to its
                // right child
                curr = stack.pop();
                System.out.print(curr.data + " ");
    
                curr = curr.right;
            }
        }
    }
