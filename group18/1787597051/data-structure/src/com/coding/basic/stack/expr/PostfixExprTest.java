package com.coding.basic.stack.expr;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class PostfixExprTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testEvaluate() {
		{
		//9+(3-1)*3+10/2
		PostfixExpr expr = new PostfixExpr("9 3 1-3*+10 2/+");
		Assert.assertEquals(20, expr.evaluate(),0.001f);
		}
		{
		//(1+2)*((8-2)/(7-4))
		PostfixExpr expr = new PostfixExpr("1 2+8 2-7 4-/*");
		Assert.assertEquals(6, expr.evaluate(), 0.001f);
		}
	}

}
