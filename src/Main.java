import java.util.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * UI sistem pakar untuk memeriksa apakah g bernilai true dari fakta a, b, c, f  
 * Sistem ini memiliki 4 pertanyaan yang akan diberikan pada user
 * 4 pertanyaan merepresentasikan 4 fakta
 * fact: a, b, c, f
 * conclussion: g
 * @author AERO
 */
public class Main {

    public static List<Rule> getKnowledge() throws FileNotFoundException, IOException
    {
        //ganti dengan lokasi project Anda nanti
        FileReader reader = new FileReader("D:\\Materi Kuliah\\Ganjil 2024-2025\\ExpertSystemExample\\src\\knowledge_base");
        BufferedReader bufferedReader = new BufferedReader(reader);
        List<Rule> rules = new ArrayList<>();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            //mengambil string bagian fact dulu baru conclussion
            rules.add(new Rule(
                    Arrays.asList(line.split("-")[0].split(",")), 
                    line.split("-")[1]));
        }
        
        bufferedReader.close();
        reader.close();
        return rules;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
        UI tampilan = new UI();
        tampilan.showQuestion();
        //initial facts, jawaban user
        Set<String> facts  = tampilan.getFacts();
        
        //get knowledge base
        List<Rule> rules = getKnowledge();
        
        // Apply forward chaining
        Set<String> inferedFacts = 
                InferenceForwardChaining.doForwardChaining(rules, facts);
        
        boolean gIsTrue;
        if(inferedFacts.contains("g"))
            gIsTrue = true;
        else
            gIsTrue = false;
        tampilan.showConclussion(gIsTrue, facts, inferedFacts);
    }
    
}
