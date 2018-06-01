package proz;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("exchangerates/rates")
public class CurrencyAverageInfo {

	NBPConnector nbpConnector = new NBPConnector();

	@Produces(MediaType.TEXT_HTML)
	private Response getParamHTML(ResultAverage resultAverage, String table, String code, Integer topCount) {

		String response = "<html><body>" + "<h3>" + "Table: " + table + "   Code: " + code + "   TopCount: " + topCount
				+ "</h3>" + "<h3>" + "AvgMid: " + resultAverage.getAverageMid().toString() + "</h3>" + "<h3>"
				+ "AvgBid: " + resultAverage.getAverageBid().toString() + "</h3>" + "<h3>" + "AvgAsk: "
				+ resultAverage.getAverageAsk().toString() + "</h3></body></html>";

		return Response.status(Response.Status.OK).entity(response).build();
	}

	@Produces(MediaType.TEXT_XML)
	private Response getParamXML(ResultAverage resultAverage, String table, String code, Integer topCount) {

		String response = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>" + "<result>" + "<table>"
				+ table + "</table>" + "<code>" + code + "</code>" + "<topCount>" + topCount.toString() + "</topCount>"
				+ "<avgs>" + "<avgMid>" + resultAverage.getAverageMid().toString() + "</avgMid>" + "<avgBid>"
				+ resultAverage.getAverageBid().toString() + "</avgBid>" + "<avgAsk>"
				+ resultAverage.getAverageAsk().toString() + "</avgAsk>" + "</avgs>" + "</result>";

		return Response.status(Response.Status.OK).entity(response).type(MediaType.TEXT_XML).build();
	}

	@Produces(MediaType.TEXT_PLAIN)
	private Response getParamTEXT(ResultAverage resultAverage, String table, String code, Integer topCount) {

		String response = " Table: " + table + "   Code: " + code + "   TopCount: " + topCount + " AvgMid: "
				+ resultAverage.getAverageMid().toString() + " AvgBid: " + resultAverage.getAverageBid().toString()
				+ " AvgAsk: " + resultAverage.getAverageAsk().toString();
		return Response.status(Response.Status.OK).entity(response).build();
	}

	@Produces(MediaType.APPLICATION_JSON)
	private Response getParamJSON(ResultAverage resultAverage, String table, String code, Integer topCount) {

		JsonObjectBuilder objBuilder = Json.createObjectBuilder();
		objBuilder.add("table", table).add("code", code).add("topCount", topCount)
				.add("AvgMid", resultAverage.getAverageMid().toString())
				.add("AvgBid", resultAverage.getAverageBid().toString())
				.add("AvgAsk", resultAverage.getAverageAsk().toString());
		JsonObject jsonObj = objBuilder.build();

		return Response.status(Response.Status.OK).entity(jsonObj.toString()).build();
	}

	@GET
	@Path(("{table}/{code}/{topCount}"))
	public Response getParams(@DefaultValue("html") @QueryParam("format") String format,
			@PathParam("table") String table, @PathParam("code") String code, @PathParam("topCount") Integer topCount) {

		ResultAverage resultAverage = nbpConnector.Connect(table, code, topCount);

		if (format.equals("xml"))
			return getParamXML(resultAverage, table, code, topCount);
		if (format.equals("text"))
			return getParamTEXT(resultAverage, table, code, topCount);
		if (format.equals("json"))
			return getParamJSON(resultAverage, table, code, topCount);
		else
			return getParamHTML(resultAverage, table, code, topCount);
	}

}
