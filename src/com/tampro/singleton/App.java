package com.tampro.singleton;

public class App {
	public static void main(String[] args) {
		EagerInitializedSingleton initializedSingleton = EagerInitializedSingleton.getInstance();
		EagerInitializedSingleton initializedSingleton1 = EagerInitializedSingleton.getInstance();
		System.out.println(initializedSingleton == initializedSingleton1); // ko dùng vẫn tạo
		// test eager singleton
		
		// test lazy singleton
		LazyInitializedSingleton lazyInitializedSingleton = LazyInitializedSingleton.getInstance();
		LazyInitializedSingleton lazyInitializedSingleton1 = LazyInitializedSingleton.getInstance();
		System.out.println(lazyInitializedSingleton == lazyInitializedSingleton1); // nếu có 2 luồng sẽ có 2 instance
		
		// test threadSafe Singleton
		ThreadSafeSingleton threadSafeSingleton = ThreadSafeSingleton.getInstance();
		ThreadSafeSingleton threadSafeSingleton1 = ThreadSafeSingleton.getInstance();
		System.out.println(threadSafeSingleton == threadSafeSingleton1); // Sync dù đa luồng nhưng đồng bộ 1 instance
		
		
		
		
		
	}

}
