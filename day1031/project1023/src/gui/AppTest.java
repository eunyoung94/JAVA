/*���ݱ����� �ֿܼ����� �ڹٸ� �����������, �ڹٵ� �׷��� API�� �����Ѵ�. 
 �ڹ��� ������� ��ư�� �����غ���..
*/
package gui;
import java.awt.Frame; /*�������� ��ġ����*/
import java.awt.Button; /*�������� ��ġ����*/

class AppTest{
	public static void main(String[] args){
	//�ڹٿ����� �������� ������ ���ִ� Ŭ������ Frame�� �����Ѵ�. 
		Frame frame; //Sun���� ������ Ŭ�����̹Ƿ� ������ ����. ���� Sun���� �����ϴ� ���� ������ ���� ��ġ�� �˾Ƴ���..

		frame=new Frame();//������ ����..
		frame.setSize(300,400);//������ �����쿡 �ʺ�,���� �ֱ�
		frame.setVisible(true);//�������� �Ӽ��� ���̰� ó��

		//��ư �����Ͽ�, �����ӿ� ���̱� 
		Button bt = new Button("����");
		frame.add(bt);
	}
}
