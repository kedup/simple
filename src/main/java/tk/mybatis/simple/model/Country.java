package tk.mybatis.simple.model;

import lombok.Data;

/**
 * @author kedupmail@gmail.com
 * @date 2018/9/28 9:56
 */
@Data
public class Country {

  private Long id;
  private String countryname;
  private String countrycode;

}
