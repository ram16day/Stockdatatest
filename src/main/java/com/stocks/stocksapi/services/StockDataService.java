package com.stocks.stocksapi.services;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.stocks.stocksapi.model.StockData;
import com.stocks.stocksapi.repositories.StockDataRepository;
import com.stocks.stocksapi.resources.StockDataResource;
import com.stocks.stocksapi.utilities.CsvFileMapper;

@Service
public class StockDataService {

	  StockDataRepository stockDataRepository;
	
	/*
	 * public List<StockDataResource> getStockData(String stock){ return
	 * stockDataRepository.findByStock(stock); // return
	 * stockDataRepository.findById(stock); }
	 */
	@Async
		public List<StockDataResource> getStockData(String stock) {
			return stockDataRepository.findAllByStock(stock).stream()
			.map(StockDataResource::new)
			.collect(Collectors.toList());
		}
			
	@Async
		public StockDataResource addMissingStockData(String clientId, StockDataResource stockDataResource) {
			StockData missingStockData = new StockData(stockDataResource) ; 
			return new StockDataResource(stockDataRepository.save(missingStockData));
		}
	
		@Async				
		public void bulkInsertStockDate(String clientld, MultipartFile stockDataFile) throws IOException{

			List<StockData> stockDataToInsert = CsvFileMapper.read(StockData.class, stockDataFile.getInputStream());
			stockDataRepository.saveAll( stockDataToInsert) ;
				
		}

}
