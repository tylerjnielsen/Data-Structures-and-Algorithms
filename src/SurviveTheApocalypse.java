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
         
         cities.addEdge( "Chicago", "Aurora", 36.4 ) ;
         cities.addEdge( "Chicago", "Joliet", 44.9 ) ;
         cities.addEdge( "Chicago", "Elgin", 40.4 ) ;
         cities.addEdge( "Chicago", "Cicero", 9.1 ) ; 
         cities.addEdge( "Aurora", "Rockford", 72.4 ) ;
         cities.addEdge( "Aurora", "Naperville", 10.3 ) ;
         cities.addEdge( "Aurora", "Peoria", 120.0 ) ;
         cities.addEdge( "Aurora", "Waukegan", 66.4 ) ;
         cities.addEdge( "Aurora", "Champaign", 160.4 ) ;
         cities.addEdge( "Aurora", "Decatur", 161.1 ) ;
         cities.addEdge( "Rockford", "Naperville", 90.8 ) ;
         cities.addEdge( "Rockford", "Peoria", 136.1 ) ;
         cities.addEdge( "Rockford", "Waukegan", 130.9 ) ;
         cities.addEdge( "Rockford", "Champaign", 184.8 ) ;
         cities.addEdge( "Rockford", "Decatur", 180.3 ) ;
         cities.addEdge( "Joliet", "Springfield", 165.5 ) ;
         cities.addEdge( "Joliet", "Elgin", 57.4 ) ;
         cities.addEdge( "Joliet", "Cicero", 32.9 ) ;
         cities.addEdge( "Joliet", "Bloomington", 101.4 ) ;
         cities.addEdge( "Naperville", "Springfield", 179.3 ) ;
         cities.addEdge( "Naperville", "Elgin", 25.7 ) ;
         cities.addEdge( "Naperville", "Cicero", 29.0 ) ;
         cities.addEdge( "Naperville", "Bloomington", 115.2 ) ;
         cities.addEdge( "Springfield", "Peoria", 74.3 ) ;
         cities.addEdge( "Springfield", "Waukegan", 232.7 ) ;
         cities.addEdge( "Springfield", "Champaign", 86.6 ) ;
         cities.addEdge( "Springfield", "Decatur", 40.6 ) ;
         cities.addEdge( "Peoria", "Waukegan", 197.0 ) ;
         cities.addEdge( "Peoria", "Champaign", 89.4 ) ;
         cities.addEdge( "Peoria", "Decatur", 84.9 ) ;
         cities.addEdge( "Elgin", "Waukegan", 56.7 ) ;
         cities.addEdge( "Elgin", "Champaign", 165.8 ) ;
         cities.addEdge( "Elgin", "Decatur", 193.3 ) ;
         cities.addEdge( "Waukegan", "Champaign", 180.5 ) ;
         cities.addEdge( "Waukegan", "Decatur", 213.1 ) ;
         cities.addEdge( "Cicero", "Bloomington", 130.9 ) ;
         cities.addEdge( "Champaign", "Bloomington", 50.7 ) ;
         cities.addEdge( "Bloomington", "Decatur", 46.3 ) ;
     }
 }
 