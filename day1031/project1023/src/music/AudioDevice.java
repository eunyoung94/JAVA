/*32���� �����ڰ� ���� ���� �ڵ带 �ۼ������� ���� �����̱⶧���� , 
���� Ŭ�������� �ݵ�� �����ؾ��� ����� �����Ѵ�.*/
package music;
abstract public class AudioDevice {
//���� ���� ��� 
//static�� �Բ� �����ڷ� �Ҹ��� ���Ѱ���
//abstract :�߻�����, �޼��忡 ���ϰ�� �극�̽� ���� �ҿ����� �޼��带 �ǹ��Ѵ�. 
//�п����� �޼��带 �� 1���� �����ϰ��ִٸ�, �� Ŭ������ �ҿ����� Ŭ�����̸�, �̷��� Ŭ������ �߻�Ŭ������� �Ѵ�. 
	abstract public void setVolume(); //�߻�޼������Ѵ�.
	abstract public void playMP3();//�߻�޼��� ����..
	//����������� 
	//MP������
}