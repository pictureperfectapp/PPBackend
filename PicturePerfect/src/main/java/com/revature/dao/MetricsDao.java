package com.revature.dao;

import java.util.List;

import com.revature.beans.Metrics;

public interface MetricsDao {
	public List<Metrics> getAllMetrics();
	public Metrics getMetricsById(int id);
	public Metrics createMetrics(Metrics metrics);
	public Metrics updateMetrics(Metrics metrics);
	public void deleteMetrics(Metrics metrics);
}
