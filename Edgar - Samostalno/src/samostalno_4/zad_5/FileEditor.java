package samostalno_4.zad_5;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

class FileEditor {
	  /**
	   * Reads input file encoded in UTF-8, process content and writes it to output file.
	   * @param inputFile input file
	   * @param outputFile output file
	   * @throws IOException
	   */
	  public static void processFile(Path inputFile, Path outputFile) throws IOException{
		  OutputStream izlaz = Files.newOutputStream(outputFile, StandardOpenOption.CREATE);
		  for(String line: Files.readAllLines(inputFile, StandardCharsets.UTF_8)) {
			  String modifiedLine = line + "\n";
			  izlaz.write(modifiedLine.getBytes());
		  }
		  izlaz.close();
	  }
	  
	  public static void main(String[] args) throws IOException {
		  Path inputFile = Path.of("C:\\Users\\Luka\\Desktop\\FER materijali\\exampleWindows.txt");
		  Path outputFile = Path.of("C:\\Users\\Luka\\Desktop\\FER materijali\\exampleLinux.txt");

		  FileEditor.processFile(inputFile, outputFile);
	}
}