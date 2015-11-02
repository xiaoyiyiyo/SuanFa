package com.kingyi.Dijkstra;

public class Dijkstra {  
	 public static void main(String[] args) {
	        // TODO Auto-generated method stub
	        int[][] weight = {
	                {0,3,9999999,7,9999999},
	                {3,0,4,2,9999999},
	                {9999999,4,0,5,6},
	                {7,2,5,0,4},
	                {9999999,9999999,6,4,0}
	        };   
	        Dijsktra(weight,0);
	    }
	     
	    public static void Dijsktra(int[][] weight,int start){
	        //接受一个有向图的权重矩阵，和一个起点编号start（从0编号，顶点存在数组中）
	        //返回一个int[] 数组，表示从start到它的最短路径长度
	        int n = weight.length;        //顶点个数
	        int[] visited = new int[n];        //标记当前该顶点的最短路径是否已经求出,1表示已求出
	        int[] shortPath = new int[n];    //存放从start到其他各点的最短路径
	        String pathShow[] = new String[n]; 
	        for (int i = 0; i < pathShow.length; i++) {
				pathShow[i] = (start+1)+"-->"+(i+1);
			}
	        //初始化，第一个顶点求出
	        shortPath[start] = 0;
	        visited[start] = 1;
	        for(int count = 1;count <= n - 1;count++)        //要加入n-1个顶点
	        {
	            int k = -1;    //选出一个距离初始顶点start最近的未标记顶点
	            int dmin = 1000;
	            for(int i = 0;i < n;i++)
	            {
	                if(visited[i] == 0 && weight[start][i] < dmin)
	                {
	                    dmin = weight[start][i];
	                    k = i;
	                }    
	            }
	           
	            //将新选出的顶点标记为已求出最短路径，且到start的最短路径就是dmin
	            shortPath[k] = dmin;
	            visited[k] = 1;
	             
	            //以k为中间点想，修正从start到未访问各点的距离
	            for(int i = 0;i < n;i++)
	            {
	                if(visited[i] == 0 && weight[start][k] + weight[k][i] < weight[start][i]){
	                     weight[start][i] = weight[start][k] + weight[k][i];
	                     pathShow[i] = pathShow[k]+"-->" + (i + 1); 
	                }
	            }    
	        }
	        System.out.println("路径\t距离");
	        for(int i = 0;i < pathShow.length;i++)
	            System.out.println(pathShow[i] + "  "+shortPath[i]);
	    } 
}  