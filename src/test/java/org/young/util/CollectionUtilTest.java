package org.young.util;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.Assert.*;

import org.junit.Test;

public class CollectionUtilTest {

	@Test
	public void testIsEmpty() {
		
		Collection<String> list = new ArrayList<String>();
		Collection<?> set = null;
		
		assertTrue(CollectionUtil.isEmpty(list));
		assertTrue(CollectionUtil.isEmpty(set));
		
		list.add("Now, I'm not empty!!!");
		
		assertFalse(CollectionUtil.isEmpty(list));
		
	}

}
