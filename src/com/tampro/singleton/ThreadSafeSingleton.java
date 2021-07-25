package com.tampro.singleton;
/*
 * Thread safe singleton
 */
public class ThreadSafeSingleton {
	private static ThreadSafeSingleton threadSafeSingleton;
	
	private ThreadSafeSingleton() {
		
	}

	/*
	 * Chạy chậm do method synchronized
	 */
	/*
		 public static synchronized ThreadSafeSingleton getInstance() {
			if(threadSafeSingleton == null) {
				threadSafeSingleton = new ThreadSafeSingleton();
			}
			return threadSafeSingleton;
		}
	 */
	
	public static ThreadSafeSingleton getInstance() {
		if(threadSafeSingleton == null) {
			synchronized (ThreadSafeSingleton.class) {
				if(threadSafeSingleton == null) {
					threadSafeSingleton = new ThreadSafeSingleton();
				}
			}
		}
		return threadSafeSingleton;
	}
	
}
