package com.coding.basic.stack.expr;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class InfixToPostfix {

	public static List<Token> convert(String expr) {
		List<Token> postFixExpr = new ArrayList<>();
		TokenParser tpObj = new TokenParser();
		List<Token> tokens = tpObj.parse(expr);
		Stack<Token> operator = new Stack<Token>();
		Iterator<Token> it = tokens.iterator();
		while (it.hasNext()) {
			Token t = it.next();
			if (t.isOperator()) {
				if (operator.isEmpty()) {
					operator.push(t);
				} else {
					while (!operator.isEmpty() && operator.peek().hasHigherPriority(t)) {
						postFixExpr.add(operator.pop());
					}
					operator.push(t);
				}
			} else {
				postFixExpr.add(t);
			}
		}
		while (!operator.isEmpty()) {
			postFixExpr.add(operator.pop());
		}
		return postFixExpr;
	}

	public static void main(String[] args) {
		List<Token> t = convert("2*3+4*5");
//		List<Token> t = convert("4*2 + 6+9*2/3 -8");
		Token[] s = t.toArray(new Token[t.size()]);
		for (Token token : s) {
			System.out.print(token);
		}
	}
}
