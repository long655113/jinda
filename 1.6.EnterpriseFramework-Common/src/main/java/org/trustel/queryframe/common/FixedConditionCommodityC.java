package org.trustel.queryframe.common;

public class FixedConditionCommodityC implements IFixedCondition {
	@Override
	public String generateFixCondition() {
		String sqlPart=" Classify_ID LIKE CONCAT(CONCAT('%;',#CLASSIFY_ID#),';%') AND ";
		
		return sqlPart;
	}
}
