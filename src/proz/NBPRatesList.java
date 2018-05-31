package proz;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "ExchangeRatesSeries")
public class NBPRatesList {
	private String table;
	private String currency;
	private String code;
	private List<NBPRate> rates;

	@XmlElement(name = "Table")
	public String getTable() {
		return table;
	}

	public void setTable(String table) {
		this.table = table;
	}

	@XmlElement(name = "Currency")
	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	@XmlElement(name = "Code")
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@XmlElementWrapper(name = "Rates")
	@XmlElement(name = "Rate")
	public List<NBPRate> getRates() {
		return rates;
	}

	public void setRates(List<NBPRate> rates) {
		this.rates = rates;
	}
}