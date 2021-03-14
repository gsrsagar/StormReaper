package com.mphasis.stormreaper.bo;

import java.util.List;

import com.mphasis.stormreaper.entities.Route;

public interface RouteBo {
	public List<Route> getAllRoutes();
	public void addRoute(Route r);
	public void deleteRoute(int routeid);
	public void editRoute(Route r);
	public Route getRouteById(int routeid);
}
