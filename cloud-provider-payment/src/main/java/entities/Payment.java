package entities;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhangd
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment implements Serializable {

  private Long id;
  private String serial;
}
