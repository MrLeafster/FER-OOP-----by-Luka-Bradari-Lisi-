package samostalno_4.zad_7;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

class JavaProjectFileVisitor extends SimpleFileVisitor<Path>{
	
	private Map<String, Set<Path>> projectPathsPerExtension;
	private Set<String> extensionFilter;
	
	public JavaProjectFileVisitor(Set<String> extensionFilter) {
		projectPathsPerExtension = new LinkedHashMap<>();
		this.extensionFilter = extensionFilter;
	}

	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
		if(attrs.isDirectory())
			return FileVisitResult.CONTINUE;
		
		String fileName = file.getFileName().toString();
		String fileExtension = fileName.substring(fileName.lastIndexOf('.'));
		
		if(extensionFilter.contains(fileExtension))
			return FileVisitResult.CONTINUE;
		
		if(!projectPathsPerExtension.containsKey(fileExtension))
			projectPathsPerExtension.put(fileExtension, new LinkedHashSet<>());
		
		projectPathsPerExtension.get(fileExtension).add(file);
		
		return FileVisitResult.CONTINUE;
	}

	public Map<String, Set<Path>> getProjectPathsPerExtension() {
		return projectPathsPerExtension;
	}
	
	public static void main(String[] args) throws IOException {
		JavaProjectFileVisitor visitor = new JavaProjectFileVisitor(Set.of(".pdf"));
		File f = new File("C:\\Users\\Luka\\Desktop\\FER materijali\\SEMESTAR 1\\VJEKOM");
		Files.walkFileTree(f.toPath(), visitor);
		Map<String, Set<Path>> map = visitor.getProjectPathsPerExtension();
		for(String key : map.keySet()){
		  Set<Path> list = map.get(key);
		  for(Path p : list)
		    System.out.println("Key: " + key + " - " + p);
		}
	}
}
