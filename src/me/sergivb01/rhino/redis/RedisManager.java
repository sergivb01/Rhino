package me.sergivb01.rhino.redis;

import lombok.Getter;
import me.sergivb01.rhino.RhinoPlugin;
import me.sergivb01.rhino.redis.pubsub.Publisher;
import me.sergivb01.rhino.redis.pubsub.Subscriber;

@Getter public class RedisManager{
	private RhinoPlugin plugin;
	public static Publisher publisher;
	public static Subscriber subscriber;

	public RedisManager(RhinoPlugin plugin){
		this.plugin = plugin;
		init();
	}

	private void init(){
		publisher = new Publisher();
		subscriber = new Subscriber(plugin);
	}


}