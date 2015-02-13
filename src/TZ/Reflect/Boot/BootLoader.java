package TZ.Reflect.Boot;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * 
 * @author Terra
 * @created 13.02.2015
 * 
 * @file BootLoader.java
 * @project G7C
 * @identifier TZ.Reflect.Boot
 *
 */
public class BootLoader {
	
	public static void main(String[] args) {
		BootLoader l = new BootLoader();
		BootFile bf = l.root();
		BootLoader.out(bf, "");
	}
	
	public static void out(BootFile file, String tab) {
		file.contains().forEach((s, bf) -> {
			System.out.println(tab + bf.file());
			BootLoader.out(bf, tab + "  ");
		});
	}
	
	protected BootFile root;
	
	public BootFile root() {
		if (this.root == null) {
			this.init();
		}
		return this.root;
	}
	
	public void init() {
		this.root = new BootFile();
		try {
			Enumeration<URL> resources = ClassLoader.getSystemClassLoader().getResources("");
			while (resources.hasMoreElements()) {
				String path = resources.nextElement().getFile();
				if (path.startsWith("file:")) {
					String[] location = this.getLocation(path);
					ZipInputStream zip = new ZipInputStream(new URL(location[1]).openStream());
					this.loadZipItem(zip, this.root, path, "");
					zip.close();
				} else {
					this.loadFileItem(this.root, path, "");
				}
			}
		} catch (IOException e) {
			System.out.println(e);
		}
	}
	
	public void loadZipItem(ZipInputStream zip, BootFile item, String path, String internpath) throws IOException {
		ZipEntry entry = null;
		while ((entry = zip.getNextEntry()) != null) {
			// TODO
		}
	}
	
	public void loadFileItem(BootFile item, String path, String internpath) {
		for (File f : new File(path).listFiles()) {
			if (f.isDirectory()) {
				BootFile dir = new BootFile(f.getName(), false, internpath);
				item.add(dir.name(), dir);
				this.loadFileItem(dir, path + "/" + f.getName(), internpath + "/" + f.getName());
			} else if (f.isFile() && f.getName().endsWith(".class")) {
				BootFile file = new BootFile(f.getName(), true, internpath);
				item.add(file.name(), file);
			}
		}
	}
	
	public String[] getLocation(String dir) {
		String[] location = dir.split("!");
		
		location[1] = location[1].substring(1);
		return location;
	}
	
}
