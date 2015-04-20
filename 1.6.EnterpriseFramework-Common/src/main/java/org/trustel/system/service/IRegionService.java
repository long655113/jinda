package org.trustel.system.service;

import java.util.List;

import org.trustel.system.SystemRegionView;


public interface IRegionService {
	
	public List<SystemRegionView> getRegions(int id,String lang);
	
	public List<SystemRegionView> getRegionsByParentId(int id,String lang);
	
	public List<SystemRegionView> getRegionsByRank(int rank,String lang);

}
