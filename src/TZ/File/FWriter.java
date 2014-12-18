package TZ.File;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * 
 * @author Terra
 * @created 18.12.2014
 * 
 * @file FWriter.java
 * @project G7C
 * @identifier TZ.File
 *
 */
public class FWriter {

	protected Path path;
	protected Exception e;
	
	public FWriter(String dir, String file) {
		this(Paths.get(dir, file));
	}
	
	public FWriter(File file) {
		this(file.toPath());
	}
	
	public FWriter(Path path) {
		this.path = path;
	}
	
	public Path getPath() {
		return this.path;
	}
	
	public FWriter writeAll(List<String> lines) {
		try {
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.path.toFile()), Charset.defaultCharset()));
			for (String line : lines) {
				this.writeLine(writer, line);
			}
			writer.close();
		} catch (IOException e) {
			this.exception(e);
		}
		return this;
	}
	
	public void writeLine(BufferedWriter writer, String line) throws IOException {
		writer.write(line);
		writer.newLine();
	}
	
	public void exception(Exception e) {
		this.e = e;
	}
	
	public Exception exception() {
		return this.e;
	}
	
}
