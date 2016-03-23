package com.usjt;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ClienteTest {
	Cliente to;
	@Before
	public void setUp() throws Exception {
	to = new Cliente( "Celso", "67429", "asfd", "adws");
	}

	@Test
	public void testCliente() {
	assertEquals( to.getNome(), "elso");

	
	}
}
