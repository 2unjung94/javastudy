package practice02_dql;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class TalkDto {
  private int talk_no;
  private String talk_content;
  private String talk_user;
  private Timestamp written_at;
  

}
