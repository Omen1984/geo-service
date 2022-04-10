import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoServiceImpl;

public class GeoServiceImplTests {
    static GeoServiceImpl sut;

    @BeforeAll
    public static void init() {
        sut = new GeoServiceImpl();
    }

    @Test
    public void test_byIp_isInstanceLocationClass() {
        String ip = "172.0.0.1";
        Location result = sut.byIp(ip);
        Assertions.assertInstanceOf(Location.class, result);
    }

    @Test
    public void test_byIp_Russia() {
        String ip = "172.0.0.1";
        Country expected = Country.RUSSIA;
        Country result = sut.byIp(ip).getCountry();
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void test_byIp_USA() {
        String ip = "96.0.0.1";
        Country expected = Country.USA;
        Country result = sut.byIp(ip).getCountry();
        Assertions.assertEquals(expected, result);
    }

}
