import java.util.*;

public class HashListAutocomplete implements Autocompletor {
    private static final int MAX_PREFIX = 10;
    private Map<String, List<Term>> myMap;
    private int mySize;
    private Set<String> allWords;

    public HashListAutocomplete(String[] terms, double[] weights) {
        if (terms == null || weights == null) {
			throw new NullPointerException("One or more arguments null");
		}
		
		initialize(terms, weights);
    }

    @Override
    public List<Term> topMatches(String prefix, int k) {
        if (k < 0) {
			throw new IllegalArgumentException("Illegal value of k:"+k);
		}

        if(prefix.length() > MAX_PREFIX){
            prefix = prefix.substring(0, MAX_PREFIX);
        }
        if(myMap.containsKey(prefix)){
            List<Term> these = myMap.get(prefix);
            return these.subList(0, Math.min(k, these.size()));
        }
        return new ArrayList<>();
    }

    @Override
    public void initialize(String[] terms, double[] weights) {
        if(terms.length != weights.length){
            throw new IllegalArgumentException("Terms and Weights must be the same length");
        }

        myMap = new HashMap<>();
        allWords = new HashSet<>();

        for(int i = 0; i < terms.length; i++){
            int j = 0;
            Term currTerm = new Term(terms[i], weights[i]);

            if(weights[i] < 0){
                throw new IllegalArgumentException("Negative Weight: " + weights[i]);
            }

            allWords.add(terms[i]);
            mySize += BYTES_PER_DOUBLE + BYTES_PER_CHAR*currTerm.getWord().length();
            while(j <= MAX_PREFIX && j <= terms[i].length()){
                String substr = terms[i].substring(0, j);
                if(!myMap.containsKey(substr)){
                    List<Term> newTerm = new ArrayList<>();
                    newTerm.add(currTerm);
                    myMap.put(substr, newTerm);
                    mySize += BYTES_PER_CHAR * substr.length();
                }
                else{
                    List<Term> currTerms = myMap.get(substr);
                    currTerms.add(currTerm);
                    myMap.put(substr, currTerms);
                }
                j++;
            }
        }
        for(String str : myMap.keySet()){
            List<Term> current = myMap.get(str);
            Collections.sort(current, Comparator.comparing(Term::getWeight).reversed());
            myMap.put(str, current);
        }
    }

    @Override
    public int sizeInBytes() {
        return mySize;
    }
    
}

