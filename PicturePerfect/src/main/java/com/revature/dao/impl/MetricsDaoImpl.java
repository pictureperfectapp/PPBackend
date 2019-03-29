package com.revature.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.beans.Metrics;
import com.revature.dao.MetricsDao;
import com.revature.util.HibernateUtil;

public class MetricsDaoImpl implements MetricsDao{

	@Override
	public List<Metrics> getAllMetrics() {
		Session s = HibernateUtil.getSession();
		List<Metrics> metrics = s.createCriteria(Metrics.class).list();
		s.close();
		return metrics;
	}

	@Override
	public Metrics getMetricsById(int id) {
		Session s = HibernateUtil.getSession();
		Metrics m = (Metrics) s.get(Metrics.class, id);
		s.close();
		return m;
	}

	@Override
	public Metrics createMetrics(Metrics metrics) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		s.save(metrics);
		tx.commit();
		s.close();
		return metrics;
	}

	@Override
	public Metrics updateMetrics(Metrics metrics) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		s.update(metrics);
		tx.commit();
		s.close();
		return metrics;
	}

	@Override
	public void deleteMetrics(Metrics metrics) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		s.delete(metrics);
		tx.commit();
		s.close();
	}

}
