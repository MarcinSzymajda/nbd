package org.example.mapper;

import org.bson.Document;
import org.example.entityMgd.ClientMgd;

public class ClientMapper {

    private static final String ID = "_id";
    private static final String FIRST_NAME = "first_name";
    private static final String LAST_NAME = "last_name";
    private static final String PERSONAL_ID = "personal_ID";
    private static final String HAS_RENT = "has_rent";


    public static Document toMongoClient(ClientMgd client) {
        return new Document(ID, client.getId())
                .append(FIRST_NAME, client.getFirstName())
                .append(LAST_NAME, client.getLastName())
                .append(PERSONAL_ID, client.getPersonalID())
                .append(HAS_RENT, client.getHasRent());
    }

//    public static ClientMgd fromMongoClient(Document clientDocument) {
//        return new ClientMgd(
//                clientDocument.get(ID, Integer.class),
//                clientDocument.get(FIRST_NAME, String.class),
//                clientDocument.get(LAST_NAME, String.class),
//                clientDocument.get(PERSONAL_ID, String.class),
//                clientDocument.get(HAS_RENT, Integer.class)
//        );
//    }
}
