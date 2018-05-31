package proz;

import java.util.List;

public class AverageCalculator {

	ResultAverage resultAverage = new ResultAverage();

	ResultAverage calculateAverage(List<NBPRate> rates) {
		Double tempMid = (double) 0;
		Double tempBid = (double) 0;
		Double tempAsk = (double) 0;

		for (NBPRate e : rates) {
			if (e.getMid() != null) {
				tempMid += e.getMid();
			}
			if (e.getBid() != null) {
				tempBid += e.getBid();
			}
			if (e.getAsk() != null) {
				tempAsk += e.getAsk();
			}
		}
		resultAverage.setAverageMid(tempMid / rates.size());
		resultAverage.setAverageBid(tempBid / rates.size());
		resultAverage.setAverageAsk(tempAsk / rates.size());

		return resultAverage;
	}
}
