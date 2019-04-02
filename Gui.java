import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class Gui implements ActionListener{
	Queue q=new Queue();
	Queue Qu[]=new Queue[10];
		
	static JFrame frame=new JFrame("Main Gui");
	
	public JLabel l1;
	public JButton b1,b2,b3,b4;
	public JTextField t1;
	
	public Gui(){
		frame.setLayout(null);
		
		l1 = new JLabel("Enter number from (0-999): ");
                 l1.setFont(new Font("Tahoma", Font.BOLD, 14));
		l1.setBounds(20,20,200,40);
		frame.add(l1);
		
		t1 = new JTextField();
		t1.setBounds(20,60,130,25);
		frame.add(t1);
		t1.setColumns(10);
		t1.addKeyListener(new KeyAdapter() {
    public void keyTyped(KeyEvent e) {
      char c = e.getKeyChar();
      if (!((c >= '0') && (c <= '9') ||
         (c == KeyEvent.VK_BACK_SPACE) ||
         (c == KeyEvent.VK_DELETE))) {
        e.consume();
      }
    }
  });
		
		b1 = new JButton("Add",new ImageIcon(this.getClass().getResource("/images/add.png")));
		b1.setBounds(20,100,140,25);
               b1.setFont(new Font("Tahoma", Font.BOLD, 14));
		frame.add(b1);
                
		b1.addActionListener(this);
		
		b2 = new JButton("Print Unsort",new ImageIcon(this.getClass().getResource("/images/unsort.png")));
		b2.setBounds(170,100,150,25);
                 b2.setFont(new Font("Tahoma", Font.BOLD, 14));
		frame.add(b2);
		b2.addActionListener(this);
		
		b3 = new JButton("Print Sort",new ImageIcon(this.getClass().getResource("/images/sort.png")));
		b3.setBounds(330,100,140,25);
                 b3.setFont(new Font("Tahoma", Font.BOLD, 14));
		frame.add(b3);
		b3.addActionListener(this);
                
                b4 = new JButton("Exit",new ImageIcon(this.getClass().getResource("/images/exit.png")));
		b4.setBounds(170,140,140,25);
               b4.setFont(new Font("Tahoma", Font.BOLD, 14));
		frame.add(b4);
                b4.addActionListener(this);
		
		frame.setVisible(true);
		frame.setSize(520,250);
		frame.setResizable(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==b1){
			int x=Integer.parseInt(t1.getText());
			if(x<0||x>999){
				JOptionPane.showMessageDialog(null, "You Have To Enter Number From (0-999)", "Error Message", JOptionPane.ERROR_MESSAGE);
			}else{
				q.enQueue(x);
			}
			t1.setText(null);
		}
		
		if(e.getSource()==b2){
			q.print();
		}
		
		if(e.getSource()==b3){
			for(int i=0;i<10;i++){
	    	Qu[i]=new Queue();
	    }
			pass1();
			for(int i=0;i<9;i++)
				concat(Qu[i],Qu[i+1],q);
			pass2();
			for(int i=0;i<9;i++)
				concat(Qu[i],Qu[i+1],q);
			pass3();
			for(int i=0;i<9;i++)
				concat(Qu[i],Qu[i+1],q);
			q.print();
		}
                if(e.getSource()==b4){
                System.exit(0);}
	}
	
	public void concat(Queue q1,Queue q2,Queue q3){
		    QueueNode temp;
			if(q3.isEmpty()&&q2.isEmpty()){
				temp=q1.deQueue();
				if(temp!=null)
				q3.enQueue(temp.num);
			}
			if(q3.isEmpty()&&q1.isEmpty()){
				temp=q2.deQueue();
				if(temp!=null)
				q3.enQueue(temp.num);
			}
			if(q1.isEmpty()&&q2.isEmpty()){
				return;
			}
			while(!(q1.isEmpty())){
				q3.enQueue(q1.deQueue().num);
			}
			while(!(q2.isEmpty())){
				q3.enQueue(q2.deQueue().num);
			}
	}
	
	
	public void pass1(){
		QueueNode temp;
		int j=0;
		while(!q.isEmpty()){
			temp=q.deQueue();
			if(temp!=null){
			j=temp.num%10;
			Qu[j].enQueue(temp.num);
			}
		}
	}
	
	public void pass2(){
		QueueNode temp;
		int j=0;
		while(!q.isEmpty()){
			temp=q.deQueue();
			if(temp!=null){
			j=temp.num%100;
			j=j/10;
			Qu[j].enQueue(temp.num);
			}
		}
	}
	
	public void pass3(){
		QueueNode temp;
		int j=0;
		while(!q.isEmpty()){
			temp=q.deQueue();
		if(temp!=null){
			j=temp.num/100;
			Qu[j].enQueue(temp.num);
			}
		}
	}
}