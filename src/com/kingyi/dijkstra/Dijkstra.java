package com.kingyi.dijkstra;

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
	        //����һ������ͼ��Ȩ�ؾ��󣬺�һ�������start����0��ţ�������������У�
	        //����һ��int[] ���飬��ʾ��start���������·������
	        int n = weight.length;        //�������
	        int[] visited = new int[n];        //��ǵ�ǰ�ö�������·���Ƿ��Ѿ����,1��ʾ�����
	        int[] shortPath = new int[n];    //��Ŵ�start��������������·��
	        String pathShow[] = new String[n]; 
	        for (int i = 0; i < pathShow.length; i++) {
				pathShow[i] = (start+1)+"-->"+(i+1);
			}
	        //��ʼ������һ���������
	        shortPath[start] = 0;
	        visited[start] = 1;
	        for(int count = 1;count <= n - 1;count++)        //Ҫ����n-1������
	        {
	            int k = -1;    //ѡ��һ�������ʼ����start�����δ��Ƕ���
	            int dmin = 1000;
	            for(int i = 0;i < n;i++)
	            {
	                if(visited[i] == 0 && weight[start][i] < dmin)
	                {
	                    dmin = weight[start][i];
	                    k = i;
	                }    
	            }
	           
	            //����ѡ���Ķ�����Ϊ��������·�����ҵ�start�����·������dmin
	            shortPath[k] = dmin;
	            visited[k] = 1;
	             
	            //��kΪ�м���룬������start��δ���ʸ���ľ���
	            for(int i = 0;i < n;i++)
	            {
	                if(visited[i] == 0 && weight[start][k] + weight[k][i] < weight[start][i]){
	                     weight[start][i] = weight[start][k] + weight[k][i];
	                     pathShow[i] = pathShow[k]+"-->" + (i + 1); 
	                }
	            }    
	        }
	        System.out.println("·��\t����");
	        for(int i = 0;i < pathShow.length;i++)
	            System.out.println(pathShow[i] + "  "+shortPath[i]);
	    } 
}  