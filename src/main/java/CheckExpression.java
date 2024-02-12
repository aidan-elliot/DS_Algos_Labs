//Imports
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class CheckExpression {

    /**
     * Checks expressions to determine whether brackets are balanced.
     */
    public boolean checkExpression(String expression) {
        //Stack is initialized to track open brackets
        Stack<Character> stack = new Stack<>();
        //For loop iterates over the characters in each expression
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            //Switch will handle the types of brackets
            switch (ch) {
                // all the open brackets will be pushed onto the stack
                case '(':
                case '[':
                case '{':
                case '<':
                    stack.push(ch);
                    break;
                //closing brackets will be popped if they match the top of the stack
                case ')':
                    if (stack.isEmpty() || stack.pop() != '(') return false;
                    break;
                case ']':
                    if (stack.isEmpty() || stack.pop() != '[') return false;
                    break;
                case '}':
                    if (stack.isEmpty() || stack.pop() != '{') return false;
                    break;
                case '>':
                    if (stack.isEmpty() || stack.pop() != '<') return false;
                    break;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String filePath = "C:\\\\Users\\\\aidan\\\\Downloads\\\\bracketsTest.txt"; //The path should reflect the test file location!! Test file is in readme
        try {
            //open and read file
            File file = new File(filePath);
            Scanner scanner = new Scanner(file);

            //Will read the file by line to run multiple test cases in the same file
            int lineNumber = 1;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                CheckExpression checker = new CheckExpression();
                boolean isBalanced = checker.checkExpression(line);
                //lnprint result
                System.out.println("Line " + lineNumber + " is " + (isBalanced ? "balanced" : "not balanced"));
                lineNumber++;
            }
            scanner.close();
            //exception if file is not found
        } catch (FileNotFoundException e) {
            System.out.println("File at: " + filePath + " not found");
            e.printStackTrace();
        }
    }
}




