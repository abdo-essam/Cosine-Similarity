import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

class Index3 {

    Map<String, Vector<Integer>> table;  // store the file name and vector


    Index3() {
        table = new HashMap<String, Vector<Integer>>();
    }

    public void buildIndex(String[] files) {
        int freqWord = 0;
        HashSet<String> allWords = new HashSet<>();

        for (String fileName : files) {
            try (BufferedReader file = new BufferedReader(new FileReader(fileName))) {
                String ln;
                while ((ln = file.readLine()) != null) {
                    String[] words = ln.split("\\W+");
                    for (String word : words) {
                        word = word.toLowerCase();
                        allWords.add(word);
                    }
                }

            } catch (IOException e) {
                System.out.println("File " + fileName + " not found. Skip it");
            }

        }
        //System.out.println(allWords);


        for (String fileName : files) {
            Vector<Integer> vector = new Vector<>();
            for (String w : allWords) {
                try (BufferedReader file = new BufferedReader(new FileReader(fileName))) {

                    String ln;
                    while ((ln = file.readLine()) != null) {

                        String[] words = ln.split("\\W+");
                        for (String word : words) {

                            word = word.toLowerCase();
                            if (w.equals(word))
                                freqWord++;

                        }

                    }


                } catch (IOException e) {
                    System.out.println("File " + fileName + " not found. Skip it");
                }
                //System.out.println(fileName + "  " + w + " " + freqWord);
                vector.add(freqWord);
                table.put(fileName, vector);
                //System.out.println("vector " + vector.size());
                freqWord = 0;

            }


        }

        Map<Double, String> prob = new TreeMap<Double,String>(Collections.reverseOrder());
        prob.put(cosineSimilarity(table.get("101.txt"), table.get("102.txt")),"101.txt and 102.txt cosine similarity");
        prob.put(cosineSimilarity(table.get("101.txt"), table.get("103.txt")),"101.txt and 103.txt cosine similarity");
        prob.put(cosineSimilarity(table.get("101.txt"), table.get("104.txt")),"101.txt and 104.txt cosine similarity");
        prob.put(cosineSimilarity(table.get("102.txt"), table.get("103.txt")),"102.txt and 103.txt cosine similarity");
        prob.put(cosineSimilarity(table.get("102.txt"), table.get("104.txt")),"102.txt and 104.txt cosine similarity");
        prob.put(cosineSimilarity(table.get("103.txt"), table.get("104.txt")),"103.txt and 104.txt cosine similarity");




        for (Map.Entry<Double, String> entry : prob.entrySet())
            System.out.println( entry.getValue() + "\t" + entry.getKey());


        //System.out.println(table);
        //System.out.println(table.get("1.txt").size());

    }

    public double cosineSimilarity(Vector<Integer> vectorA, Vector<Integer> vectorB) {
        double dotProduct = 0.0;
        double normA = 0.0;
        double normB = 0.0;
        for (int i = 0; i < vectorA.size(); i++) {
            dotProduct += vectorA.get(i) * vectorB.get(i);
            normA += Math.pow(vectorA.get(i), 2);
            normB += Math.pow(vectorB.get(i), 2);
        }
        return dotProduct / (Math.sqrt(normA) * Math.sqrt(normB));
    }
}

public class Main {

    public static void main(String args[]) throws IOException {
        Index3 index = new Index3();

        index.buildIndex(new String[]{
                "101.txt",
                "102.txt",
                "103.txt",
                "104.txt"
        });


    }
}
