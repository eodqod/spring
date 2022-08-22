package kr.human.security.dao;

import java.sql.SQLException;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TestDAO {
	String today() throws SQLException;;
}
