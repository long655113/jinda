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
import org.trustel.system.SystemRegionView;

public class RegionService implements IRegionService {
	
    private IEnterpriseService enterpriseService;
	 
	private List<?> regions = null;

	private Date lastUpdated = new Date();

	private void updateCache() {
		QueryBuilder query = new QueryBuilder(Region.class);
		int interval = ParameterFactory.getInt("REGION_RELOAD_INTERVAL", 60);
		Date d = Utils.add(new Date(), Utils.TIME_MINUTE,
				interval > 0 ? -interval : -5);

		if (regions == null || d.before(lastUpdated)) {
			regions = enterpriseService.query(query, 0);
			lastUpdated = new Date();
		}
	}

	public List<?> getRegions(CommonAccount account) {
		updateCache();
		List<Region> list = new ArrayList<Region>();
		if (regions != null)
			for (int i = 0; i < regions.size(); i++) {
				Region item = (Region) regions.get(i);
				if (item.isHomologous(account._region))
					list.add(item);
			}
		return list;
	}

	public void getAccountRegion(CommonAccount account) {
		updateCache();
		if (regions != null)
			for (int i = 0; i < regions.size(); i++) {
				Region item = (Region) regions.get(i);
				if (account.getRegionId() == item.getId()) {
					account._region = item;
					return;
				}
			}
	}


	
	public List<SystemRegionView> getRegions(int id,String lang) {
		List<SystemRegionView> list = new ArrayList<SystemRegionView>();
		QueryBuilder query = new QueryBuilder(SystemRegionView.class);
		query.where("id",id);
		query.where("lang",lang);
		list = (List<SystemRegionView>)enterpriseService.query(query, 0);
		return list;
	}
	
	public List<SystemRegionView> getRegionsByParentId(int id,String lang) {
		List<SystemRegionView> list = new ArrayList<SystemRegionView>();
		QueryBuilder query = new QueryBuilder(SystemRegionView.class);
		query.where("parentId",id);
		query.where("lang",lang);
		list = (List<SystemRegionView>)enterpriseService.query(query, 0);
		return list;
	}

	public List<SystemRegionView> getRegionsByRank(int rank,String lang) {
		List<SystemRegionView> list = new ArrayList<SystemRegionView>();
		QueryBuilder query = new QueryBuilder(SystemRegionView.class);
		query.where("rank",rank);
		query.where("lang",lang);
		list = (List<SystemRegionView>)enterpriseService.query(query, 0);
		return list;
	}

	public void setEnterpriseService(IEnterpriseService enterpriseService) {
		this.enterpriseService = enterpriseService;
	}
 
}
