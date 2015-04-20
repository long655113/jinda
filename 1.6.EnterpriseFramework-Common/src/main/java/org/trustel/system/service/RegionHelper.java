package org.trustel.system.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.trustel.account.CommonAccount;
import org.trustel.common.Utils;
import org.trustel.service.IEnterpriseService;
import org.trustel.service.sql.QueryBuilder;
import org.trustel.system.Region;
import org.trustel.util.ParameterFactory;

public class RegionHelper {

	private static RegionHelper instance;

	private RegionHelper() {
	}

	private List<?> regions = null;

	private Date lastUpdated = new Date();

	public static RegionHelper getInstance() {
		if (instance == null)
			instance = new RegionHelper();
		return instance;
	}

	private void updateCache(IEnterpriseService service) {
		QueryBuilder query = new QueryBuilder(Region.class);
		int interval = ParameterFactory.getInt("REGION_RELOAD_INTERVAL", 60);
		Date d = Utils.add(new Date(), Utils.TIME_MINUTE,
				interval > 0 ? -interval : -5);

		if (regions == null || d.before(lastUpdated)) {
			regions = service.query(query, 0);
			lastUpdated = new Date();
		}
	}

	public List<?> getRegions(IEnterpriseService service, CommonAccount account) {

		updateCache(service);
		List<Region> list = new ArrayList<Region>();
		if (regions != null)
			for (int i = 0; i < regions.size(); i++) {
				Region item = (Region) regions.get(i);
				if (item.isHomologous(account._region))
					list.add(item);
			}
		return list;
	}

	public void getAccountRegion(IEnterpriseService service,
			CommonAccount account) {
		updateCache(service);
		if (regions != null)
			for (int i = 0; i < regions.size(); i++) {
				Region item = (Region) regions.get(i);
				if (account.getRegionId() == item.getId()) {
					account._region = item;
					return;
				}
			}
	}

}
