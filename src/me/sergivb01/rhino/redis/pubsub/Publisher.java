package me.sergivb01.rhino.redis.pubsub;

import lombok.Getter;
import me.sergivb01.rhino.utils.ConfigUtils;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class Publisher{
	@Getter
	private JedisPool pool;
	private String channel;

	public Publisher(){
		if(ConfigUtils.REDIS_AUTH){ //Handle auth
			pool = new JedisPool(new JedisPoolConfig(), ConfigUtils.REDIS_HOST, ConfigUtils.REDIS_PORT, 2000, ConfigUtils.REDIS_PASSWORD);
		}else{
			pool = new JedisPool(new JedisPoolConfig(), ConfigUtils.REDIS_HOST, ConfigUtils.REDIS_PORT, 2000);
		}
		this.channel = "channel";
	}

	public void write(final String message){
		Jedis jedis = null;
		try{
			jedis = pool.getResource();
			if(ConfigUtils.REDIS_AUTH){ //Need to auth every single time we write a message
				jedis.auth(ConfigUtils.REDIS_PASSWORD);
			}
			jedis.publish(channel, message);
			pool.returnResource(jedis);
		}finally{
			if(jedis != null){
				jedis.close();
			}
		}
	}


}