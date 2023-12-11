import org.junit.jupiter.api.Test;
import utils.SnowflakeUtils;

/**
 * Date:2023/12/4 17:29
 *
 * @Author:poboking
 */
public class SnowflakeUtilsTest {
    @Test
    void Test(){
        SnowflakeUtils snowflakeUtils = new SnowflakeUtils(1, 1);
        System.out.println(snowflakeUtils.nextId());
    }
}
