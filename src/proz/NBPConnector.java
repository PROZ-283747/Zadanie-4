package proz;

import java.io.StringReader;
import java.net.URI;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class NBPConnector {

	ResultAverage Connect(String table, String code, Integer topRates) {

		Client client = ClientBuilder.newClient();
		URI uri = UriBuilder.fromUri("http://api.nbp.pl/api/exchangerates/rates").build();
		WebTarget webTarget = client.target(uri);
		webTarget = webTarget.path(table).path(code).path("last").path(topRates.toString());

		String xmlAnswer = webTarget.request().accept(MediaType.TEXT_XML).get(String.class);

		NBPRatesList nbpRatesList = new NBPRatesList();
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(NBPRatesList.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			StringReader reader = new StringReader(xmlAnswer);
			nbpRatesList = (NBPRatesList) jaxbUnmarshaller.unmarshal(reader);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		AverageCalculator averageCalculator = new AverageCalculator();

		return averageCalculator.calculateAverage(nbpRatesList.getRates());
	}
}
