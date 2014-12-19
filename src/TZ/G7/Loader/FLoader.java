package TZ.G7.Loader;

import java.util.List;

import TZ.File.FReader;

/**
 * 
 * @author terrazero
 * @created Dec 19, 2014
 * 
 * @file FLoader.java
 * @project G7C
 * @identifier TZ.G7.Loader
 *
 */
public class FLoader extends GLoader {
	
	protected FReader reader;
	protected List<String> data;
	
	public FLoader(String dir, String file) {
		this.reader = new FReader(dir, file);
	}

	/* 
	 * @see TZ.G7.Loader.GLoader#loading()
	 */
	@Override
	protected void loading() {
		this.data = this.reader.readAll();
	}
	
	public List<String> data() {
		return this.data;
	}
	
}
