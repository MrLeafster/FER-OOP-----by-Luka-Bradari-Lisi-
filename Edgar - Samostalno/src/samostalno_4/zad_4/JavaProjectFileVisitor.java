package samostalno_4.zad_4;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.LinkedHashMap;
import java.util.Map;

class JavaProjectFileVisitor extends SimpleFileVisitor<Path>{
	
	private Map<String, Long> fileExtensionsSizes = new LinkedHashMap<>();
	
	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
		
		if(attrs.isDirectory())
			return FileVisitResult.CONTINUE;
		
		String fileName = file.getFileName().toString();
		String fileExtension = fileName.substring(fileName.lastIndexOf('.'));
		
		if(!fileExtensionsSizes.containsKey(fileExtension))
			fileExtensionsSizes.put(fileExtension, Long.valueOf(0));
		
		Long num = fileExtensionsSizes.get(fileExtension);
		num += attrs.size();
		fileExtensionsSizes.put(fileExtension, num);
		
		return FileVisitResult.CONTINUE;
	}
	
	public Map<String, Long> getProjectFileSizeInfo(){
		return fileExtensionsSizes;
	}
	
	public static void main(String[] args) throws IOException {
		JavaProjectFileVisitor visitor = new JavaProjectFileVisitor();
		File f = new File("C:\\Users\\Luka\\Desktop\\FER materijali\\SEMESTAR 1\\VJEKOM");
		Files.walkFileTree(f.toPath(), visitor);
		Map<String, Long> map = visitor.getProjectFileSizeInfo();
		for(String key : map.keySet())
		    System.out.println("Key: " + key + " - " + map.get(key));
	}
}
