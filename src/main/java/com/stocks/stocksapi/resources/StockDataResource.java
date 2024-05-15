package com.stocks.stocksapi.resources;

import javax.validation.constraints.NotBlank;

import com.stocks.stocksapi.model.StockData;
import com.stocks.stocksapi.utilities.FieldConversionUtils;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
public class StockDataResource {
		
	
	public StockDataResource(StockData stockData){
	
	this.quarter = String.valueOf(stockData.getQuarter());
	this.stock =  String.valueOf(stockData.getStock());
	this.date = FieldConversionUtils.getDateString(stockData.getDate());				
	this.open = FieldConversionUtils.getCurrencyString(stockData.getOpen());
	this.high = FieldConversionUtils.getCurrencyString(stockData.getHigh());
	this.low = FieldConversionUtils.getCurrencyString(stockData.getLow());
	this.close = FieldConversionUtils.getCurrencyString(stockData.getClose());
	this.volume = String.valueOf(stockData.getVolume());
	this.percentChangePrice = String.valueOf(stockData.getPercent_change_price());
	this.percentChangeVolumeOverLastWk = String.valueOf(stockData.getPercent_change_volume_over_last_wk());
	this.previousWeeksVolume =String.valueOf(stockData.getPrevious_weeks_volume());
	this.nextWeeksOpen = FieldConversionUtils.getCurrencyString(stockData.getNext_weeks_open());
	this.nextWeeksClose = FieldConversionUtils.getCurrencyString(stockData.getNext_weeks_close());
	this.percentChangeNextWeeksPrice = String.valueOf(stockData.getPercent_change_next_weeks_price()) ;
	this.daysToNextDividend = String.valueOf(stockData.getDays_to_next_dividend());
	this.percentReturnNextDividend = String.valueOf(stockData.getPercent_return_next_dividend());


	}

		@NotBlank(message = "quarter must be provided")
		private String quarter;
	
		@NotBlank(message ="stock must be provided")
		private String stock;
	
		@NotBlank(message ="date must be provided")
		private String date;
		
		@NotBlank(message = "open must be provided")
		private String open ;

		@NotBlank(message ="high must be provided")
		private String high;
		
		@NotBlank(message ="low must be provided")
		private String low;
		
		@NotBlank(message = "close must be provided")
		private String close;
		
		@NotBlank(message ="volume must be provided")
		private String volume;
		
		@NotBlank(message = "percentChangePrice must be provided")
		private String percentChangePrice;

		@NotBlank(message = "percentChangeVolumeOverLastWk must be provided")
		private String percentChangeVolumeOverLastWk;
		
		@NotBlank(message ="previousWeeksVolume must be provided")
		private String previousWeeksVolume;
		
		@NotBlank(message = "nextWeeksOpen must be provided") 
		private String nextWeeksOpen;
		
		@NotBlank(message = " nextWeeksCtose must be provided")
		private String nextWeeksClose;
		
		@NotBlank(message = "percentChangeNextWeeksPrice must be provided")
		private String percentChangeNextWeeksPrice;
		
		@NotBlank(message = "must be provided")
		private String daysToNextDividend ;
		
		@NotBlank(message = "percentReturnNextDividend must be provided")
		private String percentReturnNextDividend;
	
		
}