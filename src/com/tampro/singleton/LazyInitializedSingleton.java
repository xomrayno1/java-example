package com.tampro.singleton;
/*
 * Lazy singleton
 */
public class LazyInitializedSingleton {
	private static LazyInitializedSingleton lazyInitializedSingleton;
	
	private LazyInitializedSingleton() {}
	
	public static LazyInitializedSingleton getInstance() {
		if(lazyInitializedSingleton == null) {
			lazyInitializedSingleton = new LazyInitializedSingleton();
		}
		return lazyInitializedSingleton;
	}

}
