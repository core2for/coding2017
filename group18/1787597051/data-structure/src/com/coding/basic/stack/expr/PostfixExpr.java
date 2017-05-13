package com.coding.basic.stack.expr;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

import javafx.geometry.Pos;

public class PostfixExpr {
	String expr = null;
	
	public PostfixExpr(String expr) {
		this.expr = expr;
	}

	public float evaluate() {
		Stack<Token> result = new Stack<>();
		TokenParser tokenParser = new TokenParser();
		List<Token> tokens = tokenParser.parse(expr);
		Iterator<Token> it = tokens.iterator();
		while(it.hasNext()){
			Token t = it.next();
			if (t.isOperator()){
				if(result.peek().isNumber()){
					int number2 = result.pop().getIntValue();
					if(result.peek().isNumber()){
						int number1 = result.pop().getIntValue();
						String op = t.toString();
						int mid = caculate(number1, number2, op);
						Token token = new Token(2, (mid+""));
						result.push(token);
					}
				}
			} else {
				result.push(t);
			}
		}
		return result.pop().getIntValue();
	}
	
	public static int caculate(int number1, int number2, String op){
		if (op.equals("+")){
			return number1+number2;
		} else if(op.equals("-")){
			return number1-number2;
		}else if (op.equals("*")){
			return number1*number2;
		} else if(op.equals("/")){
			return number1/number2;
		} else {
			return 0;
		}
	}
	public static void main(String[] args) {
		PostfixExpr p = new PostfixExpr("4 2*6+9 2*3/+8-");
//		PostfixExpr p = new PostfixExpr("2 3*4 5*+");
		float num = p.evaluate();
		System.out.println(num);
	}
}
