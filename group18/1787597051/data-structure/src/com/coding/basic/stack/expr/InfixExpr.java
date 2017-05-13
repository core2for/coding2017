package com.coding.basic.stack.expr;

import java.util.ArrayList;
import java.util.Stack;

public class InfixExpr {

	String expr = null;

	public InfixExpr(String expr) {

		this.expr = expr;

	}

	public int level(String operator) {
		int level = 0;
		switch (operator) {
		case "+":
		case "-":
			level = 1;
			break;
		case "*":
		case "/":
			level = 2;
			break;
		}
		return level;
	}

	public float evaluate() {
		Stack<String> stackOperator = new Stack<String>();
		Stack<Integer> stackNumber = new Stack<Integer>();
		ArrayList<String> tokens = new ArrayList<>();
		int startIndex = 0;
		for (int i = 0; i < expr.length(); i++) {
			char c = expr.charAt(i);
			switch (c) {
			case '+':
				startIndex = parse(tokens, startIndex, c);
				break;
			case '-':
				startIndex = parse(tokens, startIndex, c);
				break;
			case '*':
				startIndex = parse(tokens, startIndex, c);
				break;
			case '/':
				startIndex = parse(tokens, startIndex, c);
				break;
			}
		}
		tokens.add(expr.substring(startIndex));
		for (int i = 0; i < tokens.size(); i++) {
			String token = tokens.get(i);
			int nowLevel = level(token);
			int popLevel = -1;
			if (i >= 3 && i % 2 != 0) {
				popLevel = level(stackOperator.peek());
			}
			if (nowLevel <= popLevel) {
				String operator = stackOperator.pop();
				int number2 = stackNumber.pop();
				int number1 = stackNumber.pop();
				int result = caculate(operator, number1, number2);
				stackNumber.push(result);
				stackOperator.push(token);
			} else if (nowLevel > 0) {
				stackOperator.push(token);
			} else {
				stackNumber.push(Integer.parseInt(token));
			}

			if (i == tokens.size() - 1) {
				while (stackOperator.size() != 0) {
					String operator = stackOperator.pop();
					int number2 = stackNumber.pop();
					int number1 = stackNumber.pop();
					int result = caculate(operator, number1, number2);
					stackNumber.push(result);
				}
			}
		}

		return stackNumber.pop();
	}

	private int caculate(String operator, int number1, int number2) {
		int result = 0;
		if (operator.equals("+")) {
			result = number1 + number2;
		} else if (operator.equals("-")) {
			result = number1 - number2;
		} else if (operator.equals("*")) {
			result = number1 * number2;
		} else if (operator.equals("/")) {
			result = number1 / number2;
		}
		return result;
	}

	public int parse(ArrayList<String> tokens, int startIndex, char c) {
		String subStr;
		int endIndex;
		endIndex = expr.indexOf(c, startIndex);
		subStr = expr.substring(startIndex, endIndex);
		tokens.add(subStr);
		tokens.add(c + "");
		startIndex = endIndex + 1;
		return startIndex;
	}

}