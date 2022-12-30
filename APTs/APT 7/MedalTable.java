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