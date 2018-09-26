package TestPhantomReference;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

import org.junit.Test;

public class Reference {
	private static final int _1MB = 1024 * 1024;
	@Test
	public void testPhantomReference() throws InterruptedException {
	    System.out.println("**********–È“˝”√≤‚ ‘**********");
	        
	    ReferenceQueue<byte[]> referenceQueue = new ReferenceQueue<byte[]>();
	        
	    byte[] bytes = new byte[4 * _1MB];
	    PhantomReference<byte[]> pr = new PhantomReference<byte[]>(bytes, referenceQueue);
	        
	    bytes = null;
	        
	    System.gc();
	        
	    System.out.println(referenceQueue.poll());
	    Thread.sleep(100);
	    System.out.println(referenceQueue.poll());
	}
}
