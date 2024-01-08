import org.example.entityKafka.RentKfk;
import org.example.kafka.Producer;
import org.junit.Test;

import java.util.Date;
import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.*;

public class KafkaTest {

    @Test
    public void kafkaTest() throws ExecutionException, InterruptedException {

        RentKfk rent = new RentKfk(9, "Lodz_rental", 99,999, new Date(), null);

        Producer producer = new Producer();


        producer.initProducer();

        producer.createTopic();

        assertDoesNotThrow(() -> producer.sendRentToKafka(rent));
    }


}
