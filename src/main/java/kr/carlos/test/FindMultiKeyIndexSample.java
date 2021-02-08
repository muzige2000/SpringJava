package kr.carlos.test;
import static org.springframework.data.mongodb.core.query.Criteria.where;

import com.mongodb.BasicDBObject;
import com.mongodb.Block;
import com.mongodb.MongoClientSettings;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

import com.mongodb.connection.ClusterSettings;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import lombok.extern.slf4j.Slf4j;
import org.bson.Document;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;



import java.util.*;


/**
 * 멀티키 Index 테스트
 *
 * @author 엄승하
 */
public class FindMultiKeyIndexSample {


    private static final String dbAddr = "127.0.0.1"; //로컬 vm에 mongodb 4.2를 설치함
    private static final String dbName = "test_db"; //db명


    private static String colNm = "test_multikey_index";
    private static String indexField = "topic"; //인덱스 필드

    private static final int testDataSize = 100_000; //테스트 데이터 생성 갯수


    private static MongoDatabase mongoDB;

    private static final Log log = LogFactory.getLog(FindMultiKeyIndexSample.class);


    public static void main(String[] args) {
//        MongoOperations mongoOps = new MongoTemplate(MongoClients.create(), "database");
//        mongoOps.insert(new Person("Joe", 34));
//
//        log.info(mongoOps.findOne(new Query(where("name").is("Joe")), Person.class));
//
//        mongoOps.dropCollection("person");
//        MongoCredential credential = MongoCredential.createCredential("test", dbName, "test123".toCharArray());
//
        List<ServerAddress> serverList = Arrays.asList(new ServerAddress(dbAddr, 27017));
        Block<ClusterSettings.Builder> clusterSettings = builder -> builder.hosts(serverList);
//
//
        MongoClient mongoClient = MongoClients.create(MongoClientSettings.builder()
                .applyToClusterSettings(clusterSettings)
//                .credential(credential)
                .build());
        mongoDB = mongoClient.getDatabase(dbName);
//
//
//        //컬렉션 추가
////        mongoDB.createCollection(colNm);
        mongoDB.getCollection(colNm).createIndex(new BasicDBObject(indexField, 1)); //인덱스 추가
//
//
        saveBulkData(colNm, testDataSize); //테스트 데이터 저장
//
//
        mongoClient.close(); //DB커넥션 반환
//
//
//        System.out.println("\n\n === 프로그램 종료 ===");
    }


    /**
     * bulk로 데이터 저장
     *
     * @param colNm 저장할 컬렉션명
     * @param dataSize 저장할 데이터 갯수
     */
    public static void saveBulkData(String colNm, int dataSize) {


        Date now = new Date();
        List<Document> docs = new ArrayList<>(dataSize);


        List<String> case1 = new ArrayList<>();
        case1.add("server-1");
        case1.add("server-2");


        List<String> case2 = new ArrayList<>();
        case2.add("server-2");
        case2.add("server-3");


        for (int i = 1; i <= dataSize; i++) {


            Document doc = new Document();
            doc.append("i", i);
            doc.append("uuid", UUID.randomUUID().toString());
            if (i % 2 == 0) { // 2가지의 경우로 데이터 저장
                doc.append("topic", case1);
            } else {
                doc.append("topic", case2);
            }


            doc.append("doc_make_date", now);
            docs.add(doc);
        }


        mongoDB.getCollection(colNm).insertMany(docs); //N개 insert


        //Thread.sleep(10); //부하분산 목적
    }
}

