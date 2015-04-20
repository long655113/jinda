package org.trustel.queryframe.common;

public class FixedConditionCommodityP implements IFixedCondition {
	@Override
	public String generateFixCondition() {
		String sqlPart=" Programs_ID LIKE CONCAT(CONCAT('%;',#PROGRAMS_ID#),';%') AND ";
		
		return sqlPart;
	}
}
