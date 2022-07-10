package samostalno_4.zad_3;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedList;
import java.util.List;

class LogProcessor {
	
	private List<LogEntry> logs;
	private Path file;
	
	/**
	   * Creates object and set file.
	   * @param file file name
	   */
	  public LogProcessor(Path file) {
		  this.file = file;
		  logs = new LinkedList<>(); 
	  }

	  /**
	   * Load file and populate list of loaded objects (LogEntry).
	   * @throws IOException if can not load file
	   */
	  public void load() throws IOException{
		  for(String line: Files.readAllLines(file, StandardCharsets.UTF_8)) {
			  logs.add(parseLog(line));
		  }
	  }

	  /**
	   * Returns list of log entries.
	   * @return list of log entries
	   */
	  public List<LogEntry> getLogs(){
		  return logs;
	  }

	  /**
	   * Extracts elements of line and creates LogEntry.
	   * @param line one line og log file
	   * @return created log entry object
	   */
	  public static LogEntry parseLog(String line) {
		  
		  int traveler = 0;
		  
		  // time
		  StringBuilder timeBuffer = new StringBuilder();
		  for(;;traveler++){
			  Character currentChar = line.charAt(traveler);
			  if(Character.isDigit(currentChar) || !Character.isLetter(currentChar))
				  timeBuffer.append(currentChar);
			  else
				  break;
		  }
		  
		  // level
		  StringBuilder levelBuilder = new StringBuilder();
		  for(;;traveler++) {
			  Character currentChar = line.charAt(traveler);
			  if(Character.isLetter(currentChar) || currentChar.equals(' '))
				  levelBuilder.append(currentChar);
			  else
				  break;
		  }
		  
		  // skip mid part
		  traveler = line.indexOf("]", traveler);
		  traveler = line.indexOf("[", traveler) + 1;
		  
		  // thread
		  String thread = line.substring(traveler, traveler = line.indexOf("]", traveler)).trim();
		  
		  // text
		  traveler = line.indexOf(" : ", traveler) + 3;
		  String text = line.substring(traveler).trim();
		  
		  return new LogEntry(timeBuffer.toString().trim(), levelBuilder.toString().trim(), thread, text);
		  
	  }
	  
	  public static void main(String[] args) throws IOException {
		  Path inputFile = Path.of("C:\\Users\\Luka\\Desktop\\Datoteke\\log.txt");
		  LogProcessor processor = new LogProcessor(inputFile);
		  processor.load();
		  List<LogEntry> logs = processor.getLogs();
	}
}
