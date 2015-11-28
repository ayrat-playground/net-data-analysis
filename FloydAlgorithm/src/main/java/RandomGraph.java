import org.jgrapht.UndirectedGraph;
import org.jgrapht.alg.FloydWarshallShortestPaths;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;

public class RandomGraph {

    UndirectedGraph<String, DefaultEdge> g = new SimpleGraph<String, DefaultEdge>(DefaultEdge.class);
    private double probability;
    private int num_of_ver;

    public RandomGraph(double probability, int num_of_ver) {

        this.probability = probability;
        this.num_of_ver = num_of_ver;


    }
    public void display(){

        char vertex1 = 'A';
        char vertex = 'A';;
        for (int i=0; i<num_of_ver; i++){
            vertex1 = 'A';;
            for (int j=i+1; j<num_of_ver; j++) {
                if (i!=j) {
                    System.out.println(g.getEdge(String.valueOf(vertex), String.valueOf(vertex1)));
                }
                vertex1++;
            }
            System.out.println();
            vertex++;


        }

    }
    public double midShortestPath(){

        double s=0;
        FloydWarshallShortestPaths floydWarshallShortestPaths = new FloydWarshallShortestPaths(g);
        char vertex1 = 'A';
        char vertex = 'A';
        for (int i=0; i<num_of_ver; i++){
            vertex1 = 'A';;
            for (int j=i+1; j<num_of_ver; j++) {
                if (i!=j) {
                    s=floydWarshallShortestPaths.shortestDistance(String.valueOf(vertex), String.valueOf(vertex1))+s;
                }
                vertex1++;
            }
            System.out.println();
            vertex++;


        }
        return s/num_of_ver;

    }

    public void GenerateGraph()
    {
        char vertex='A';

        for (int i=0; i<num_of_ver;i++){
            g.addVertex(String.valueOf(vertex));
            vertex++;
        }
        vertex='A';
        char vertex1;
        for (int i=0; i<num_of_ver;i++){
            vertex1='A';
            for (int j=0; j<num_of_ver;j++){
                if (Math.random()<probability && i!=j)
                {
                    addEdge(String.valueOf(vertex),String.valueOf(vertex1));
                }
                vertex1++;

            }
            vertex++;

        }
    }


    public void addVertex(String name)  {
        // name=new String();
        g.addVertex(name);
    }

    public void addEdge(String v1,String v2) {
        g.addEdge(v1, v2);
    }

    public UndirectedGraph<String, DefaultEdge> getGraph() {
        return g;
    }
}
