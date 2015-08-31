package linearfitter.rest.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(propOrder = {"slope", "yintercept"})
public class Line implements Serializable{
	private static final long serialVersionUID = -902060421155978856L;

	@XmlElement(name = "slope")
	private double slope;
	
	@XmlElement(name = "intercept")
	private double yintercept;
	
	public Line(double slope, double yintercept) {
		this.slope = slope;
		this.yintercept = yintercept;
	}
	
	public double getSlope() {
		return slope;
	}
	public void setSlope(double slope) {
		this.slope = slope;
	}
	public double getYintercept() {
		return yintercept;
	}
	public void setYintercept(double yintercept) {
		this.yintercept = yintercept;
	}
	
}
