# Cosine Similarity between Pairs of Files

# Faculty Of Computer And Artificial Intelligence Cairo University `FCAI-CU`

## Information Retrieval Assignment


This is a Java program that builds an index of the words in a set of text files and computes the cosine similarity between pairs of files. The program uses a HashMap to store the word frequencies for each file, and a Vector to store the word frequencies for each file in the order of the words in the HashSet of all words. The cosine similarity between two files is computed using the dot product of their frequency vectors and the L2 norms of their frequency vectors.

The main method creates an instance of the Index3 class and calls its buildIndex method, passing in an array of file names. The buildIndex method first reads all the files and builds a HashSet of all the unique words in the files. It then builds the frequency vectors for each file by iterating over the words in the HashSet and counting their frequencies in each file. Finally, it computes the cosine similarity between pairs of files using the cosineSimilarity method and stores the results in a TreeMap, which automatically sorts the entries by descending order of cosine similarity. The results are then printed to the console.

Overall, this program can be used to quickly compute the similarity between pairs of text files based on their word frequencies, which can be useful for applications such as document classification, information retrieval, and plagiarism detection.

## For More info https://www.engati.com/glossary/cosine-similarity
