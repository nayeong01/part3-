package org.zerock.domain;


import org.springframework.web.util.UriComponentsBuilder;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class Criteria {
	
	private int pageNum;
	private int amount;
	
	private String type;
	private String keyword; 
	
	public Criteria() {
		this(1,10);
	}
	
	public Criteria(int pageNum, int amount) {
		this.pageNum=pageNum;
		this.amount=amount;
	}
	
	public String[] getTypeArr() {
	// 검색 조건이 각 글자(T,C,W)로 구성되어 있으므로 검색 조건을 배열로 만들어서 한 번에 처리하기 위함이다.
		return type == null? new String[] {} : type.split("");
	}
	
	public String getListLink() {
		UriComponentsBuilder builder=UriComponentsBuilder.fromPath("")
			.queryParam("pageNum",this.pageNum)
			.queryParam("amount",this.getAmount())
			.queryParam("type", this.getType())
			.queryParam("keyword",this.getKeyword());
		
		return builder.toUriString();
	}
}
