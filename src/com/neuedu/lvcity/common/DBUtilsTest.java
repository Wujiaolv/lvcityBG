package com.neuedu.lvcity.common;

import static org.junit.Assert.*;

import java.sql.Connection;

import org.junit.Before;
import org.junit.Test;

public class DBUtilsTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		Connection connection = DBUtils.getConnection();
		System.out.println(connection);
	}

}
