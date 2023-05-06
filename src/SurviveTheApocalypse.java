/*Tyler Nielsen
 * CS102 HW#5
 */

import java.util.Arrays;
import DSandAlgos.Graph;
import DSandAlgos.ArrayStack;

public class SurviveTheApocalypse
{
    public static void main(String[] args)
    {
        Graph<String> cities = new Graph<>();
        BuildGraph(cities);
        System.out.println(cities.toString());
        
        // Dijkstra's Algorithm
        Double[] distance = new Double [cities.size()];
        Arrays.fill(distance, Double.MAX_VALUE);
        Integer[] previous = new Integer[cities.size()];
        boolean[] known = new boolean[cities.size()];
        for (int i = 0; i < cities.size(); ++i)
        {
            distance[i] = cities.getAdjacencyMatrixValue(0, i);
            previous[i] = 0;
            known[i] = false;	
        }
        distance[0] = 0d;
        known[0] = true;
        outer_loop:
        for (int i = 0; i < cities.size(); ++i)
        {
        	inner_loop:
        	for (int j = 0; j < known.length; ++j)
        	{
        		if (!known[j])
        			break inner_loop;
        		if (j == known.length - 1)
        			break outer_loop;
        	}
        	int minIndex = -1;
        	Double min = Double.MAX_VALUE;
        	for (int j = 0; j < cities.size(); ++j)
        		if (!known[j] && (minIndex == -1 || distance[j] < distance[minIndex]))
        			minIndex = j;
        	known[minIndex] = true;
        	min = distance[minIndex];
        	for (int vertex = 0; vertex < cities.size(); ++vertex)
        	{
        		Double alt = min + cities.getAdjacencyMatrixValue(minIndex, vertex);
        		if (alt < distance[vertex])
        		{
        			distance[vertex] = alt;
        			previous[vertex] = minIndex;
        		}
        	}
        }
        for (int i = 0; i < cities.size(); ++i)
        {
        	if (previous[i] == 0 && cities.getAdjacencyMatrixValue(0, i) == Double.MAX_VALUE)
        		previous[i] = null;
        }
        // Print Shortest Paths
        System.out.println("Shortest Paths\n--------------");
        for (int i = 1; i < cities.size(); ++i)
        	System.out.println(bestPath(cities, 0, i, previous));	
    }
    
    private static String bestPath(Graph<String> cities, int source, int destination, Integer[] previous)
    {
    	String path = "From " + cities.getVertexByIndex(source) + " to " + cities.getVertexByIndex(destination) + ": " + cities.getVertexByIndex(source);
    	if (source == destination)
    		return path;
    	ArrayStack<String> stackOfCities = new ArrayStack<>();
    	int currentLocationIndex = destination;
    	int previousLocationIndex;
    	do
    	{
    		if (previous[currentLocationIndex] == null)
    			return "From " + cities.getVertexByIndex(source) + " to " + cities.getVertexByIndex(destination) + ": No path exists";
    		stackOfCities.push(cities.getVertexByIndex(currentLocationIndex));
    		previousLocationIndex = currentLocationIndex;
    		currentLocationIndex = previous[currentLocationIndex];
    	}
    	while (previous[previousLocationIndex] != source);
    	while (!stackOfCities.isEmpty())
    		path += " -> " + stackOfCities.pop();
    	return path;
    }
    
    private static void BuildGraph( Graph<String> cities )
    {
        cities.addVertex( "Chicago" ) ;
        cities.addVertex( "Aurora" ) ;
        cities.addVertex( "Rockford" ) ;
        cities.addVertex( "Joliet" ) ;
        cities.addVertex( "Naperville" ) ;
        cities.addVertex( "Springfield" ) ;
        cities.addVertex( "Peoria" ) ;
        cities.addVertex( "Elgin" ) ;
        cities.addVertex( "Waukegan" ) ;
        cities.addVertex( "Cicero" ) ;
        cities.addVertex( "Champaign" ) ;
        cities.addVertex( "Bloomington" ) ;
        cities.addVertex( "Decatur" ) ;
        
        //Commented out edges indicate that the androids have a significant presence
        // in a territory along that route that makes using it impossible.
        
        cities.addEdge( "Chicago", "Aurora", 36.4 ) ;
        //cities.addEdge( "Chicago", "Rockford", 88.7 ) ;
        cities.addEdge( "Chicago", "Joliet", 44.9 ) ;
        //cities.addEdge( "Chicago", "Naperville", 35.3 ) ;
        //cities.addEdge( "Chicago", "Springfield", 201.7 ) ;
        //cities.addEdge( "Chicago", "Peoria", 165.7 ) ;
        cities.addEdge( "Chicago", "Elgin", 40.4 ) ;
        //cities.addEdge( "Chicago", "Waukegan", 41.2 ) ;
        cities.addEdge( "Chicago", "Cicero", 9.1 ) ;
        //cities.addEdge( "Chicago", "Champaign", 136.4 ) ;
        //cities.addEdge( "Chicago", "Bloomington", 137.6 ) ;
        //cities.addEdge( "Chicago", "Decatur", 180.2 ) ;
        
        cities.addEdge( "Aurora", "Rockford", 72.4 ) ;
        //cities.addEdge( "Aurora", "Joliet", 22.6 ) ;
        cities.addEdge( "Aurora", "Naperville", 10.3 ) ;
        //cities.addEdge( "Aurora", "Springfield", 180.0 ) ;
        cities.addEdge( "Aurora", "Peoria", 120.0 ) ;
        //cities.addEdge( "Aurora", "Elgin", 21.4 ) ;
        cities.addEdge( "Aurora", "Waukegan", 66.4 ) ;
        //cities.addEdge( "Aurora", "Cicero", 36.3 ) ;
        cities.addEdge( "Aurora", "Champaign", 160.4 ) ;
        //cities.addEdge( "Aurora", "Bloomington", 115.9 ) ;
        cities.addEdge( "Aurora", "Decatur", 161.1 ) ;

        //cities.addEdge( "Rockford", "Joliet", 110.3 ) ;
        cities.addEdge( "Rockford", "Naperville", 90.8 ) ;
        //cities.addEdge( "Rockford", "Springfield", 199.2 ) ;
        cities.addEdge( "Rockford", "Peoria", 136.1 ) ;
        //cities.addEdge( "Rockford", "Elgin", 52.2 ) ;
        cities.addEdge( "Rockford", "Waukegan", 130.9 ) ;
        //cities.addEdge( "Rockford", "Cicero", 89.0 ) ;
        cities.addEdge( "Rockford", "Champaign", 184.8 ) ;
        //cities.addEdge( "Rockford", "Bloomington", 135.1 ) ;
        cities.addEdge( "Rockford", "Decatur", 180.3 ) ;
        
        //cities.addEdge( "Joliet", "Naperville", 19.0 ) ;
        cities.addEdge( "Joliet", "Springfield", 165.5 ) ;
        //cities.addEdge( "Joliet", "Peoria", 129.6 ) ;
        cities.addEdge( "Joliet", "Elgin", 57.4 ) ;
        //cities.addEdge( "Joliet", "Waukegan", 69.8 ) ;
        cities.addEdge( "Joliet", "Cicero", 32.9 ) ;
        //cities.addEdge( "Joliet", "Champaign", 115.7 ) ;
        cities.addEdge( "Joliet", "Bloomington", 101.4 ) ;
        //cities.addEdge( "Joliet", "Decatur", 146.6 ) ;

        cities.addEdge( "Naperville", "Springfield", 179.3 ) ;
        //cities.addEdge( "Naperville", "Peoria", 143.4 ) ;
        cities.addEdge( "Naperville", "Elgin", 25.7 ) ;
        //cities.addEdge( "Naperville", "Waukegan", 58.4 ) ;
        cities.addEdge( "Naperville", "Cicero", 29.0 ) ;
        //cities.addEdge( "Naperville", "Champaign", 145.5 ) ;
        cities.addEdge( "Naperville", "Bloomington", 115.2 ) ;
        //cities.addEdge( "Naperville", "Decatur", 160.4 ) ;

        cities.addEdge( "Springfield", "Peoria", 74.3 ) ;
        //cities.addEdge( "Springfield", "Elgin", 213.2 ) ;
        cities.addEdge( "Springfield", "Waukegan", 232.7 ) ;
        //cities.addEdge( "Springfield", "Cicero", 195.8 ) ;
        cities.addEdge( "Springfield", "Champaign", 86.6 ) ;
        //cities.addEdge( "Springfield", "Bloomington", 67.9 ) ;
        cities.addEdge( "Springfield", "Decatur", 40.6 ) ;

        //cities.addEdge( "Peoria", "Elgin", 152.1 ) ;
        cities.addEdge( "Peoria", "Waukegan", 197.0 ) ;
        //cities.addEdge( "Peoria", "Cicero", 160.1 ) ;
        cities.addEdge( "Peoria", "Champaign", 89.4 ) ;
        //cities.addEdge( "Peoria", "Bloomington", 38.2 ) ;
        cities.addEdge( "Peoria", "Decatur", 84.9 ) ;

        cities.addEdge( "Elgin", "Waukegan", 56.7 ) ;
        //cities.addEdge( "Elgin", "Cicero", 35.9 ) ;
        cities.addEdge( "Elgin", "Champaign", 165.8 ) ;
        //cities.addEdge( "Elgin", "Bloomington", 148.1 ) ;
        cities.addEdge( "Elgin", "Decatur", 193.3 ) ;

        //cities.addEdge( "Waukegan", "Cicero", 50.7 ) ;
        cities.addEdge( "Waukegan", "Champaign", 180.5 ) ;
        //cities.addEdge( "Waukegan", "Bloomington", 167.9 ) ;
        cities.addEdge( "Waukegan", "Decatur", 213.1 ) ;

        //cities.addEdge( "Cicero", "Champaign", 140.8 ) ;
        cities.addEdge( "Cicero", "Bloomington", 130.9 ) ;
        //cities.addEdge( "Cicero", "Decatur", 176.1 ) ;

        cities.addEdge( "Champaign", "Bloomington", 50.7 ) ;
        //cities.addEdge( "Champaign", "Decatur", 49.1 ) ;

        cities.addEdge( "Bloomington", "Decatur", 46.3 ) ;
    }
}
