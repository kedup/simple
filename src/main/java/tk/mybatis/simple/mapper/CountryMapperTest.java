package tk.mybatis.simple.mapper;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.BeforeClass;
import org.junit.Test;
import tk.mybatis.simple.model.Country;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

/**
 * @author kedupmail@gmail.com
 * @date 2018/9/28 10:39
 */
public class CountryMapperTest {
  private static SqlSessionFactory sqlSessionFactory;

  @BeforeClass
  public static void init() {
    try {
      Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
      sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
      reader.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Test
  public void testSelectAll() {
    SqlSession sqlSession = sqlSessionFactory.openSession();
    try {
      List<Country> countryList = sqlSession.selectList("selectAll");
      printCountryList(countryList);
    } finally {
      sqlSession.close();
    }

  }

  private void printCountryList(List<Country> countryList) {
    for (Country country : countryList) {
      System.out.printf("%-4d%s%s\n", country.getId(), country.getCountryname(), country.getCountrycode());
    }

  }
}
