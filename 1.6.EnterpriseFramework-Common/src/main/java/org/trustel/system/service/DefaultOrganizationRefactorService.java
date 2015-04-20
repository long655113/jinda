package org.trustel.system.service;

import java.util.List;

import org.trustel.service.IEnterpriseService;
import org.trustel.service.sql.QueryBuilder;
import org.trustel.system.AbstractRegion;

public class DefaultOrganizationRefactorService implements
		IOrganizationRefactorService {
	private String organiztionClassName = "SystemRegion";

	private IEnterpriseService enterpriseService;

	private boolean isTopRegion(List<?> list, AbstractRegion region) {
		for (int i = 0; i < list.size(); i++) {
			AbstractRegion item = (AbstractRegion) list.get(i);
			if (region.getParentId() == item.getId()) {
				if (region.getId() != item.getId())
					return false;
			}
		}
		return true;
	}

	public void refacting() {

		QueryBuilder builder = new QueryBuilder(organiztionClassName);
		builder.orderBy("parentid");
		builder.orderBy("seq");
		List<?> list = enterpriseService.query(builder, 0);
		int[] arrRank = new int[] { 1 };
		int level = 1;
		for (int i = 0; i < list.size(); i++) {
			AbstractRegion item = (AbstractRegion) list.get(i);
			if (isTopRegion(list, item)) {
				arrRank[0] = item.getId();
				item.setRank(level);
				updateRank(item, arrRank);
				traverse(list, item, ++level, arrRank);
			}

		}
		enterpriseService.updateAll(list);

	}

	public void setOrganiztionClassName(String organiztionClassName) {
		this.organiztionClassName = organiztionClassName;
	}

	private void setRank(AbstractRegion item, int i, int rank) {

		switch (i) {
		case 0:
			item.setRank1(rank);
			break;
		case 1:
			item.setRank2(rank);
			break;
		case 2:
			item.setRank3(rank);
			break;
		case 3:
			item.setRank4(rank);
			break;
		case 4:
			item.setRank5(rank);
			break;
		case 5:
			item.setRank6(rank);
			break;
		case 6:
			item.setRank7(rank);
			break;
		case 7:
			item.setRank8(rank);
			break;
		case 8:
			item.setRank9(rank);
			break;

		}
	}

	public void setEnterpriseService(IEnterpriseService service) {
		this.enterpriseService = service;
	}

	private void traverse(List<?> list, AbstractRegion root, int level,
			int[] rank) {
		int[] arrTmp = new int[rank.length + 1];
		for (int i = 0; i < rank.length; i++) {
			arrTmp[i] = rank[i];
		}
		for (int i = 0; i < list.size(); i++) {
			AbstractRegion item = (AbstractRegion) list.get(i);
			if (item.getId() == root.getId())
				continue;
			if (item.getParentId() == root.getId()) {
				arrTmp[rank.length] = item.getId();
				item.setRank(level);
				updateRank(item, arrTmp);
				traverse(list, item, ++level, arrTmp);
			}
		}

	}

	private void updateRank(AbstractRegion item, int[] arrRank) {
		item.setRank(arrRank.length);
		for (int i = 0; i < arrRank.length; i++) {
			setRank(item, i, arrRank[i]);
		}

		for (int i = arrRank.length; i < 9; i++) {
			setRank(item, i, -1);
		}

	}
}
