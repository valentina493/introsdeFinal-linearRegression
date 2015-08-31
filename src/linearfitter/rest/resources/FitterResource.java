package linearfitter.rest.resources;

import java.awt.geom.Point2D;
import java.util.ArrayList;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import linearfitter.rest.model.ComputeXInput;
import linearfitter.rest.model.ComputeYInput;
import linearfitter.rest.model.Line;

@Stateless
@LocalBean
@Path("/fit")
public class FitterResource {

	@Context
	UriInfo uriInfo;
	@Context
	Request request;

	@POST
	@Path("getline")
	@Produces({ MediaType.APPLICATION_JSON})
	@Consumes({ MediaType.APPLICATION_JSON })
	public Line getLine(ArrayList<Point2D.Double> inputPoints) {
		if(inputPoints.size() < 2){
			throw new WebApplicationException(Response.Status.BAD_REQUEST);
		}
		return fit(inputPoints);
	}

	@POST
	@Path("computeYgivenX")
	@Produces({ MediaType.APPLICATION_JSON})
	@Consumes({ MediaType.APPLICATION_JSON })
	public Result computeYgivenX(ComputeYInput in) {
		if(in.getInputPoints().size() < 2){
			throw new WebApplicationException(Response.Status.BAD_REQUEST);
		}
		
		Line l = fit(in.getInputPoints());
		Result r = new Result();
		r.output = l.getSlope() * in.getX() + l.getYintercept();
		r.line = l;
		
		return r;
	}

	@POST
	@Path("computeXgivenY")
	@Produces({ MediaType.APPLICATION_JSON})
	@Consumes({ MediaType.APPLICATION_JSON })
	public Result computeXgivenY(ComputeXInput in) {
		if(in.getInputPoints().size() < 2){
			throw new WebApplicationException(Response.Status.BAD_REQUEST);
		}
		
		Line l = fit(in.getInputPoints());

		Result r = new Result();
		r.output = (in.getY() - l.getYintercept()) / l.getSlope();
		r.line = l;
		
		return r;
	}

	private Line fit(ArrayList<Point2D.Double> inputPoints) {

		double sumOfXY = 0.0, sumOfX = 0.0, sumOfY = 0.0, sumOfXsecond = 0.0;
		double averageX, averageY;
		int n = inputPoints.size();
		double a, b; //b : slope, a : intercept

		for (Point2D.Double point : inputPoints) {
			sumOfX += point.x;
			sumOfY += point.y;
			sumOfXsecond += Math.pow(point.x, 2.0);
			sumOfXY += point.x * point.y;
		}

		averageX = sumOfX / n;
		averageY = sumOfY / n;

		b = (sumOfXY - n * averageX * averageY) / (sumOfXsecond - n * Math.pow(averageX, 2.0));
		a = averageY - b * averageX;

		return new Line(b, a);
	}

	@XmlRootElement
	@XmlAccessorType(XmlAccessType.PROPERTY)
	private class Result {
		@XmlElement double output;
		@XmlElement Line line;

		public Result() {}
	}

}
