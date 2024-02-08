//Lea Frost
import java.io.FileWriter;
import java.io.PrintWriter;

public class LinkedBST <Shape extends Comparable<Shape>>
{
	private class Node
	{
		Shape data;
		Node leftChild;
		Node rightChild;
		public Node(Shape aData)
		{
			data = aData;
			leftChild = rightChild = null;
		}
	}
	private Node root;//head
	public LinkedBST()
	{
		root = null;
	}
	
	public void add(Shape aData)
	{
		if(root == null)
			root = new Node(aData);
		else//recursively add the element
			add(root, aData);
	}
	private Node add(Node aNode, Shape aData)
	{
		if(aNode == null)//we have reached a leaf
			aNode = new Node(aData);
		else if(aData.compareTo(aNode.data)<0)//Go left
			aNode.leftChild = add(aNode.leftChild, aData);
		else if (aData.compareTo(aNode.data)>0)//go right
			aNode.rightChild = add(aNode.rightChild, aData);
		return aNode;
			
	}
	public void printPreorder()
	{
		printPreorder(root);
	}
	private void printPreorder(Node aNode)
	{
		if(aNode == null)//reached a leaf
			return;
		System.out.println(aNode.data);//Process
		printPreorder(aNode.leftChild);//left
		printPreorder(aNode.rightChild);//right
	}
	public void printInorder()
	{
		printInorder(root);
	}
	private void printInorder(Node aNode)
	{
		if(aNode == null)
			return;
		printInorder(aNode.leftChild);//Left
		System.out.println(aNode.data);//process
		printInorder(aNode.rightChild);//Right
	}
	public void printPostorder()
	{
		printPostorder(root);
	}
	private void printPostorder(Node aNode)
	{
		if(aNode == null)
			return;
		printInorder(aNode.leftChild);//Left
		printInorder(aNode.rightChild);//Right
		System.out.println(aNode.data);//process
	}
	public boolean search(Shape aData)
	{
		return search(root, aData);//start from root, search for aData
	}
	private boolean search(Node aNode, Shape aData)
	{
		if(aNode == null)
			return false;
		else if(aData.compareTo(aNode.data)<0)//go left
			return search(aNode.leftChild,aData);
		else if(aData.compareTo(aNode.data)>0)
			return search(aNode.rightChild, aData);
		else
			return true;
			
	}
	public void remove(Shape aData)
	{
		root = remove(root,aData);
		
	}
	public Node remove(Node aNode, Shape aData)
	{
		//find the node
		if(aNode==null)
			return null;
		else if (aData.compareTo(aNode.data)<0)
			aNode.leftChild = remove(aNode.leftChild,aData);
		else if(aData.compareTo(aNode.data)>0)
			aNode.rightChild = remove(aNode.rightChild,aData);
		else//once node is found, remove and replace node
		{
			if(aNode.rightChild == null)
				return aNode.leftChild;
			else if(aNode.leftChild==null)
				return aNode.rightChild;
			Node temp = findMinInTree(aNode.rightChild);
			aNode.data = temp.data;
			aNode.rightChild = remove(aNode.rightChild, temp.data);
		}
		return aNode;
	}
	private Node findMinInTree(Node aNode)
	{
		if(aNode == null)//iff tree is empty
			return null;
		else if (aNode.leftChild == null)//return leftmost node
			return aNode;
		else 
			return findMinInTree(aNode.leftChild);//keep going until null is found
	}
	public Shape getMax()
	{
		return findMaxInTree(root).data;
	}
	private Node findMaxInTree(Node aNode)
	{
		if(aNode == null)//if tree is empty
			return null;
		else if (aNode.rightChild == null)//return rightmost node
			return aNode;
		else 
			return findMaxInTree(aNode.rightChild);//keep going until null is found
	}
	public void writeFile(String file)
	{
		try {
			PrintWriter fileWriter = new PrintWriter(new FileWriter(file));
			writeFile(root, fileWriter);
			fileWriter.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	private void writeFile(Node aNode, PrintWriter fileWriter)
	{
		
		if(aNode==null)
			return;
		
		writeFile(aNode.leftChild, fileWriter);
		fileWriter.print(aNode.data);
		writeFile(aNode.rightChild, fileWriter);
	}
	
	
}












