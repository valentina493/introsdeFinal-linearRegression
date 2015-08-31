package linearfitter.rest.model;

import java.awt.geom.Point2D;
import java.io.Serializable;
import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.PROPERTY)
public class ComputeXInput implements Serializable {
	private static final long serialVersionUID = 5536971339207869918L;

	@XmlElement ArrayList<Point2D.Double> inputPoints;
	@XmlElement double y;

	public ComputeXInput(){}
	
	public ArrayList<Point2D.Double> getInputPoints() {
		return inputPoints;
	}

	public void setInputPoints(ArrayList<Point2D.Double> inputPoints) {
		this.inputPoints = inputPoints;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}
}