package com.coding.basic.stack.expr;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class PrefixExpr {
	String expr = null;
	
	public PrefixExpr(String expr) {
		this.expr = expr;
	}

	public float evaluate() {
		TokenParser tpObj  =  new TokenParser();
		List<Token> tokens = tpObj.parse(expr);
		
		Stack<Token> result = new Stack<>();
	    Iterator<Token> it = tokens.iterator();
	    while(it.hasNext()){
	    	Token t=it.next();
   			result.push(t);
   			while (result.peek().isNumber()&&result.size()>1){
   				int number2 = result.pop().getIntValue();
   				if(!result.isEmpty()&&!result.peek().isNumber()){
   					Token mid = new Token(2, (number2+""));
   					result.push(mid);
   					break;
   				} else{
   					int number1 = result.pop().getIntValue();
   					String op = result.pop().toString();
   					int sult = caculate(number1, number2, op);
   					Token token = new Token(2, (sult+""));
   					result.push(token);
   				}
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
}