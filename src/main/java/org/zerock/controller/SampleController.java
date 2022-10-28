package org.zerock.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.domain.SampleVO;
import org.zerock.domain.Ticket;

import lombok.extern.log4j.Log4j;

@RestController 
@RequestMapping("/sample")
@Log4j
public class SampleController {
	
	@GetMapping(value="/getText", produces="text/plain; charset=UTF-8")
	public String getText() {
		log.info("MIME TYPE: "+MediaType.TEXT_PLAIN_VALUE);
		return "안녕하세요";
	//@RestController는 문자열을 반환하는 경우 순수한 데이터를 반환한다.
	}
	
	@GetMapping(value="/getSample",produces = {MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.APPLICATION_XML_VALUE})
	public SampleVO getSample() {
		return new SampleVO(112, "스타","로드");
	}
	
	@GetMapping(value="/getSample2") // produces 속성은 반드시 지정하지 않아도 된다. 생략 가능.
	public SampleVO getSample2() {
		return new SampleVO(113,"로켓","라쿤");
	}
	
	@GetMapping(value="/getList")
	public List<SampleVO> getList(){
		return IntStream.range(1,10).mapToObj(i->new SampleVO(i, i+"First", i+"Last")).collect(Collectors.toList());
	}
	
	@GetMapping(value="/getMap") // Map인 경우는 키와 값을 가지는 하나의 객체로 간주하고 출력한다.
	public Map<String, SampleVO> getMap(){
		Map<String, SampleVO> map = new HashMap<>();
		map.put("First", new SampleVO(111, "그루트","주니어"));
		
		return map;
	}
	
	@GetMapping(value="/check", params = {"height","weight"})
	public ResponseEntity<SampleVO> check(Double height, Double weight){
		SampleVO vo = new SampleVO(0, ""+height, ""+weight);
		
		ResponseEntity<SampleVO> result = null;
		
		if (height < 150) {
			result = ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(vo);
		} else {
			result = ResponseEntity.status(HttpStatus.OK).body(vo);
		}
		
		return result;
	}
	
	@GetMapping("/product/{cat}/{pid}") //@PathVariable : URL 상에 경로의 일부를 파라미터로 사용할 수 있다. {}의 이름을 처리할 때 사용함
	public String[] getPath(@PathVariable("cat") String cat, @PathVariable("pid") Integer pid) {
		return new String[] {"category: " + cat, "productid: "+pid};
	}
	
	@PostMapping("/ticket")
	public Ticket convert(@RequestBody Ticket ticket) { //@RequestBody : 전달된 요청의 내용을 이용해 해당 파라미터의 타입으로 변환을 요구한다.
		log.info("convert...........ticket" + ticket);
		return ticket;
	}
}
