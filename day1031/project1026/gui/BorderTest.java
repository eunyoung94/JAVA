/*���� ������Ʈ�� �÷����� ����, ���������� �÷��������� �����ϴ� ���� ��ġ���ϸ� AWT���� �����ϴ� ��ġ�� ������ ���� 5���� ������ �ִ�. 
1)FlowLayout:��������� �þ�� ��ġ���, ���� ������ �����ϴٸ� ���������� ��������. �����̳��� ũ�⿡ ���� �帣�� ��ġ�� �ǹǷ� flow��� ���̺ο��Ǿ���.
2)BorderLayout: ��,��,��,��,�߾� �̶�� ������ ���� ��ġ���
3)GridLayout: ���� �� �ٵ��� ����� ��ġ���
4)CardLayout: ī��ó�� �ϳ��� ī�尡 ���϶��� �ٸ� ī�尡 �Ⱥ��̴� ����� ��ġ
GridBagLayout : GridLayout�� �ȼ������� ���� ���ϰ� ������ �� �ִ� ��ġ��� 
��ǻ� 1,2,3 �������ε� ����� ���߰�����...
*/
package gui;
import java.awt.Frame;
import java.awt.Button;
import java.awt.BorderLayout;
class BorderTest{
	public static void main(String[]args){
	//Frame����
	Frame frame = new Frame();
	//BorderLayout�н� 
	Button bt_north=new Button("North");
	Button bt_south=new Button("south");
	Button bt_west=new Button("west");
	Button bt_east=new Button("east");
	Button bt_center=new Button("center");

	//1.BorderLayout����
	frame.setLayout(new BorderLayout());

	//��ư�� �����ӿ� ���̱� ,  
	frame.add(bt_north,BorderLayout.NORTH); //���ʿ� ��ư����
	frame.add(bt_south,BorderLayout.SOUTH);
	frame.add(bt_west,BorderLayout.WEST);
	frame.add(bt_east,BorderLayout.EAST);
	frame.add(bt_center);//���ʹ� ������� �ʾƵ� ����Ʈ�̱⶧���� �����ص� ����ȴ�.
	//�����Ӽ��� 
	frame.setSize(250,200);
	frame.setVisible(true);
	
	}
}
