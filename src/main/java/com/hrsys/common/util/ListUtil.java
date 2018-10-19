package com.hrsys.common.util;

import java.util.ArrayList;
import java.util.List;

import com.hrsys.attendance.dao.DTO.MonthDTO;

/**
 * 用于处理List转化
 * @author Lofu
 */
public class ListUtil {

	/** List对象的转化 MonthDTO */
	public static List<MonthDTO> toListDTO(List<Object[]> objectsList) {
		List<MonthDTO> result = new ArrayList<MonthDTO>();
		for(Object[] objects : objectsList) {
			MonthDTO monthDTO = new MonthDTO();
			monthDTO.setMonth(objects[0].toString()+"月");
			monthDTO.setCount(Integer.parseInt(objects[1].toString()));
			result.add(monthDTO);
		}
		return result;
	}
}
