package org.young.interview;

import java.util.HashMap;

import org.junit.Test;

public class HashTest {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void test() {
		HashMap map = new HashMap();
		map.put(new Hash('a'), "Appha");
		map.put(new Hash('b'), "Beta");
		map.put(new Hash('c'), "Appha");
		map.put(new Hash('a'), "Beta");
		
		System.out.println(map.size());
	}

}

class Hash {
	private char letter;
	
	public Hash(char c) {
		this.letter = c;
	}
	
	@Override
	public boolean equals(Object obj) {
		return obj instanceof Hash 
				&& ((Hash)obj).letter == this.letter;
	}
	
	@Override
	public int hashCode() {
		return 1;
	}
}
