import org.jgrapht.alg.ConnectivityInspector;

public class Main {

    public static void main(String[] args) {

        RandomGraph randomGraph = new RandomGraph(0.5,10);
        randomGraph.GenerateGraph();
        ConnectivityInspector connectivityInspector = new ConnectivityInspector(randomGraph.g);
        while (!connectivityInspector.isGraphConnected())
        {
            randomGraph.GenerateGraph();
            connectivityInspector = new ConnectivityInspector(randomGraph.g);
        }
        randomGraph.display();
        System.out.println(randomGraph.midShortestPath());




    }
}
