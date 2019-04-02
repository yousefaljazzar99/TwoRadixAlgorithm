import javax.swing.*;

class Queue{
	QueueNode front;
	QueueNode rear;
	
	public boolean isEmpty(){
		if(front==null&&rear==null)
			return true;
			else return false;
	}
	
	public void enQueue(int x){
		QueueNode n=new QueueNode(x,null);
		if(isEmpty()){
			front=n;
			rear=n;
		}else{
			rear.next=n;
			rear=n;
		}
	}
	
	public QueueNode deQueue(){
		QueueNode temp;
		if(front==null)
			return null;
			
		temp=front;
		front=front.next;
		
		if(front==null)
			rear=null;
			
		return temp;
		
	}
	
	public void print(){
		QueueNode tempFront=front;
		QueueNode tempRear=rear;
		String m="";
		while(tempFront!=null&&tempRear!=null){
			m+=tempFront.num;
			m+="\n";
			tempFront=tempFront.next;
	}
		JOptionPane.showMessageDialog(null,m,"Unsorted",JOptionPane.PLAIN_MESSAGE);
	}
	
}