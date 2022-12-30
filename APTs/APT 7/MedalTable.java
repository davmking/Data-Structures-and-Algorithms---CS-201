/*The Olympic Games will be held, and have been held (and might be being held). Given the results of the
olympic disciplines, generate and return the medal table.

The results of the disciplines are given as a String[] results, where each element is in the format "GGG SSS BBB".
GGG, SSS and BBB are the 3-letter country codes (three capital letters from 'A' to 'Z') of the countries winning
the gold, silver and bronze medal, respectively.

The medal table is a String[] with an element for each country appearing in results. Each element has to be in the
format "CCO G S B" (quotes for clarity), where G, S and B are the number of gold, silver and bronze medals won by
country CCO, e.g. "AUT 1 4 1". The numbers should not have any extra leading zeros.

Sort the elements by the number of gold medals won in decreasing order. If several countries are tied, sort the tied
countries by the number of silver medals won in decreasing order. If some countries are still tied, sort the tied
countries by the number of bronze medals won in decreasing order. If a tie still remains, sort the tied countries
by their 3-letter code in ascending alphabetical order. */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class MedalTable {

    private class MedalCountry{
        String countryName;
        int myGold;
        int mySilver;
        int myBronze;

        MedalCountry(String name){
            countryName = name;
        }

        public int getGold(){
            return myGold;
        }

        public int getSilver(){
            return mySilver;
        }

        public int getBronze(){
            return myBronze;
        }

        public String getName(){
            return countryName;
        }

        @Override
        public String toString(){
            return String.format("%s %d %d %d", countryName, myGold, mySilver, myBronze);
        }
    }

    public String[] generate(String[] results) {
       HashMap<String, MedalCountry> countries = new HashMap<>();
       for(String s : results){
            String[] data = s.split(" ");
            for(int i = 0; i < 3; i++){
                if(!countries.containsKey(data[i])){
                    countries.put(data[i], new MedalCountry(data[i]));
                }
            }
            countries.get(data[0]).myGold += 1;
            countries.get(data[1]).mySilver += 1;
            countries.get(data[2]).myBronze += 1;
       }

       ArrayList<MedalCountry> sorted = new ArrayList<>(countries.values());
       Comparator<MedalCountry> gold = Comparator.comparing(MedalCountry::getGold).reversed();
       Comparator<MedalCountry> silver = Comparator.comparing(MedalCountry::getSilver).reversed();
       Comparator<MedalCountry> bronze = Comparator.comparing(MedalCountry::getBronze).reversed();
       Comparator<MedalCountry> country = Comparator.comparing(MedalCountry::getName);

       Comparator<MedalCountry> fullComp = gold.thenComparing(silver).thenComparing(bronze).thenComparing(country);
       Collections.sort(sorted, fullComp);

       String[] ans = new String[sorted.size()];

       for(int i = 0; i < sorted.size(); i++){
            ans[i] = sorted.get(i).toString();
       }

       return ans;
    }
  }
