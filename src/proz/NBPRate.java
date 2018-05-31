package proz;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Rate")
public class NBPRate {
	private String no;
	private Date effectiveDate;
	private Double mid;
	private Double bid;
	private Double ask;

	@XmlElement(name = "No")
	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	@XmlElement(name = "EffectiveDate")
	public Date getEffectiveDate() {
		return effectiveDate;
	}

	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	@XmlElement(name = "Mid")
	public Double getMid() {
		return mid;
	}

	public void setMid(Double mid) {
		this.mid = mid;
	}

	@XmlElement(name = "Bid")
	public Double getBid() {
		return bid;
	}

	public void setBid(Double bid) {
		this.bid = bid;
	}

	@XmlElement(name = "Ask")
	public Double getAsk() {
		return ask;
	}

	public void setAsk(Double ask) {
		this.ask = ask;
	}

}
