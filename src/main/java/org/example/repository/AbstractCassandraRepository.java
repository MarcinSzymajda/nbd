package org.example.repository;

import com.datastax.oss.driver.api.core.CqlSession;

import java.net.InetSocketAddress;

public abstract class AbstractCassandraRepository {

    private CqlSession session;

    public AbstractCassandraRepository() {
        System.out.println("init session");
        initSession();
    }

    public void initSession() {
        session = CqlSession.builder()
                .addContactPoint(new InetSocketAddress("cassandra1", 9042))
                .addContactPoint(new InetSocketAddress("cassandra2", 9043))
                .withLocalDatacenter("dc1")
                .withAuthCredentials("cassandra", "cassandrapassword")
                .build();
    }

    public CqlSession getSession() {
        return this.session;
    }
}
