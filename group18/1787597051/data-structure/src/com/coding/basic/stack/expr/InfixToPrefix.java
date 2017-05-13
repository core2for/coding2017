package com.coding.basic.stack.expr;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Stack;

public class InfixToPrefix {
	public static List<Token> convert(String expr) {
		List<Token> prefixExpr = new ArrayList<>();
		TokenParser tpObj = new TokenParser();
		List<Token> tokens = tpObj.parse(expr);
		Stack<Token> number = new Stack<Token>();
		Stack<Token> operator = new Stack<Token>();
		ListIterator<Token> it = tokens.listIterator(tokens.size());
		while (it.hasPrevious()) {
			Token t = it.previous();
			if (t.isOperator()) {
				if (operator.isEmpty()) {
					operator.push(t);
				} else {
					while (!operator.isEmpty() && operator.peek().hasHigherPriority(t)) {
						prefixExpr.add(t);
						prefixExpr.add(operator.pop());
						Token number2 = number.pop();
						Token number1 = number.pop();
						prefixExpr.add(number1);
						prefixExpr.add(number2);
					}
				}
			} else {
				number.push(t);
			}
		}
		while (!operator.isEmpty()) {
			prefixExpr.add(operator.pop());
		}
		while(!number.isEmpty()){
			prefixExpr.add(number.pop());
		}
		return prefixExpr;
	}
	
	public static void main(String[] args) {
//		List<Token> t = convert("2*3+4*5");
		List<Token> t = convert("4*2 + 6+9*2/3 -8");
		Token[] s = t.toArray(new Token[t.size()]);
		for (Token token : s) {
			System.out.print(token);
		}
	}
}
