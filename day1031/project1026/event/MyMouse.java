package event;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
class MyMouse implements MouseListener{
	//마우스를 클릭했을때, 마우스클릭했어? 라는 메세지가 띄어지게
	public void mouseClicked(MouseEvent e){
		System.out.println("마우스 클릭했어?");
	}
	public void	mouseEntered(MouseEvent e){
	}
	public void mouseExited(MouseEvent e){
	}
	public void mousePressed(MouseEvent e){
	}
	public void mouseReleased(MouseEvent e){
	}
			
}
