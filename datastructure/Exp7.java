import java.util.*;

	class BTreeClass {
		BTNode<Character>b;	// 二叉树的根节点
		String bstr;		// 保存二叉树的字符串表示	

		// 构造方法，初始化根节点为 null
		public BTreeClass(){
			b = null;
		}
	
		// 创建二叉树的方法，根据输入的字符串表示构建二叉树
		public void CreateBTree(String str){
			Stack<BTreeClass.BTNode<Character>> st = new Stack<>();   //在Java中，推荐使用泛型来确保类型的安全性。为解决警告，将 BTNode 类型改为 BTNode<Character>，因为二叉树是存储字符的。
			BTNode<Character> p = null;
			boolean flag = true;
			char ch;
			int i = 0;
			while(i < str.length()){
				ch = str.charAt(i);
				switch(ch){
					case'(':
						st.push(p);
						flag = true;
						break;
					case')':
						st.pop();
						break;
					case',':
						flag = false;
						break;
					default:
						p = new BTNode<Character>(ch);
						if (b == null) 
							b = p;
						else{
							if (flag) {
								if (!st.empty()) 
									st.peek().lchild = p;
							}
							else{
								if(!st.empty())
									st.peek().rchild = p;
							}
						}
						break;
				}
				i++;
			}
		}

		// 将二叉树转换为字符串表示的方法
		public String toString(){
			bstr = "";
			toString1(b);
			return bstr;
		}
		// 辅助方法，递归遍历二叉树并构建字符串表示
		private void toString1(BTNode<Character> t){
			if(t != null){
				bstr += t.data;
				if(t.lchild != null || t.rchild != null){
					bstr += "(";
					toString1(t.lchild);
					if(t.lchild != null)
						bstr += ",";
					toString1(t.rchild);
					bstr += ")";
				}
			}
		}
		
		// 二叉树节点的定义
		class BTNode<E>{
			E data;				// 节点数据
			BTNode<E> lchild;  //为确保类型的一致性和类型安全性。在Java中，如果有一个泛型类（BTNode<E>），最好是将类中所有涉及泛型的地方都使用相同的泛型参数。可避免使用原始类型，提高代码的类型安全性。
			BTNode<E> rchild;  //原始的 BTNode 类型在Java中被认为是不安全的，因为它不提供泛型参数的类型检查。使用泛型参数，如 BTNode<E>，可以更好地表达类的意图，同时在使用时提供更好的类型检查。
			  //不是绝对必须的，但是这样做有助于提高代码的可读性和可维护性，并减少可能的错误。

			// 无参构造方法，初始化左右子节点为 null
			public BTNode(){
				lchild = rchild = null;
			}
			// 带参数的构造方法，初始化数据和左右子节点为 null
			public BTNode(E d){
				data = d;
				lchild = rchild = null;
			}
		}
	}

public class Exp7{
	// 求解所有路径的方法
	public static void AllPath1(BTreeClass bt){
		char[]path = new char[100];
		int d = -1;
		PreOrder(bt.b,path,d);
	}
	// 递归遍历二叉树，找到所有从根节点到叶子节点的路径
	private static void PreOrder(BTreeClass.BTNode<Character>t, char[]path, int d){
		if(t != null){
			if(t.lchild == null && t.rchild == null){
				System.out.printf("        根节点到%c的路径: ", t.data);
				for(int i = 0; i <= d; i++)
					System.out.print(path[i] + " ");  //打印空格，看起来美观
				System.out.println(t.data);
			}
			else{
				d ++;
				path[d] = t.data;
				PreOrder(t.lchild, path, d);
				PreOrder(t.rchild, path, d);
			}
		}
	}
	// 解决问题的方法
	public static void solve(BTreeClass bt){
		System.out.println();
		System.out.println("求解结果");
		System.out.println("解法1: ");
		AllPath1(bt);
	}
	// 主方法
	public static void main(String[] args){
		String s = "A(B(D(, F(H)), E(G)), C)";
		BTreeClass bt = new BTreeClass();
		bt.CreateBTree(s);
		System.out.println();
		System.out.println("bt: " + bt.toString());
		solve(bt);
	}
}
