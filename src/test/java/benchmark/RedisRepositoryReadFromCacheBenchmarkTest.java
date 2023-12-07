package benchmark;

import org.example.entity.Court;
import org.example.entity.FootballCourt;
import org.example.repository.RedisCourtRepository;
import org.junit.Before;
import org.junit.Test;
import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@Warmup(iterations = 0)
@Measurement(iterations = 1)
@Fork(1)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Benchmark)

public class RedisRepositoryReadFromCacheBenchmarkTest {

    RedisCourtRepository redisRepository = new RedisCourtRepository();
    FootballCourt footballCourt = new FootballCourt(1,1,1,1,1,1);

    @Before
    public void setUp() throws Exception {
        assertTrue(redisRepository.addJson(footballCourt));
        assertEquals(redisRepository.findJson(footballCourt.getId()), footballCourt);
    }

    @Test
    @Benchmark
    public void dataReadFromCacheBenchmark() {
        Court fcourt = redisRepository.findJson(footballCourt.getId());
    }
}
