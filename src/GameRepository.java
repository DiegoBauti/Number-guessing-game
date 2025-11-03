import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class GameRepository {

    private final Path path = Path.of("record.txt");

    public GameRepository() {
        if (!Files.exists(path)){
            try{
                Files.createFile(path);
            } catch (IOException e) {
                throw new IllegalStateException("The file could not be created");
            }
        }
    }

    public Map<Difficulty,Integer> loadRecord(){
        Map<Difficulty,Integer> map=new EnumMap<>(Difficulty.class);
        try {
            List<String> result=Files.readAllLines(path);
            if (isEmpty(result)) {
                return mapDefault();
            }

            for (String record : result) {
                String[] data = record.split(",");
                if (data.length == 2) {
                    try {
                        Difficulty diff = Difficulty.valueOf(data[0].trim().toUpperCase());
                        int num = Integer.parseInt(data[1].trim());
                        map.put(diff, num);
                    } catch(Exception e) {
                        throw new IllegalStateException("Error processing line: "+e);
                    }
                }
            }

            for (Difficulty diff:Difficulty.values()){
                if(!map.containsKey(diff)){
                    map.put(diff,diff.getTries());
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file data "+e);
        }
        return map;
    }

    public void writeRecord(Map<Difficulty,Integer> record){
        StringBuilder sb=new StringBuilder();
        for(Map.Entry<Difficulty,Integer> entry: record.entrySet()){
            sb.append(entry.getKey()).append(",").append(entry.getValue()).append("\n");
        }
        try {
            Files.writeString(path,sb, StandardCharsets.UTF_8);
        } catch (IOException e) {
            System.err.println("Error writing record file: " + e.getMessage());
        }
    }

    private Map<Difficulty,Integer> mapDefault(){
        Map<Difficulty,Integer> map=new EnumMap<>(Difficulty.class);
        for(Difficulty diff: Difficulty.values()){
            map.put(diff,diff.getTries());
        }
        return map;
    }

    private boolean isEmpty(List<String> lines){
        if (lines.isEmpty()) return true;
        for (String line:lines){
            if(line.isBlank()) return true;
        }
        return false;
    }
}
