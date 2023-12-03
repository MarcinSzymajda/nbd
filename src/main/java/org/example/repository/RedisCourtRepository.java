package org.example.repository;

import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import org.example.entity.BasketballCourt;
import org.example.entity.Court;
import org.example.entity.FootballCourt;
import org.example.entity.VolleyballCourt;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import redis.clients.jedis.*;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class RedisCourtRepository {

    private static JedisPooled jedis;
    Jsonb jsonb = JsonbBuilder.create();
    private final static String hashPrefix = "Court:";
    
    private final static String connString = null;

    public RedisCourtRepository() {
        initConnection();
    }

    public void initConnection()  {
        JSONParser parser = new JSONParser();

        try (Reader reader = new FileReader("redisconf.json")) {

            JSONObject jsonObject = (JSONObject) parser.parse(reader);

            String host = (String) jsonObject.get("host");
            String port = (String) jsonObject.get("port");

            JedisClientConfig clientConfig = DefaultJedisClientConfig.builder().build();
            jedis = new JedisPooled(new HostAndPort(host, Integer.parseInt(port)), clientConfig);

        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }

    }

    public boolean addJson(Court court) {
        String stringCourt = jsonb.toJson(court);
        jedis.set(hashPrefix + court.getId(), stringCourt);
        return true;
    }

    public Court findJson(int id) {
        String stringCourt = jedis.get(hashPrefix + id);

        if (stringCourt == null) {
            return null;
        }
        if(stringCourt.contains("goalWidth")) {
           return jsonb.fromJson(stringCourt, FootballCourt.class);
        }
        if(stringCourt.contains("netWidth")) {
            return jsonb.fromJson(stringCourt, VolleyballCourt.class);
        }
        if(stringCourt.contains("basketRadius")) {
            return jsonb.fromJson(stringCourt, BasketballCourt.class);
        }
        return null;
    }

    public boolean deleteAllJson() {
        jedis.flushAll();
        return true;
    }
}
