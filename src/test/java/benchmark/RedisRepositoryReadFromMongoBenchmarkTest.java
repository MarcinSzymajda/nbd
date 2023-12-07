package benchmark;

import org.example.entity.Court;
import org.example.entity.FootballCourt;
import org.example.mapper.CourtMapper;
import org.example.repository.CourtRepository;
import org.example.repository.RedisCourtRepository;
import org.junit.Before;
import org.junit.Test;
import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

@Warmup(iterations = 0)
@Measurement(iterations = 1)
@Fork(1)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Benchmark)
public class RedisRepositoryReadFromMongoBenchmarkTest {

    RedisCourtRepository redisRepository = new RedisCourtRepository();
    FootballCourt footballCourt = new FootballCourt(2,1,1,1,1,1);

    @Before
    public void setUp() throws Exception {
        try (CourtRepository mongoCourtRepository = new CourtRepository()) {
            assertTrue(mongoCourtRepository.add(CourtMapper.toMongoCourt(footballCourt)));
            assertTrue(redisRepository.deleteAllJson());
        }
    }

    @Test
    @Benchmark
    public void dataReadFromMongoBenchmark() {
        Court court = redisRepository.findJson(footballCourt.getId());
    }
}
