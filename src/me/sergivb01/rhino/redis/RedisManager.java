package me.sergivb01.rhino.redis;

import lombok.Getter;
import me.sergivb01.rhino.RhinoPlugin;
import me.sergivb01.rhino.redis.pubsub.Publisher;
import me.sergivb01.rhino.redis.pubsub.Subscriber;


public class RedisManager{
	@Getter public static Publisher publisher;
	@Getter public static Subscriber subscriber;
	private RhinoPlugin plugin;

	public RedisManager(RhinoPlugin plugin){
		this.plugin = plugin;
		init();
	}

	private void init(){
		publisher = new Publisher();
		subscriber = new Subscriber(plugin);
	}


}