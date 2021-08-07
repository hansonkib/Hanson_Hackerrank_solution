package Java.Stack;

import java.util.Stack;

public class Solution {
    public boolean checkIfBalanced(String input, char opening, char closing){
        Stack<String> stack = new Stack<String>();
        for(int i = 0; i < input.length();i++){
            char c = input.charAt(i);
            if(c == closing){
                if(!stack.empty()){
                    stack.pop();
                }else{
                    return false;
                }
            }
            if(c == opening){
                stack.push(String.valueOf(c));
            }
        }
        return stack.empty();
    }
}
