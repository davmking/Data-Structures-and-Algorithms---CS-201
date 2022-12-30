import java.security.InvalidAlgorithmParameterException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
//import java.util.Stack;

import org.jgrapht.alg.util.UnionFind;

import net.sf.javaml.core.kdtree.KDTree;

import java.io.FileInputStream;

/**
 * Models a weighted graph of latitude-longitude points
 * and supports various distance and routing operations.
 * To do: Add your name(s) as additional authors
 * @author Brandon Fain
 *
 */
public class GraphProcessor {
    /**
     * Creates and initializes a graph from a source data
     * file in the .graph format. Should be called
     * before any other methods work.
     * @param file a FileInputStream of the .graph file
     * @throws Exception if file not found or error reading
     */
    
    private HashMap<Point, HashSet<Point>> graph = new HashMap<>();
    private KDTree myKDTree = new KDTree(2);
    private UnionFind<Point> union;

    public void initialize(FileInputStream file) throws Exception {
        try{
            Scanner s = new Scanner(file);
            int num_vertices = s.nextInt();
            int num_edges = s.nextInt();
            Point[] vertices = new Point[num_vertices];
            for(int i = 0; i < num_vertices; i++){
                s.next();
                Point p = new Point(Double.parseDouble(s.next()), Double.parseDouble(s.next()));
                double[] values = {p.getLat(), p.getLon()};
                myKDTree.insert(values, p);
                if(!graph.containsKey(p)){
                    graph.put(p, new HashSet<Point>());
                }
                vertices[i] = p;
            }
            union = new UnionFind<>(graph.keySet());
            for(int i = 0; i < num_edges; i++){
                if(!s.hasNextInt()){
                    s.next();
                }
                Point p1 = vertices[s.nextInt()];
                Point p2 = vertices[s.nextInt()];
                HashSet<Point> set1 = graph.get(p1);
                set1.add(p2);
                graph.put(p1, set1);
                HashSet<Point> set2 = graph.get(p2);
                set2.add(p1);
                graph.put(p2, set2);
                union.union(p1, p2);
            }
            s.close();
        }
        catch(Exception e){
            throw new Exception("Could not read .graph file");
        }
    }


    /**
     * Searches for the point in the graph that is closest in
     * straight-line distance to the parameter point p
     * @param p A point, not necessarily in the graph
     * @return The closest point in the graph to p
     */
    public Point nearestPoint(Point p) {
        /*Point nearest = graph.keySet().iterator().next();
        for(Point each : graph.keySet()){
            if(p.distance(each) < p.distance(nearest)){
                nearest = each;
            }
        }*/
        double[] pointVals = {p.getLat(), p.getLon()};
        return (Point) myKDTree.nearest(pointVals);
    }

    /**
     * Calculates the total distance along the route, summing
     * the distance between the first and the second Points, 
     * the second and the third, ..., the second to last and
     * the last. Distance returned in miles.
     * @param start Beginning point. May or may not be in the graph.
     * @param end Destination point May or may not be in the graph.
     * @return The distance to get from start to end
     */
    public double routeDistance(List<Point> route) {
        double length = 0;
        for(int i = 0; i < route.size() - 1; i++){
            length += route.get(i).distance(route.get(i + 1));
        }
        return length;
    }
    

    /**
     * Checks if input points are part of a connected component
     * in the graph, that is, can one get from one to the other
     * only traversing edges in the graph
     * @param p1 one point
     * @param p2 another point
     * @return true if p2 is reachable from p1 (and vice versa)
     */
    public boolean connected(Point p1, Point p2) {
        /*HashSet<Point> visited = new HashSet<>();
        HashMap<Point, Point> previous = new HashMap<>();
        Stack<Point> toExplore = new Stack<>();
        Point current = p1;
        toExplore.add(current);
        visited.add(current);
        while(!toExplore.isEmpty()){
            current = toExplore.pop();
            if(current.equals(p2)){
                return true;
            }
            for(Point neighbor : graph.get(current)){
                if(!visited.contains(neighbor)){
                    previous.put(neighbor, current);
                    visited.add(neighbor);
                    toExplore.push(neighbor);
                }
            }
        }
        return false;*/
        return union.inSameSet(p1, p2);
    }

    public double getTotalDist(HashMap<Point, Double> distance, Point current, Point end){
        return distance.get(current) + current.distance(end);
    }

    public List<Point> getRoute(Point start, Point end, HashMap<Point, Point> previous){
        ArrayList<Point> myRoute = new ArrayList<>();
        myRoute.add(end);
        Point current = end;
        while(!current.equals(start)){
            Point toAdd = previous.get(current);
            myRoute.add(toAdd);
            current = toAdd;
        }
        Collections.reverse(myRoute);
        return myRoute;
    }

    /**
     * Returns the shortest path, traversing the graph, that begins at start
     * and terminates at end, including start and end as the first and last
     * points in the returned list. If there is no such route, either because
     * start is not connected to end or because start equals end, throws an
     * exception.
     * @param start Beginning point.
     * @param end Destination point.
     * @return The shortest path [start, ..., end].
     * @throws InvalidAlgorithmParameterException if there is no such route, 
     * either because start is not connected to end or because start equals end.
     */
    public List<Point> route(Point start, Point end) throws InvalidAlgorithmParameterException {
        if(connected(start, end) == false || start.equals(end) || !graph.keySet().contains(start) || !graph.keySet().contains(end)){
            throw new InvalidAlgorithmParameterException("No path here");
        }
        HashMap<Point, Double> distance = new HashMap<>();
        HashMap<Point, Point> previous = new HashMap<>();
        Comparator<Point> comp = (a, b) -> (int) (getTotalDist(distance, a, end) - getTotalDist(distance, b, end));
        //Comparator<Point> comp = (a, b) -> (int) (distance.get(a) - distance.get(b));
        PriorityQueue<Point> toExplore = new PriorityQueue<>(comp);
        Point current = start;
        distance.put(current, (double) 0);
        toExplore.add(current);
        while(!toExplore.isEmpty()){
            current = toExplore.remove();
            for(Point neighbor : graph.get(current)){
                if(neighbor.equals(end)){
                    previous.put(neighbor, current);
                    return getRoute(start, end, previous);
                }
                //double getDist = current.distance(neighbor);
                if(!distance.containsKey(neighbor) || getTotalDist(distance, neighbor, end) > distance.get(current) + current.distance(neighbor) + neighbor.distance(end)){
                    distance.put(neighbor, distance.get(current) + current.distance(neighbor));
                    previous.put(neighbor, current);
                    toExplore.add(neighbor);
                }
            }
        }
        return getRoute(start, end, previous);
    }

    
}
