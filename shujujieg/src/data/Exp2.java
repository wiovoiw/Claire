package data;

class BSTACK 							//共享栈类
{
	final int MaxSize=5;
	int[] S;							//存放共享栈中的元素
	int top1,top2;						//两个栈顶指针
	public BSTACK()						//构造方法，栈初始化
	{
		S=new int[MaxSize];
		top1=-1;
		top2=MaxSize;
	}
	//-----判栈空算法------
	public boolean empty(int i)				//i=1：栈1，i=2：栈2
	{	if (i==1)
			return(top1==-1);
		else if (i==2)					//i=2
			return(top2==MaxSize);
		else
			throw new IllegalArgumentException("i错误");
	}
	//-----判栈满算法------
	public boolean full()
	{
		return top1==top2-1;

	}
	//-----进栈算法------
	public void push(int i,int x)			//i=1：栈1，i=2：栈2
	{	if (full())					//栈满
			throw new IllegalArgumentException("栈满");
		if (i==1)						//x进栈S1
		{
			top1++;
			S[top1]=x;
		}
		else if (i==2)					//x进栈S2
		{	top2--;
			S[top2]=x;
		}
		else							//参数i错误返回0
			throw new IllegalArgumentException("i错误");
	}
	//-----出栈算法------
	public int pop(int i) 					//i=1：栈1，i=2：栈2
	{	int x;
		if (i==1)						//S1出栈
		{	if (empty(1))					//S1栈空
				throw new IllegalArgumentException("栈1空");
			else						//出栈S1的元素
			{	x=S[top1];
				top1--;
			}
		}
		else if (i==2)					//S2出栈
		{	if (empty(2))					//S2栈空
				throw new IllegalArgumentException("栈2空");
			else						//出栈S2的元素
			{	x=S[top2];
				top2++;
			}
		}
		else							//参数i错误返回0
			throw new IllegalArgumentException("i错误");
		return x;						//操作成功返回1
	}
}
public class Exp2
{
	public static void main(String[] args)
	{
		BSTACK st=new BSTACK();
		System.out.println("");		
		System.out.println("  (1)新建立栈st");		
		System.out.println("    栈1空? "+st.empty(1));
		System.out.println("    栈2空? "+st.empty(2));
		int [] a={1,2,3};
		int [] b={4,5,6,7};
		System.out.println("  (2)栈1的进栈操作");		
		for (int i=0;i<a.length;i++)
		{
			if (!st.full())
			{	System.out.println("    "+a[i]+"进栈1");
				st.push(1,a[i]);
			}
			else
				System.out.println("    "+a[i]+"进栈:栈满不能进栈");
		}
		System.out.println("    栈1空? "+st.empty(1));
		System.out.println("  (3)栈2的进栈操作");		
		for (int i=0;i<b.length;i++)
		{
			if (!st.full())
			{	System.out.println("    "+b[i]+"进栈2");
				st.push(2,b[i]);
			}
			else
				System.out.println("    "+b[i]+"进栈:栈满不能进栈");
		}
		System.out.println("    栈2空? "+st.empty(2));
		
		System.out.println("  (4)栈1的出栈操作");				
		while (!st.empty(1))
			System.out.println("    出栈1元素"+st.pop(1));
		System.out.println("  (5)栈2的出栈操作");				
		while (!st.empty(2))
			System.out.println("    出栈2元素"+st.pop(2));
			
	}	   
}
