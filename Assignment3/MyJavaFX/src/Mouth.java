import javafx.scene.paint.Color; 
import javafx.scene.shape.Arc; 
import javafx.scene.shape.ArcType; 

public class Mouth{
	public Arc mouth;
	public Mouth(double centerX, double centerY, double radiusX, double radiusY, double startAngle, double length) {
		this.mouth = new Arc(centerX, centerY, radiusX, radiusY, startAngle, length);
	    this.mouth.setFill(Color.YELLOW);         
		this.mouth.setStroke(Color.BLUE);         
		this.mouth.setType(ArcType.OPEN);
	}
}
