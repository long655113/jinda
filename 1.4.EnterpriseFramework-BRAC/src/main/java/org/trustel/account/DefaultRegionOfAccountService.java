package org.trustel.account;

import java.util.List;

import org.trustel.system.AbstractRegion;

public class DefaultRegionOfAccountService implements IRegionOfAccountService {

	public String getRegionHBMCondition(CommonAccount account,
			String fieldName, int orgid) {
		AbstractRegion region = account._region;
		if (orgid > 0)
			region = hasRegionPrivilege(account, orgid);

		if (region == null)
			return "1=2";
		else
			return String
					.format("%s in (select id from Region where rank%d=%d)",
							new Object[] { fieldName, region.getRank(),
									region.getId() });
	}

	public String getRegionJDBCCondition(CommonAccount account,
			String fieldName, int orgid) {
		return null;
	}

	public AbstractRegion hasRegionPrivilege(CommonAccount account, int regionId) {
		List<?> regions = account._regions;
		if (regions != null)
			for (int i = 0; i < regions.size(); i++) {
				AbstractRegion org = (AbstractRegion) regions.get(i);
				if (org.getId() == regionId)
					return org;
			}
		return null;
	}

}
