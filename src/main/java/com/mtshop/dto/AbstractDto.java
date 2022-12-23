package com.mtshop.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;


@Data
public class AbstractDto<T> {
	private Long id;
	private String createdBy;
	private String createdAt;
	private String updatedBy;
	private String updatedAt;
	private List<T> listResult = new ArrayList<>();

}
