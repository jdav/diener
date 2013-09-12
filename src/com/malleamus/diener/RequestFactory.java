package com.malleamus.diener;

public interface RequestFactory {

	public Request create(String rawInput) throws Exception;

}
