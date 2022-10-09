import java.util.ArrayList;

/**
 * A WordGram object represents an immutable
 * sequence of words.
 * For use in Compsci 201, Duke University, Fall 2022
 * Add yourself as an author when you make edits
 * @author Brandon Fain
 * @author Dav King
 */

public class WordGram {
	private String[] myWords; 	// Stores WordGram words
	private String myToString;	// Stores space separated words as one string
	private int myHash;			// Stores hash value of WordGram

	
	/**
	 * Constructor should generate a WordGram with size words
	 * beginning at the start index value of source array.
	 * Each element of source array should be a single word.
	 * @param source Source array, each element should be a single word
	 * @param start Index of first word for WordGram object
	 * @param size Number of elements in WordGram object
	 */
	public WordGram(String[] source, int start, int size) {
		// TODO correctly implement constructor
		//myWords = new String[]{source[start]};
		int j = 0;
		myWords = new String[size];
		for(int i = start; i < start + size; i++){
			myWords[j] = source[i];
			j++;
		}
		myToString = null;
		myHash = -1;
	}


	/**
	 * Return the word at a given index of WordGram
	 * @param index of word
	 * @return String/word at index position in WordGram
	 * @throws IndexOutOfBoundsException if index < 0 or index >= length()
	 */
	public String wordAt(int index) throws IndexOutOfBoundsException{
		String word = myWords[index];
		return word;
	}


	/**
	 * Returns number of words in this WordGram
	 * @return order of wordgram, number of words
	 */
	public int length() { 
		return myWords.length;
	}


	/** 
	 * Returns true if o is also a wordgram with the
	 * same words, otherwise returns false 
	*/
	@Override
	public boolean equals(Object o) {
		if (! (o instanceof WordGram) || o == null){
			return false;
		}
		WordGram other = (WordGram) o;
		if(! (other.length() == this.length())){
			return false;
		}
		for(int i = 0; i < other.length(); i++){
			if(!other.wordAt(i).equals(this.wordAt(i))){
					return false;
				}
		}
		return true;
	}


	/**
	 * Returns a hashCode for WordGram object equal to 
	 * the hashCode of the space separated words stored in 
	 * the WordGram.
	 */
	@Override
	public int hashCode() throws IndexOutOfBoundsException{
		if(myHash == -1){
			myHash = this.toString().hashCode();
			/*if(myToString == ""){
				toString();
			}
			String str = myToString;
			myHash = str.hashCode();*/
		}
		return myHash;
	}


	/**
	 * Return a new WordGram of the same length as this WordGram 
	 * consisting of words 1 through length-1 of this WordGram
	 * followed by last. Does NOT mutate this WordGram.
	 * @param last added as last string of returned WordGram
	 * Should be a single word
	 * @return new WordGram
	 */
	public WordGram shiftAdd(String last) throws IndexOutOfBoundsException{
		ArrayList<String> newWG = new ArrayList<>();
		for(int i = 1; i < this.length(); i++){
			newWG.add(myWords[i]);
		}
		newWG.add(last);
		String[] newWG2 = new String[newWG.size()];
		for(int i = 0; i < newWG2.length; i++){
			newWG2[i] = newWG.get(i);
		}
		WordGram x = new WordGram(newWG2, 0, this.length());
		return x;
	}


	/**
	 * Returns space separated words stored in the WordGram
	 * as a single String.
	 */
	@Override
	public String toString() throws IndexOutOfBoundsException{
		if(myToString == null){
			String str = String.join(" ", myWords);
			myToString = str;
		}
		return myToString;
	}
}
