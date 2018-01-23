package com.tokid.base.cache;
/*
* @Description: TODO
* @author king
* @date 2018/1/23 9:40
*/

import com.tokid.base.utils.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.mgt.RealmSecurityManager;
import org.apache.shiro.session.Session;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class CacheManager<K, V> implements Cache<K, V> {
    private EhCacheManager ehCacheManager;
    private Cache<K, V> cache = null;

    public static CacheManager cacheManager  = new CacheManager();

    private CacheManager(){
        RealmSecurityManager securityManager =
                (RealmSecurityManager) SecurityUtils.getSecurityManager();
        ehCacheManager = (EhCacheManager) securityManager.getCacheManager();
    }

    public static synchronized CacheManager getInstance(){
        return cacheManager;
    }

    public Cache<K, V> getCache() {
        try {
            if(null == cache){
                cache = ehCacheManager.getCache("shiro_cache");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return cache;
    }
    @Override
    public void clear() throws CacheException {
        getCache().clear();
    }
    @Override
    public V get(K key) throws CacheException {
        return getCache().get(key);
    }
    @Override
    public Set<K> keys() {

        return getCache().keys();
    }
    @Override
    public V put(K key, V value) throws CacheException {
        return getCache().put(key, value);
    }
    @Override
    public V remove(K key) throws CacheException {
        return getCache().remove(key);
    }
    @Override
    public int size() {
        return getCache().size();
    }
    @Override
    public Collection<V> values() {
        return getCache().values();
    }
    public EhCacheManager getCacheManager() {
        return ehCacheManager;
    }
    public void setCacheManager(EhCacheManager ehCacheManager) {
        this.ehCacheManager = ehCacheManager;
    }
    public void setCache(Cache<K, V> cache) {
        this.cache = cache;
    }
    /**
     * 获取所有Session
     * @throws Exception
     */
    public Collection<Session> AllSession() throws Exception {
        Set<Session> sessions = new HashSet<Session>();
        try {
            //TODO 注意事项：必须此缓存只存储Session，要不造成性能下降
            cache = getCache();
            Collection<V> values = cache.values();
            for (V v : values) {
                if(StringUtils.isNotBlank(String.valueOf(v)) && v instanceof Session){
                    sessions.add((Session)v);
                }
            }
        } catch (Exception e) {
            throw e;
        }
        return sessions;
    }
}