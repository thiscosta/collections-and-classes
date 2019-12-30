import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class ProcessNames {

	public ArrayList<String> readNames(String fileName) throws IOException {
		Path path = Paths.get(fileName);
		return (ArrayList<String>) Files.readAllLines(path, StandardCharsets.UTF_8);
	}

	public ArrayList<String> sortNames(ArrayList<String> names){
		Collections.sort(names);
		return names;
	}

	public boolean findName(ArrayList<String> names, String nameToFind) {
		boolean found = false;
		for(String name : names){
			if (name.equals(nameToFind)) {
				found = true;
				break;
			}
		}
		return found;
	}

	public Integer findNamePosition(ArrayList<String> names, String nameToFind) {
		int position = -1;
		for(int i = 0; i < names.size(); i++){
			if(names.get(i).equals(nameToFind)) {
				position = i;
				break;
			}
		}
		return position;
	}

	public ArrayList<String> deleteName(ArrayList<String> names, String nameToRemove){
		names.remove(nameToRemove);
		return names;
	}

	public ArrayList<String> addName(ArrayList<String> names, String nameToAdd){
		names.add(nameToAdd);
		return names;
	}

	public ArrayList<String> changeName(ArrayList<String> names, String nameToChange, String newName) {
		names.set(names.indexOf(nameToChange), newName);
		return names;
	}

	public String writeNames(ArrayList<String> names) throws IOException {
		String fileName = "namesFile"+new Random().nextInt()+".txt";
		Path file = Paths.get(fileName);
		Files.write(file, names, StandardCharsets.UTF_8);
		return fileName;
	}

}
