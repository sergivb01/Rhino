package me.sergivb01.rhino.redis.pubsub;

import lombok.Getter;
import me.sergivb01.rhino.RhinoPlugin;
import me.sergivb01.rhino.payloads.utils.PayloadParser;
import me.sergivb01.rhino.utils.ConfigUtils;
import org.bson.Document;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;

import java.util.Arrays;

@Getter
public class Subscriber{
	private RhinoPlugin instance;
	private JedisPubSub jedisPubSub;
	private Jedis jedis;

	public Subscriber(RhinoPlugin instance){
		this.instance = instance;
		this.jedis = new Jedis(ConfigUtils.REDIS_HOST, ConfigUtils.REDIS_PORT, 2000);
		if(ConfigUtils.REDIS_AUTH){
			this.jedis.auth(ConfigUtils.REDIS_PASSWORD);
		}
		this.init();
	}

	private void init(){
		jedisPubSub = this.get();
		new Thread(() -> jedis.subscribe(jedisPubSub, ConfigUtils.REDIS_CHANNEL)).start(); //Create subscriber in new Thread to avoid blocking main one
	}

	private JedisPubSub get(){
		return new JedisPubSub(){
			@Override
			public void onMessage(final String channel, final String message){
				final String[] args = message.split(";");
				final String command = args[0].toLowerCase();
				//TODO: Implement encryption (?)

				if(command.equalsIgnoreCase("payload")){
					Document document = Document.parse(args[1]);
					if(document != null){
						PayloadParser.parse(document);
					}
					return;
				}

				instance.getLogger().warning("Recived unknown redis message! " + Arrays.toString(args));
			}

			//Ignore others
			public void onPMessage(String s, String s1, String s2){

			}

			public void onSubscribe(String s, int i){

			}

			public void onUnsubscribe(String s, int i){
			}

			public void onPUnsubscribe(String s, int i){
			}

			public void onPSubscribe(String s, int i){
			}
		};
	}


}