package testtest;
//www.xuebuyuan.com/2000074.html

public class Peterson implements Runnable{
	//主观地表示某一个线程是否希望使用资源
	private static boolean[] in = {false,false};
	//客观地表示哪一个线程有权使用进程
	private static volatile int turn = 0;
	private final int id;
	
	public Peterson(int i){
		id = i;
	}
	
	private int other(){
		return id == 0 ? 1 : 0;
	}
	
	@Override
	public void run() {
		//表示本线程希望使用资源
		in[id] = true;
		//谦让，把使用线程的权限让给对方
		turn = other();
		//如果对方线程想使用资源，且有使用权限
		while(in[other()] && turn == other()){
			System.out.println("["+id+"] - waiting...");
		}
		System.out.println("["+id+"] - working ( [" + other() + "]" + ((!in[other()])?"do other":"wait to turn")+")");
		//本线程使用完资源，表示不再想用资源
		in[id] = false;
	}
	
	public static void main(String[] args) {
		new Thread(new Peterson(0),"Thread-0").start();
		new Thread(new Peterson(1),"Thread-1").start();
	} 
}
