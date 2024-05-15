package com.stocks.stocksapi.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

import com.stocks.stocksapi.resources.StockDataResource;
import com.stocks.stocksapi.utilities.FieldConversionUtils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@IdClass(StockDataKey.class)
public class StockData extends BaseModel{

	@Id
	private int quarter;
	@Id
	private String stock;
	private Date date;
	private BigDecimal open;
	private BigDecimal high;
	private BigDecimal low;
	private BigDecimal close;
	private int volume;
	private Double percent_change_price;
	private Double percent_change_volume_over_last_wk;
	private int previous_weeks_volume;
	private BigDecimal next_weeks_open;
	private BigDecimal next_weeks_close;
	private Double percent_change_next_weeks_price;	
	private int days_to_next_dividend;
	private Double percent_return_next_dividend;
	
	/*
	 * private String quarter; private String stock; private Date
	 * date,open,high,low,close,volume,percent_change_price,
	 * percent_change_volume_over_last_wk,previous_weeks_volume,next_weeks_open,
	 * next_weeks_close,percent_change_next_weeks_price,days_to_next_dividend,
	 * percent_return_next_dividend
	 * 1,AA,1/7/2011,$15.82,$16.72,$15.78,$16.42,239655616,3.79267,,,$16.71,$15.97,-
	 * 4.42849,26,0.182704
	 * 1,AA,1/21/2011,$16.19,$16.38,$15.60,$15.79,138428495,-2.47066,-43.02495926,
	 * 242963398,$15.87,$16.13,1.63831,12,0.189994
	 * 1,AA,1/28/2011,$15.87,$16.63,$15.82,$16.13,151379173,1.63831,9.355500109,
	 * 138428495,$16.18,$17.14,5.93325,5,0.185989
	 */
	
		public StockData(StockDataResource stockDataResource) {
			this.quarter = Integer.parseInt(stockDataResource.getQuarter());
			this.stock = stockDataResource.getStock();
			this.date = FieldConversionUtils.getDateFormatString(stockDataResource.getDate());
			this.open = FieldConversionUtils.getCurrency(stockDataResource.getOpen());
			this.high = FieldConversionUtils.getCurrency(stockDataResource.getHigh()); 
			this.low = FieldConversionUtils.getCurrency(stockDataResource.getLow());
			this.close = FieldConversionUtils.getCurrency(stockDataResource.getClose());
			this.volume = Integer.parseInt(stockDataResource.getVolume());
			this.percent_change_price = Double.parseDouble(stockDataResource.getPercentChangePrice( ) );
			this.percent_change_volume_over_last_wk = Double.valueOf(stockDataResource.getPercentChangeVolumeOverLastWk());//PricegetPercent_change_volume_over_last_wk());//.getPercentChangeVolumeOverLastWk());
			this.previous_weeks_volume = Integer.parseInt(stockDataResource.getVolume());
			this.percent_change_next_weeks_price = Double.valueOf(stockDataResource.getPercentChangeNextWeeksPrice());
			this.days_to_next_dividend = Integer.parseInt(stockDataResource.getDaysToNextDividend());
			this.percent_return_next_dividend = Double.parseDouble(stockDataResource.getPercentReturnNextDividend());
			this.next_weeks_open = FieldConversionUtils.getCurrency(stockDataResource.getNextWeeksOpen());
			this.next_weeks_close  = FieldConversionUtils.getCurrency(stockDataResource.getNextWeeksClose());
			}
		
			public void setDate(String dateString) {
			this.date = FieldConversionUtils.getDateFormatString(dateString);
			}
		
		 public void setOpen(String open) { 
				this.open = BigDecimal.valueOf(Double.parseDouble(open.replace("$", "")));
			}
		 
		 
			public void setHigh(String high) {
				this.high = BigDecimal.valueOf(Double.parseDouble(high.replace("$", "")));

			}
			
			public void setLow(String low) {
				this.low = 	BigDecimal.valueOf(Double.valueOf(low.replace("$", "")));
	
			}
			
			
			public void setClose(String close) {
			this.close = BigDecimal.valueOf(Double.parseDouble(close.replace("$", "")));
			}
		
			public void setNext_weeks_open(String nextWeeksOpen) {
			this.next_weeks_open = 	BigDecimal.valueOf(Double.parseDouble(nextWeeksOpen.replace("$", "")));
			}
		
			public void setNext_weeks_close(String nextWeeksClose) {
				this.next_weeks_close = BigDecimal.valueOf(Double.parseDouble(nextWeeksClose.replace("$", "")));
			}
		}
			
		 class StockDataKey implements Serializable 
		 {
			@Column(name= "stock", nullable = false) 
		 	private String stock;
		
		 	@Column(name="date" , nullable = false)
		 	private Date date;
		 }
	

