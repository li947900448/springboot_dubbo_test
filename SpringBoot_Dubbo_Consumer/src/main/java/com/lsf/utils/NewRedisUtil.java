package com.lsf.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2020/2/22.
 */
@Component
public final class NewRedisUtil {

    /**
     * Redis操作对象
     */
    @Resource
    private  RedisTemplate<String, String> redisTemplate;


    /**
     *  插入string类型
     *  @param 			: key
     *  @param 			: value
     *  @createDate  	: 2017年7月21日 上午9:38:52
     */
    public  void set(String key, String value){
        redisTemplate.opsForValue().set(key, value);
    }

    /**
     *  根据key获取string类型值
     *  @param 			: key
     *	@return 		: String
     *  @createDate  	: 2017年7月21日 上午9:43:36
     */
    public  String get(String key){
        return redisTemplate.opsForValue().get(key);
    }

    /**
     *  插入string类型值同时设置过期时间
     *  @param 			: key
     *  @param 			: seconds
     *  @param 			: value
     *	@return 		: void
     *  @createDate  	: 2017年7月21日 上午9:44:15
     */
    public   void set(String key, int seconds, String value){
        redisTemplate.opsForValue().set(key, value, seconds, TimeUnit.SECONDS);
    }

    /**
     *  获取key对应的value并设置新value
     *  @param 			: key
     *  @param 			: value
     *	@return 		: String
     *  @createDate  	: 2017年7月21日 上午9:45:49
     */
    public  String getSet(String key, String value){
        return redisTemplate.opsForValue().getAndSet(key, value);
    }

    /**
     *  根据keys集合批量获取string类型值
     *  @param 			: keys
     *	@return 		: List<String>
     *  @createDate  	: 2017年7月21日 上午9:46:46
     */
    public  List<String> multiGet(Collection<String> keys){
        return redisTemplate.opsForValue().multiGet(keys);
    }

    /**
     *  批量插入键值对
     *  @param 			: map
     *  @createDate  	: 2017年7月21日 上午9:47:32
     */
    public  void multiSet(Map<String, String> map){
        redisTemplate.opsForValue().multiSet(map);
    }

    /**
     *  设置过期时间
     *  @param 			: key
     *  @param 			: seconds
     *  @createDate  	: 2017年7月21日 上午9:48:19
     */
    public  void expire(String key, int seconds){
        redisTemplate.expire(key, seconds, TimeUnit.SECONDS);
    }

    /**
     *  根据key获取过期剩余时间,默认单位秒
     *  @param 			: key
     *	@return 		: long
     *  @createDate  	: 2017年7月21日 上午10:13:35
     */
    public  long getExpireTime(String key){
        return getExpireTime(key, TimeUnit.SECONDS);
    }

    /**
     *  根据key获取过期剩余时间
     *  @param 			: key
     *	@return 		: long
     *  @createDate  	: 2017年7月21日 上午10:13:35
     */
    public  long getExpireTime(String key, TimeUnit timeUnit){
        return redisTemplate.getExpire(key, timeUnit);
    }

    /**
     *  根据key删除
     *  @param 			： key
     *	@return 		: void
     *  @createDate  	: 2017年7月21日 上午9:49:55
     */
    public  void deleteByKey(String key){
        redisTemplate.delete(key);
    }

    /**
     *  根据key集合删除
     *  @param 			: keys
     *  @createDate  	: 2017年7月21日 上午10:15:50
     */
    public  void deleteByKeys(Collection<String> keys){
        redisTemplate.delete(keys);
    }

    /**
     *  检查key是否存在
     *  @param 			: key
     *	@return 		: boolean
     *  @createDate  	: 2017年7月21日 上午10:16:35
     */
    public  boolean existsKey(String key){
        return redisTemplate.hasKey(key);
    }

    /**
     *  根据key将value值加1
     *  @param 			: key
     *  @createDate  	: 2017年7月21日 上午10:18:14
     */
    public  void incr(String key){
        incr(key, 1);
    }

    /**
     *  根据key增加value值
     *  @param 			: key
     *  @param 			: num
     *  @createDate  	: 2017年7月21日 上午10:18:48
     */
    public  void incr(String key, long num){
        redisTemplate.opsForValue().increment(key, num);
    }

    /**
     *  根据key将value值减1
     *  @param 			: key
     *	@return 		: void
     *  @createDate  	: 2017年7月21日 上午10:19:27
     */
    public  void decr(String key){
        incr(key, -1);
    }

    /**
     *  根据key减少value值
     *  @param 			: key
     *  @param 			: num
     *  @createDate  	: 2017年7月21日 上午10:18:48
     */
    public  void decr(String key, long num){
        incr(key, -1 * num);
    }

    /**
     *  设置hash类型数据
     *  @param 			: tbName
     *  @param 			: key
     *  @param 			: value
     *  @createDate  	: 2017年7月21日 上午10:20:04
     */
    public  void hset(String tbName, String key, String value){
        redisTemplate.opsForHash().put(tbName, key, value);
    }

    /**
     *  根据散列表名和键获取hash类型数据
     *  @param 			: tbName
     *  @param 			: key
     *	@return 		: Object
     *  @createDate  	: 2017年7月21日 上午10:20:45
     */
    public  Object hget(String tbName, String key){
        return redisTemplate.opsForHash().get(tbName, key);
    }

    /**
     * 	根据散列表名获取全部键值对
     *  @param 			: tbName
     *	@return 		: Map<Object,Object>
     *  @createDate  	: 2017年7月21日 上午10:21:27
     */
    public  Map<Object, Object> hget(String tbName){
        return redisTemplate.opsForHash().entries(tbName);
    }

    /**
     *  根据散列表名和键删除对应值
     *  @param 			: tbName
     *  @param 			: key
     *  @createDate  	: 2017年7月21日 上午10:24:29
     */
    public  void hdel(String tbName, String key){
        redisTemplate.opsForHash().delete(tbName, key);
    }

    /**
     *  根据散列表名和键集合批量获取值
     *  @param 			: tbName
     *  @param 			: keys
     *	@return 		: List<Object>
     *  @createDate  	: 2017年7月21日 上午10:25:18
     */
    public  List<Object> hmultiGet(String tbName, Collection<Object> keys){
        return redisTemplate.opsForHash().multiGet(tbName, keys);
    }

    /**
     * 根据key前缀查询key集合
     * @param regex
     * @return
     */
    public  Set<String> keys(String regex){
        return redisTemplate.keys("regex"+"*");
    }

    /**
     * 根据key前缀查询key数量
     * @param regex
     * @return
     */
    public  int countKeys(String regex){
        return keys(regex).size();
    }

    /**
     * List左侧推入数据
     * @param key 键
     * @param value 值
     */
    public  void lpush(String key, String value){
        redisTemplate.opsForList().leftPush(key, value);
    }

    /**
     * 右侧取数据
     * @param key
     * @return
     */
    public  String rpop(String key){
        return redisTemplate.opsForList().rightPop(key);
    }
}
