package com.stocks.stocksapi.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.stocks.stocksapi.model.StockData;

@Repository
public interface StockDataRepository extends CrudRepository<StockData, UUID>{
	//List<StockData> findByStock(String stock);
	List<StockData> findAllByStock(String stock);
}
