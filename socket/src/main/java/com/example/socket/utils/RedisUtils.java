package com.example.socket.utils;

import lombok.extern.slf4j.Slf4j;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.*;

/**
 * @author duan
 */
@Slf4j
public class RedisUtils {
    private static JedisPool jedisPool;

    /**
     * 最大连接数
     */
    private static Integer maxTotal = 50;

    /**
     * 在jedispool中最大的idle状态(空闲的)的jedis实例的个数
     */
    private static Integer maxIdle = 50;

    /**
     * 在jedispool中最小的idle状态(空闲的)的jedis实例的个数
     */
    private static Integer minIdle = 0;

    /**
     * 小于零:阻塞不确定的时间,  默认-1
     */
    private static Integer maxWaitMillis = 10 * 1000;

    /**
     * 在borrow一个jedis实例的时候，是否要进行验证操作，如果赋值true。则得到的jedis实例肯定是可以用的。
     */
    private static Boolean testOnBorrow = true;

    /**
     * 在return一个jedis实例的时候，是否要进行验证操作，如果赋值true。则放回jedispool的jedis实例肯定是可以用的。
     */
    private static Boolean testOnReturn = true;

    private static String redisIp = "guodudev.imwork.net";
    private static Integer redisPort = 8324;
    private static String redisPassword = "Zzll390Tkkac4";

    /**
     * Jedis实例获取返回码
     *
     * @author jqlin
     */
    public static class JedisStatus {
        /**
         * Jedis实例获取失败
         */
        public static final long FAIL_LONG = -5L;
        /**
         * Jedis实例获取失败
         */
        public static final int FAIL_INT = -5;
        /**
         * Jedis实例获取失败
         */
        public static final String FAIL_STRING = "-5";

    }

    /**
     * 初始化连接池
     */
    private static void initPool() {
        try {
            JedisPoolConfig config = new JedisPoolConfig();
            config.setMaxTotal(maxTotal);
            config.setMaxIdle(maxIdle);
            config.setMinIdle(minIdle);
            //小于零:阻塞不确定的时间,  默认-1
            config.setMaxWaitMillis(maxWaitMillis);
            config.setTestOnBorrow(testOnBorrow);
            config.setTestOnReturn(testOnReturn);
            //连接耗尽的时候，是否阻塞，false会抛出异常，true阻塞直到超时。默认为true。
            config.setBlockWhenExhausted(true);
            jedisPool = new JedisPool(config, redisIp, redisPort, 1000 * 5, redisPassword);
        } catch (Exception e) {
            if (jedisPool != null) {
                jedisPool.close();
            }
            log.info("Redis连接池初始化失败", e);
        }
        log.info("Redis连接池初始化成功...");
    }

    /**
     * 初始化Redis连接池
     */
    static {
        initPool();
    }

    /**
     * 在多线程环境同步初始化
     */
    private static synchronized void poolInit() {
        if (jedisPool == null) {
            initPool();
        }
    }

    /**
     * 同步获取Jedis实例
     *
     * @return Jedis
     */
    public static Jedis getJedis() {
        if (jedisPool == null) {
            poolInit();
        }

        Jedis jedis = null;
        try {
            if (jedisPool != null) {
                jedis = jedisPool.getResource();
            }
        } catch (Exception e) {
            log.error("同步获取Jedis实例失败" + e.getMessage(), e);
            jedis.close();
        }

        return jedis;
    }

    /**
     * 释放jedis资源
     *
     * @param jedis
     */
    public static void returnResource(Jedis jedis) {
        //todo close
        jedis.close();
    }


    public static void main(String[] args) {

    }


    /**
     * 设置值
     *
     * @param key
     * @param value
     * @param expire 过期时间，单位：秒
     * @return -5：Jedis实例获取失败<br/>OK：操作成功<br/>null：操作失败
     * @author jqlin
     */
    public static String set(String key, String value, int expire) {
        Jedis jedis = getJedis();
        if (jedis == null) {
            return JedisStatus.FAIL_STRING;
        }

        String result = null;
        try {
            result = jedis.set(key, value);
            jedis.expire(key, expire);
        } catch (Exception e) {
            log.error("设置值失败：" + e.getMessage(), e);
        } finally {
            returnResource(jedis);
        }
        return result;
    }

    /**
     * 获取值
     *
     * @param key
     * @return
     * @author jqlin
     */
    public static String get(String key) {
        Jedis jedis = getJedis();
        if (jedis == null) {
            return JedisStatus.FAIL_STRING;
        }

        String result = null;
        try {
            result = jedis.get(key);
        } catch (Exception e) {
            log.error("获取值失败：" + e.getMessage(), e);
        } finally {
            returnResource(jedis);
        }

        return result;
    }

    /**
     * 判断key是否存在
     *
     * @param key
     * @return
     * @author jqlin
     */
    public static boolean exists(String key) {
        Jedis jedis = getJedis();
        if (jedis == null) {
            log.warn("Jedis实例获取为空");
            return false;
        }

        boolean result = false;
        try {
            result = jedis.exists(key);
        } catch (Exception e) {
            log.error(String.format("判断key=%s是否存在失败：" + e.getMessage(), key), e);

        } finally {
            returnResource(jedis);
        }

        return result;
    }

    /**
     * 删除key
     *
     * @param keys
     * @return -5：Jedis实例获取失败，1：成功，0：失败
     * @author jqlin
     */
    public static long del(String... keys) {
        Jedis jedis = getJedis();
        if (jedis == null) {
            return JedisStatus.FAIL_LONG;
        }

        long result = JedisStatus.FAIL_LONG;
        try {
            result = jedis.del(keys);
        } catch (Exception e) {
            log.error(String.format("删除key=%s失败：" + e.getMessage(), keys), e);

        } finally {
            returnResource(jedis);
        }

        return result;
    }

    /**
     * set if not exists，若key已存在，则setnx不做任何操作
     *
     * @param key
     * @param value key已存在，1：key赋值成功
     * @return
     * @author jqlin
     */
    public static long setnx(String key, String value) {
        long result = JedisStatus.FAIL_LONG;

        Jedis jedis = getJedis();
        if (jedis == null) {
            return result;
        }

        try {
            result = jedis.setnx(key, value);
        } catch (Exception e) {
            log.error("设置值失败：" + e.getMessage(), e);

        } finally {
            returnResource(jedis);
        }

        return result;
    }

    /**
     * set if not exists，若key已存在，则setnx不做任何操作
     *
     * @param key
     * @param value  key已存在，1：key赋值成功
     * @param expire 过期时间，单位：秒
     * @return
     * @author jqlin
     */
    public static long setnx(String key, String value, int expire) {
        long result = JedisStatus.FAIL_LONG;

        Jedis jedis = getJedis();
        if (jedis == null) {
            return result;
        }

        try {
            result = jedis.setnx(key, value);
            jedis.expire(key, expire);
        } catch (Exception e) {
            log.error("设置值失败：" + e.getMessage(), e);

        } finally {
            returnResource(jedis);
        }

        return result;
    }

    /**
     * 在列表key的头部插入元素
     *
     * @param key
     * @param values -5：Jedis实例获取失败，>0：返回操作成功的条数，0：失败
     * @return
     * @author jqlin
     */
    public static long lpush(String key, String... values) {
        long result = JedisStatus.FAIL_LONG;

        Jedis jedis = getJedis();
        if (jedis == null) {
            return result;
        }

        try {
            result = jedis.lpush(key, values);
        } catch (Exception e) {
            log.error("在列表key的头部插入元素失败：" + e.getMessage(), e);

        } finally {
            returnResource(jedis);
        }

        return result;
    }

    /**
     * 在列表key的尾部插入元素
     *
     * @param key
     * @param values -5：Jedis实例获取失败，>0：返回操作成功的条数，0：失败
     * @return
     * @author jqlin
     */
    public static long rpush(String key, String... values) {
        long result = JedisStatus.FAIL_LONG;

        Jedis jedis = getJedis();
        if (jedis == null) {
            return result;
        }

        try {
            result = jedis.rpush(key, values);
        } catch (Exception e) {
            log.error("在列表key的尾部插入元素失败：" + e.getMessage(), e);

        } finally {
            returnResource(jedis);
        }

        return result;
    }

    /**
     * 返回存储在key列表的特定元素
     *
     * @param key
     * @param start 开始索引，索引从0开始，0表示第一个元素，1表示第二个元素
     * @param end   结束索引，-1表示最后一个元素，-2表示倒数第二个元素
     * @return redis client获取失败返回null
     * @author jqlin
     */
    public static List<String> lrange(String key, long start, long end) {
        Jedis jedis = getJedis();
        if (jedis == null) {
            return null;
        }

        List<String> result = null;
        try {
            result = jedis.lrange(key, start, end);
        } catch (Exception e) {
            log.error("查询列表元素失败：" + e.getMessage(), e);

        } finally {
            returnResource(jedis);
        }

        return result;
    }


    /**
     * 获取列表长度
     *
     * @param key -5：Jedis实例获取失败
     * @return
     * @author jqlin
     */
    public static long llen(String key) {
        Jedis jedis = getJedis();
        if (jedis == null) {
            return JedisStatus.FAIL_LONG;
        }

        long result = 0;
        try {
            result = jedis.llen(key);
        } catch (Exception e) {
            log.error("获取列表长度失败：" + e.getMessage(), e);

        } finally {
            returnResource(jedis);
        }

        return result;
    }

    /**
     * 移除等于value的元素<br/><br/>
     * 当count>0时，从表头开始查找，移除count个；<br/>
     * 当count=0时，从表头开始查找，移除所有等于value的；<br/>
     * 当count<0时，从表尾开始查找，移除count个
     *
     * @param key
     * @param count
     * @param value
     * @return -5:Jedis实例获取失败
     * @author jqlin
     */
    public static long lrem(String key, long count, String value) {
        Jedis jedis = getJedis();
        if (jedis == null) {
            return JedisStatus.FAIL_LONG;
        }

        long result = 0;
        try {
            result = jedis.lrem(key, count, value);
        } catch (Exception e) {
            log.error("获取列表长度失败：" + e.getMessage(), e);

        } finally {
            returnResource(jedis);
        }

        return result;
    }

    /**
     * 对列表进行修剪
     *
     * @param key
     * @param start
     * @param end
     * @return -5：Jedis实例获取失败，OK：命令执行成功
     * @author jqlin
     */
    public static String ltrim(String key, long start, long end) {
        Jedis jedis = getJedis();
        if (jedis == null) {
            return JedisStatus.FAIL_STRING;
        }

        String result = "";
        try {
            result = jedis.ltrim(key, start, end);
        } catch (Exception e) {
            log.error("获取列表长度失败：" + e.getMessage(), e);

        } finally {
            returnResource(jedis);
        }

        return result;
    }


    /**
     * 缓存Map赋值
     *
     * @param key
     * @param field
     * @param value
     * @return -5：Jedis实例获取失败
     * @author jqlin
     */
    public static long hset(String key, String field, String value) {
        Jedis jedis = getJedis();
        if (jedis == null) {
            return JedisStatus.FAIL_LONG;
        }

        long result = 0L;
        try {
            result = jedis.hset(key, field, value);
        } catch (Exception e) {
            log.error("缓存Map赋值失败：" + e.getMessage(), e);

        } finally {
            returnResource(jedis);
        }

        return result;
    }


    /**
     * 获取缓存的Map值
     *
     * @param key
     * @return
     */
    public static String hget(String key, String field) {
        Jedis jedis = getJedis();
        if (jedis == null) {
            return null;
        }

        String result = null;
        try {
            result = jedis.hget(key, field);
        } catch (Exception e) {
            log.error("获取缓存的Map值失败：" + e.getMessage(), e);

        } finally {
            returnResource(jedis);
        }

        return result;
    }

    /**
     * 获取map所有的字段和值
     *
     * @param key
     * @return
     * @author jqlin
     */
    public static Map<String, String> hgetAll(String key) {
        Map<String, String> map = new HashMap<String, String>();

        Jedis jedis = getJedis();
        if (jedis == null) {
            log.warn("Jedis实例获取为空");
            return map;
        }

        try {
            map = jedis.hgetAll(key);
        } catch (Exception e) {
            log.error("获取map所有的字段和值失败：" + e.getMessage(), e);

        } finally {
            returnResource(jedis);
        }

        return map;
    }

    /**
     * 查看哈希表 key 中，指定的field字段是否存在。
     *
     * @param key
     * @param field
     * @return
     * @author jqlin
     */
    public static Boolean hexists(String key, String field) {
        Jedis jedis = getJedis();
        if (jedis == null) {
            log.warn("Jedis实例获取为空");
            return null;
        }

        try {
            return jedis.hexists(key, field);
        } catch (Exception e) {
            log.error("查看哈希表field字段是否存在失败：" + e.getMessage(), e);

        } finally {
            returnResource(jedis);
        }

        return null;
    }

    /**
     * 获取所有哈希表中的字段
     *
     * @param key
     * @return
     * @author jqlin
     */
    public static Set<String> hkeys(String key) {
        Set<String> set = new HashSet<String>();
        Jedis jedis = getJedis();
        if (jedis == null) {
            log.warn("Jedis实例获取为空");
            return set;
        }

        try {
            return jedis.hkeys(key);
        } catch (Exception e) {
            log.error("获取所有哈希表中的字段失败：" + e.getMessage(), e);

        } finally {
            returnResource(jedis);
        }

        return null;
    }

    /**
     * 获取所有哈希表中的值
     *
     * @param key
     * @return
     * @author jqlin
     */
    public static List<String> hvals(String key) {
        List<String> list = new ArrayList<String>();
        Jedis jedis = getJedis();
        if (jedis == null) {
            log.warn("Jedis实例获取为空");
            return list;
        }

        try {
            return jedis.hvals(key);
        } catch (Exception e) {
            log.error("获取所有哈希表中的值失败：" + e.getMessage(), e);

        } finally {
            returnResource(jedis);
        }

        return null;
    }

    /**
     * 从哈希表 key 中删除指定的field
     *
     * @param key
     * @param field
     * @return
     * @author jqlin
     */
    public static long hdel(String key, String... fields) {
        Jedis jedis = getJedis();
        if (jedis == null) {
            log.warn("Jedis实例获取为空");
            return JedisStatus.FAIL_LONG;
        }

        try {
            return jedis.hdel(key, fields);
        } catch (Exception e) {
            log.error("map删除指定的field失败：" + e.getMessage(), e);
        } finally {
            returnResource(jedis);
        }

        return 0;
    }

    public static Set<String> keys(String pattern) {
        Set<String> keyList = new HashSet<String>();
        Jedis jedis = getJedis();
        if (jedis == null) {
            log.warn("Jedis实例获取为空");
            return keyList;
        }

        try {
            keyList = jedis.keys(pattern);
        } catch (Exception e) {
            log.error("操作keys失败：" + e.getMessage(), e);
        } finally {
            returnResource(jedis);
        }

        return keyList;
    }
}
