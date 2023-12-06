package benchmark;

import org.example.entity.Court;
import org.example.entity.FootballCourt;
import org.example.mapper.CourtMapper;
import org.example.repository.CourtRepository;
import org.example.repository.RedisCourtRepository;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

@Warmup(iterations = 0)
@Measurement(iterations = 1)
@Fork(1)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Benchmark)
public class RedisRepositoryBenchmarkTest {

    RedisCourtRepository redisRepository = new RedisCourtRepository();
    FootballCourt footballCourt1 = new FootballCourt(1,1,1,1,1,1);
    FootballCourt footballCourt2 = new FootballCourt(11,1,1,1,1,1);

    @BeforeClass
    public static void beforeClass() throws Exception {
        Options opt = new OptionsBuilder().include(RedisRepositoryBenchmarkTest.class.getSimpleName()).build();

        new Runner(opt).run();
    }

    @Test
    @Benchmark
    public void dataReadFromCacheBenchmark() {
        assertTrue(redisRepository.addJson(footballCourt1));
        Court fcourt = redisRepository.findJson(footballCourt1.getId());
    }

    @Test
    @Benchmark
    public void dataReadFromMongoBenchmark() {
        try(CourtRepository courtRepository = new CourtRepository()) {
            courtRepository.add(CourtMapper.toMongoCourt(footballCourt2));

            Court court = redisRepository.findJson(11);
        }
    }
}
