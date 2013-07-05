package org.young.util;

import org.junit.Test;

public class ProxyedURLTest {

	@Test
	public void testReadStream() {
		ProxyedURL url = new ProxyedURL();
		url.readStream("http://www.baidu.com/");
	}

}
