package com.kingyi.graphtraverse;

import java.util.ArrayList;
import java.util.LinkedList;

public class GraphTraverse {
	private ArrayList nodeList;		//�洢�ڵ�
	private int[][] edges;			//�洢�ߣ�Ȩ��
	private int numOfEdges;			//�ߵĸ���
	private LinkedList queue;		//��������
	
	public GraphTraverse(int n){
		nodeList = new ArrayList(n);
		edges = new int[n][n];
		numOfEdges = 0;
		queue = new LinkedList();
	}
	
	/*����ڵ�*/
	public void insertNode(Object node){
		nodeList.add(nodeList.size(), node);
	}
	
	/*�����*/
	public void insertEdges(int n1,int n2, int weight){
		edges[n1][n2] = weight;
		++numOfEdges;
	}
	
	/*ɾ����*/
	public void deleteEdges(int n1,int n2){
		edges[n1][n2] = 0;
		--numOfEdges;
	}
	
	/*�õ���һ���ڽӽڵ�*/
	public int getFirstNeighbor(int n1){
		for (int i = 0; i < nodeList.size(); i++) {
			if(edges[n1][i] > 0){
				return i;
			}
		}
		return -1;
	}
	
	/*�õ���һ���ڽӽڵ�*/
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
		
		System.out.print(nodeList.get(index)+" "); //����ڵ���Ϣ��������״̬
		isVisited[index] = true;
		queue.addLast(index);						//�ڵ������
		while(!queue.isEmpty()){					//����Ϊ�գ���ʾ�ýڵ���ڽӽڵ�ȫ��������
			n = (Integer)queue.removeFirst();
			m = getFirstNeighbor(n);				
			while(m != -1){							// =-1 ��ʾû���ڽӽڵ㣬�����һ��������
				if(!isVisited[m]){
					System.out.print(nodeList.get(m)+" ");
					isVisited[m] = true;
					queue.addLast(m);
				}
				m = getNextNeighbor(n, m);			//Ѱ��n����һ���ڽӵ�
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
        //�øý��Ϊ�ѷ���
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
			//���ǵ�����ͨͼ
			if(!isVisited[i]){
				depthFirstSearch(isVisited, i);
			}
			
		}
	}
	
	public static void main(String[] args) {
		int n = 8, e = 9; // n �ڵ���� e �ߵ�����
		GraphTraverse graph = new GraphTraverse(n);
		String labels[] = { "1", "2", "3", "4", "5", "6", "7", "8" };
		for (String label : labels) {
			graph.insertNode(label);// ������
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

		
		System.out.println("���������������Ϊ��");
		graph.broadFirstSearch();
		System.out.println();
		System.out.println("���������������Ϊ��");
		graph.depthFirstSearch();
		
	}
}
