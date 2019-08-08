package com.bigfishgames.gaeskeleton.memcache;

import com.google.appengine.api.memcache.Expiration;
import com.google.appengine.api.memcache.ErrorHandlers;
import com.google.appengine.api.memcache.MemcacheService;
import com.google.appengine.api.memcache.MemcacheServiceFactory;
import com.google.appengine.api.memcache.MemcacheService.SetPolicy;
import java.util.logging.Level;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

@Component
public class MemcacheClient {
	private MemcacheService memcacheService;

	public MemcacheClient() {
		this.memcacheService = MemcacheServiceFactory.getMemcacheService();
		this.memcacheService.setErrorHandler(ErrorHandlers.getConsistentLogAndContinue(Level.INFO));
	}

	private MemcacheService getMemcacheService() {
		return this.memcacheService;
	}

	public void clearAll() {
		this.getMemcacheService().clearAll();
	}

	public boolean contains(Object key) {
		return this.getMemcacheService().contains(key);
	}

	public boolean delete(Object key) {
		return this.getMemcacheService().delete(key);
	}

	public boolean delete(Object key, long millisNoReAdd) {
		return this.getMemcacheService().delete(key, millisNoReAdd);
	}

	public <T> Set<T> delateAll(Collection<T> keys) {
		return this.getMemcacheService().deleteAll(keys);
	}

	public <T> Set<T> delateAll(Collection<T> keys, long millisNoReAdd) {
		return this.getMemcacheService().deleteAll(keys, millisNoReAdd);
	}

	public Object get(Object key) {
		return this.getMemcacheService().get(key);
	}

	public <T> Map<T, Object> getAll(Collection<T> keys) {
		return this.getMemcacheService().getAll(keys);
	}

	public Long increment(Object key, long delta) {
		return this.getMemcacheService().increment(key, delta);
	}

	public Long increment(Object key, long delta, Long initialValue) {
		return this.getMemcacheService().increment(key, delta, initialValue);
	}

	public void put(Object key, Object value) {
		this.getMemcacheService().put(key, value);
	}

	public void put(Object key, Object value, Expiration expires) {
		this.getMemcacheService().put(key, value, expires);
	}

	public void put(Object key, Object value, Expiration expires, SetPolicy policy) {
		this.getMemcacheService().put(key, value, expires, policy);
	}


}
