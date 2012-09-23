package org.young.util;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class SQLUtilTest {

	@Test
	public void testBuildWhereStateWithEmpty() {
		
		List<String> list = new ArrayList<String>();
		
		SQLUtil.buildWhereStateAND(list);
	}
	
	@Test
	public void testBuildWhereStateWithData() {
		
		List<String> list = new ArrayList<String>();
		
		list.add("name");
		String sql = SQLUtil.buildWhereStateAND(list);
		System.out.println(sql);
		
		list.add("gender");
		sql = SQLUtil.buildWhereStateAND(list);
		System.out.println(sql);
		
		list.add("birthday");
		sql = SQLUtil.buildWhereStateAND(list);
		System.out.println(sql);
	}

}
