package com.stocks.stocksapi.controllers;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.stocks.stocksapi.resources.StockDataResource;
import com.stocks.stocksapi.services.StockDataService;

@RestController
@RequestMapping("/api-stockdata")
public class StockDataController {
	
	private StockDataService stockDataService;
	
	@GetMapping("/{stock}")
	public ResponseEntity<List<StockDataResource>> getStockData(@RequestParam("x-client_id") String clientid, @PathVariable String stock) {
	List<StockDataResource> stockDataResourceList = stockDataService.getStockData(stock);
	
	return  new ResponseEntity<>(stockDataResourceList, HttpStatus.OK);
}
	
	
	@PostMapping("/missing-stock")	
	public ResponseEntity<StockDataResource>addMissingStockData(@RequestParam("x-client_id") String clientid,
			
			@Valid @RequestBody  StockDataResource stockDataResource){
		StockDataResource addedStockDataResource = stockDataService.addMissingStockData(clientid, stockDataResource);
		
		return new ResponseEntity<>(addedStockDataResource,HttpStatus.CREATED);
		
	}
	
	@PostMapping(value = "/bulk-insert"  , consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity bulkInsertStockData(@RequestHeader("x-client_id") String clientId, @RequestParam(value="file", required = true) MultipartFile stockDataFile) throws IOException{
		
		stockDataService.bulkInsertStockDate(clientId, stockDataFile);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	

}
