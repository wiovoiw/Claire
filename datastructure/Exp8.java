import java.util.*;
class ArcNode{
	int adjvex;
	ArcNode nextarc;
	int weight;
}
class VNode{
	String[] data;
	ArcNode firstarc;
}
class AdjGraphClass{
	final int MAXV = 100;
	final int INF = 0x3f3f3f3f;
	VNode[] adjlist;
	int n, e;
	public AdjGraphClass(){
		adjlist = new VNode[MAXV];
		for(int i = 0; i< MAXV; i++)
		adjlist[i] = new VNode();
	}
	public void CreatAdjGraph(int[][] a, int n, int e){
		this.n = n; this.e = e;
		ArcNode p;
		for(int i = 0; i < n; i++)
			adjlist[i].firstarc = null;
		for(int i = 0; i < n; i++)
			for(int j = n - 1; j >= 0; j--)
				if(a[i][j] != 0 && a[i][j] != INF){
					p = new ArcNode();
					p.adjvex = j; p.weight = a[i][j];
					p.nextarc = adjlist[i].firstarc;
					adjlist[i].firstarc = p;
				}
	}
	public void DispAdjGraph(){
		ArcNode p;
		for(int i = 0; i < n; i++){
			System.out.printf("[%d]", i);
			p = adjlist[i].firstarc;
			while(p != null){
				System.out.printf("->(%d, %d)", p.adjvex, p.weight);
				p = p.nextarc;
			}
			System.out.println("->∧");
		}
	}
}
public class Exp8{
	static final int MAXV = 100;
	static int[] visited = new int[MAXV];
	static int cnt = 0;
	static void DFS(AdjGraphClass G, int u, int m, int[] path, int d){
		ArcNode p;
		visited[u] = 1;
		d++; path[d] = u;
		if(d == m){
			cnt++;
			System.out.print("路径" + cnt + ":");
			for(int i = 0; i <= d; i++)
				System.out.print(path[i] + "");
			System.out.println();
		}
		p = G.adjlist[u].firstarc;
		while(p != null){
			int w = p.adjvex;
			if(visited[w] == 0)
				DFS(G, w, m, path, d);
			p = p.nextarc;
		}
		visited[u] = 0;
		d--;
	}
	public static void main(String[] args){
		AdjGraphClass G = new AdjGraphClass();
		int n =6, e = 7;
		int[][] a = {{0, 1, 1, 1, 0, 0}, {1, 0, 1, 0, 0, 0}, {1, 1, 0, 1, 1, 1},{1, 0, 1, 0, 0, 0}, {0, 0, 1, 0, 0, 0}, {0, 0, 1, 0, 0, 0}};
		G.CreatAdjGraph(a, n ,e);
		System.out.printf("\n图G\n");
		G.DispAdjGraph();
		int u = 0, m = 3;
		System.out.println("起点 u = "+ u +", m = "+ m +"的求解结果");
		int path[] = new int[MAXV];
		Arrays.fill(visited, 0);
		DFS(G, u, m, path, -1);
	}
}