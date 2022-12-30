import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * Demonstrates the calculation of shortest paths in the US Highway
 * network, showing the functionality of GraphProcessor and using
 * Visualize
 * To do: Add your name(s) as authors
 */
public class GraphDemo {

    private HashMap<String, Point> cities = new HashMap<>();
    static int NANO_TO_MILLI = 1000000;
    public static void main(String[] args) throws Exception {
        GraphProcessor simple = new GraphProcessor();
        simple.initialize(new FileInputStream("data/usa.graph"));
        GraphDemo demo = new GraphDemo();
        demo.initialize(new FileInputStream("data/uscities.csv"));
        Scanner input = new Scanner(System.in);
        Point start = demo.getValidCity(input);
        input.nextLine();
        Point end = demo.getValidCity(input);
        long startTime = System.nanoTime();
        start = simple.nearestPoint(start);
        end = simple.nearestPoint(end);
        long nearestPointTime = System.nanoTime() - startTime;
        while(simple.connected(start, end) == false){
            System.out.println("No route found between these two cities.");
            System.out.println("Would you like to continue? Y/N");
            if(input.next().toLowerCase().charAt(0) == 'n'){
                return;
            }
            System.out.println("Would you like to change your starting city? Y/N");
            if(input.next().toLowerCase().charAt(0) == 'y'){
                input.nextLine();
                start = simple.nearestPoint(demo.getValidCity(input));
            }
            System.out.println("Would you like to change your destination? Y/N");
            if(input.next().toLowerCase().charAt(0) == 'y'){
                input.nextLine();
                end = simple.nearestPoint(demo.getValidCity(input));
            }
        }
        input.close();
        long routeCalcStart = System.nanoTime();
        List<Point> myRoute = simple.route(start, end);
        long routeCalcEnd = System.nanoTime() - routeCalcStart;
        long distCalcStart = System.nanoTime();
        double myDistance = simple.routeDistance(myRoute);
        long distCalcEnd = System.nanoTime() - distCalcStart;
        Visualize myViz = new Visualize("data/usa.vis", "images/usa.png");
        myViz.drawRoute(myRoute);
        System.out.println("Total distance in miles: " + myDistance);
        System.out.println("Total time to find nearest points: " + nearestPointTime / NANO_TO_MILLI + " Milliseconds");
        System.out.println("Total time to calculate shortest route: " + routeCalcEnd / NANO_TO_MILLI + " Milliseconds");
        System.out.println("Total time to calculate route distance: " + distCalcEnd / NANO_TO_MILLI + " Milliseconds");
    }

    public void initialize(FileInputStream file){
        Scanner s = new Scanner(file);

        while(s.hasNextLine()){
            String[] lineCities = s.nextLine().split(",");
            String cityState = lineCities[0] + ", " + lineCities[1];
            cities.put(cityState.toLowerCase(), new Point(Double.parseDouble(lineCities[2]), Double.parseDouble(lineCities[3])));
        }

        s.close();
    }

    public Point getValidCity(Scanner input){
        System.out.println("Input new city: ");
        String p = input.nextLine().toLowerCase();
        System.out.println("Input 2-letter state code: ");
        String s1 = p + ", " + input.next().toLowerCase();
        //System.out.println("\n");
        while(!cities.keySet().contains(s1)){
            System.out.println("Error: City is not within the map.");
            System.out.println("Would you like to input coordinates instead? Y/N");
            String s = input.next().toLowerCase();
            if(s.charAt(0) == 'y'){
                System.out.println("Input Latitude: ");
                double lat1 = Double.parseDouble(input.next());
                System.out.println("Input Longitude: ");
                double long1 = Double.parseDouble(input.next());
                Point userInput = new Point(lat1, long1);
                return userInput;
            }
            else{
                input.nextLine();
                System.out.println("Input new city: ");
                p = input.nextLine().toLowerCase();
                System.out.println("Input 2-letter state code: ");
                s1 = p + ", " + input.next().toLowerCase();
            }
        }
        return cities.get(s1);
    }
}