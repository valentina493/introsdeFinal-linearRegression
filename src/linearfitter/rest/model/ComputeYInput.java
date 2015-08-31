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
public class ComputeYInput implements Serializable {
	private static final long serialVersionUID = 6837575347609572021L;

	@XmlElement ArrayList<Point2D.Double> inputPoints;
	@XmlElement double x;

	public ComputeYInput(){}

	public ArrayList<Point2D.Double> getInputPoints() {
		return inputPoints;
	}

	public void setInputPoints(ArrayList<Point2D.Double> inputPoints) {
		this.inputPoints = inputPoints;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}
}