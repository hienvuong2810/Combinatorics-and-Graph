import java.util.*; 
import java.lang.*; 
import java.io.*; 
  
class MST 
{ 
    // So Dinh
    private static final int V=6; 
  
    int minKey(int key[], Boolean mstSet[]) 
    { 
        
        int min = Integer.MAX_VALUE, min_index=-1; 
  
        for (int v = 0; v < V; v++) 
            if (mstSet[v] == false && key[v] < min) 
            { 
                min = key[v]; 
                min_index = v; 
            } 
  
        return min_index; 
    } 
  
    void printMST(int parent[], int n, int graph[][]) 
    { 
        System.out.println("Edge \tWeight"); 
        for (int i = 1; i < V; i++) 
            System.out.println(parent[i]+1+" - "+ (i+1)+"\t"+ 
                            graph[i][parent[i]]); 
    } 
  
    void primMST(int graph[][]) 
    { 
        int parent[] = new int[V]; 
        int key[] = new int [V]; 
        // Dinh chua xet
        Boolean mstSet[] = new Boolean[V]; 
  
        // Dinh chua xet gan INF
        for (int i = 0; i < V; i++) 
        { 
            key[i] = Integer.MAX_VALUE; 
            mstSet[i] = false; 
        } 
  
        // Gan Dinh bat dau
        key[0] = 0;     // Gan key 0
                        
        parent[0] = -1; // Khong co parent gan -1
  
        for (int count = 0; count < V-1; count++) 
        { 
            // Chon Dinh lien ke chua xet
            int u = minKey(key, mstSet); 
  
            // Danh dau da chon
            mstSet[u] = true; 
  
            //Cap nhat key va parent dinh lien ke da chon
            for (int v = 0; v < V; v++) 
  
                //Chi Cap nhat khi gia tri nho hon gia tri hien tai cua Dinh
                if (graph[u][v]!=0 && mstSet[v] == false && 
                    graph[u][v] < key[v]) 
                { 
                    parent[v] = u; 
                    key[v] = graph[u][v]; 
                } 
        } 
  
        //In MST
        printMST(parent, V, graph); 
    } 
  
    public static void main (String[] args) 
    { 
        MST mst_test = new MST(); 
        int graph[][] = new int[][] {{0, 6, 1, 5, 0, 0}, 
                                    {6, 0, 5, 0, 4, 0}, 
                                    {1, 5, 0, 5, 6, 4}, 
                                    {5, 0, 5, 0, 0, 2}, 
                                    {0, 3, 6, 0, 0, 6},
									{0, 0, 4, 2, 6, 0}}; 
  
        // Xuat Kqua
        mst_test.primMST(graph); 
    } 
} 