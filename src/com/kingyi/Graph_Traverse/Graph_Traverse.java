package com.kingyi.Graph_Traverse;

import java.util.ArrayList;
import java.util.LinkedList;

public class Graph_Traverse {
	private ArrayList nodeList;		//存储节点
	private int[][] edges;			//存储边，权重
	private int numOfEdges;			//边的个数
	private LinkedList queue;		//辅助队列
	
	public Graph_Traverse(int n){
		nodeList = new ArrayList(n);
		edges = new int[n][n];
		numOfEdges = 0;
		queue = new LinkedList();
	}
	
	/*插入节点*/
	public void insertNode(Object node){
		nodeList.add(nodeList.size(), node);
	}
	
	/*插入边*/
	public void insertEdges(int n1,int n2, int weight){
		edges[n1][n2] = weight;
		++numOfEdges;
	}
	
	/*删除边*/
	public void deleteEdges(int n1,int n2){
		edges[n1][n2] = 0;
		--numOfEdges;
	}
	
	/*得到第一个邻接节点*/
	public int getFirstNeighbor(int n1){
		for (int i = 0; i < nodeList.size(); i++) {
			if(edges[n1][i] > 0){
				return i;
			}
		}
		return -1;
	}
	
	/*得到下一个邻接节点*/
	public int getNextNeighbor(int n1,int n2){
		for (int i = n2+1; i < nodeList.size(); i++) {
			if(edges[n1][i] > 0){
				return i;
			}
		}
		return -1;
	}
	
	private void broadFirstSearch(boolean[] isVisited,int index){
		int n,m;
		
		System.out.print(nodeList.get(index)+" "); //输出节点信息，并更改状态
		isVisited[index] = true;
		queue.addLast(index);						//节点入队列
		while(!queue.isEmpty()){					//队列为空，表示该节点的邻接节点全部遍历完
			n = (Integer)queue.removeFirst();
			m = getFirstNeighbor(n);				
			while(m != -1){							// =-1 表示没有邻接节点，需从下一级遍历了
				if(!isVisited[m]){
					System.out.print(nodeList.get(m)+" ");
					isVisited[m] = true;
					queue.addLast(m);
				}
				m = getNextNeighbor(n, m);			//寻找n的下一个邻接点
			}
		}
	}
	
	public void broadFirstSearch(){
		boolean isVisited[] = new boolean[nodeList.size()];
		for (int i = 0; i < nodeList.size(); i++) {
			isVisited[i] = false;
		}
		for (int i = 0; i < nodeList.size(); i++) {
			if(!isVisited[i]){
				broadFirstSearch(isVisited, i);
			}
			
		}
	}
	
	private void depthFirstSearch(boolean[] isVisited,int index){

        System.out.print(nodeList.get(index)+"  ");
        //置该结点为已访问
        isVisited[index]=true;

        int w=getFirstNeighbor(index);//
        while (w!=-1) {
            if (!isVisited[w]) {
                depthFirstSearch(isVisited,w);
            }
            w=getNextNeighbor(index, w);
        }
	}
	
	public void depthFirstSearch(){
		boolean isVisited[] = new boolean[nodeList.size()];
		for (int i = 0; i < nodeList.size(); i++) {
			isVisited[i] = false;
		}
		for (int i = 0; i < nodeList.size(); i++) {
			//考虑到非连通图
			if(!isVisited[i]){
				depthFirstSearch(isVisited, i);
			}
			
		}
	}
	
	public static void main(String[] args) {
		int n = 8, e = 9; // n 节点个数 e 边的条数
		Graph_Traverse graph = new Graph_Traverse(n);
		String labels[] = { "1", "2", "3", "4", "5", "6", "7", "8" };
		for (String label : labels) {
			graph.insertNode(label);// 插入结点
		}
		graph.insertEdges(0, 1, 1);
		graph.insertEdges(0, 2, 1);
		graph.insertEdges(1, 3, 1);
		graph.insertEdges(1, 4, 1);
		graph.insertEdges(3, 7, 1);
		graph.insertEdges(4, 7, 1);
		graph.insertEdges(2, 5, 1);
		graph.insertEdges(2, 6, 1);
		graph.insertEdges(5, 6, 1);
		graph.insertEdges(1, 0, 1);
		graph.insertEdges(2, 0, 1);
		graph.insertEdges(3, 1, 1);
		graph.insertEdges(4, 1, 1);
		graph.insertEdges(7, 3, 1);
		graph.insertEdges(7, 4, 1);
		graph.insertEdges(4, 2, 1);
		graph.insertEdges(5, 2, 1);
		graph.insertEdges(6, 5, 1);

		
		System.out.println("广度优先搜索序列为：");
		graph.broadFirstSearch();
		System.out.println();
		System.out.println("深度优先搜索序列为：");
		graph.depthFirstSearch();
		
	}
}
