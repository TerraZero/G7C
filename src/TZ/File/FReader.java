package TZ.File;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 
 * @author Terra
 * @created 18.12.2014
 * 
 * @file FReader.java
 * @project G7C
 * @identifier TZ.File
 *
 */
public class FReader {
	
	public static void main(String[] args) {
		FReader r = new FReader("~", "test-3.csv");
		long filesize = r.getPath().toFile().length();
		System.out.println(filesize);
		long start = System.currentTimeMillis();
		List<String> lines = r.readAll();
		long end = System.currentTimeMillis();
		System.out.println(start);
		System.out.println(end - start);
		System.out.println(end);
	}

	protected Path path;
	protected Exception e;
	
	public FReader(String dir, String file) {
		this(Paths.get(dir.replaceAll("~", System.getProperty("user.home")), file));
	}
	
	public FReader(File file) {
		this(file.toPath());
	}
	
	public FReader(Path path) {
		this.path = path;
	}
	
	public Path getPath() {
		return this.path;
	}
	
	public List<String> readAll() {
		try (Stream<String> stream = Files.lines(this.path, Charset.defaultCharset())) {
			return stream.collect(Collectors.toList());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void exception(Exception e) {
		this.e = e;
	}
	
	public Exception exception() {
		return this.e;
	}
	
}
