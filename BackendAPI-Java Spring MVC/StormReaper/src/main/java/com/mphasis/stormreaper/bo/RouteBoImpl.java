
package com.mphasis.stormreaper.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mphasis.stormreaper.dao.RouteDao;
import com.mphasis.stormreaper.entities.Route;

@Service
public class RouteBoImpl implements RouteBo {
	@Autowired
	RouteDao routeDao;
	public List<Route> getAllRoutes() {
		List<Route> routes = routeDao.getAllRoutes();
		if(routes.isEmpty())
		{
			System.out.println("no route found");
		}
		return routes;
	}

	public void addRoute(Route r) {
		routeDao.addRoute(r);

	}

	public void deleteRoute(int routeid) {
		routeDao.deleteRoute(routeid);

	}

	public void editRoute(Route r) {
		routeDao.editRoute(r);

	}

	public Route getRouteById(int routeid) {
		
		return routeDao.getRouteById(routeid);
	}

}
