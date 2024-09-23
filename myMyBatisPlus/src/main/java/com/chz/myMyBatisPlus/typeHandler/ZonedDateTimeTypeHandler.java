package com.chz.myMyBatisPlus.typeHandler;

import com.chz.myMyBatisPlus.utils.DateTimeUtils;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;

public class ZonedDateTimeTypeHandler extends BaseTypeHandler<ZonedDateTime>
{

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, ZonedDateTime parameter, JdbcType jdbcType)
            throws SQLException {
        ps.setObject(i, DateTimeUtils.convertZoneId(parameter, DateTimeUtils.getUTCZoneId()).toLocalDateTime());
    }

    @Override
    public ZonedDateTime getNullableResult(ResultSet rs, String columnName) throws SQLException {
        LocalDateTime dateTime = rs.getObject(columnName, LocalDateTime.class);
        return DateTimeUtils.toZoned(dateTime, DateTimeUtils.getUTCZoneId(), DateTimeUtils.getDefaultZoneId());
    }

    @Override
    public ZonedDateTime getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        LocalDateTime dateTime = rs.getObject(columnIndex, LocalDateTime.class);
        return DateTimeUtils.toZoned(dateTime, DateTimeUtils.getUTCZoneId(), DateTimeUtils.getDefaultZoneId());
    }

    @Override
    public ZonedDateTime getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        LocalDateTime dateTime = cs.getObject(columnIndex, LocalDateTime.class);
        return DateTimeUtils.toZoned(dateTime, DateTimeUtils.getUTCZoneId(), DateTimeUtils.getDefaultZoneId());
    }

}
