import java.io.IOException;
import java.util.List;

public class Person201Finder {
    public static void main(String[] args) throws IOException{
        Person201 me = new Person201("Dav King", "Keohane 4E", 3);
        Person201[] fullClass = Person201Utilities.readURL("https://courses.cs.duke.edu/compsci201/fall22/people.txt");

        System.out.println("\nSearching for people near " + me.getName() + "\n");
        
        System.out.println("People on the same floor: ");
        List<Person201> sameFloor = Person201Utilities.sameFloor(fullClass, me);
        Person201Utilities.printPeople(sameFloor);

        System.out.println("People in the same building: ");
        List<Person201> sameBuilding = Person201Utilities.sameBuilding(fullClass, me);
        Person201Utilities.printPeople(sameBuilding);
    }
}
