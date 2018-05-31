package proz;

public class ResultAverage {
	private Double averageMid;
	private Double averageBid;
	private Double averageAsk;

	ResultAverage() {
		setAverageMid(null);
		setAverageBid(null);
		setAverageAsk(null);
	}

	public Double getAverageMid() {
		return averageMid;
	}

	public void setAverageMid(Double averageMid) {
		this.averageMid = averageMid;
	}

	public Double getAverageBid() {
		return averageBid;
	}

	public void setAverageBid(Double averageBid) {
		this.averageBid = averageBid;
	}

	public Double getAverageAsk() {
		return averageAsk;
	}

	public void setAverageAsk(Double averageAsk) {
		this.averageAsk = averageAsk;
	}
}
