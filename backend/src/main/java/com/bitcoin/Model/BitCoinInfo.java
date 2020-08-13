package com.bitcoin.Model;

import org.springframework.stereotype.Component;

@Component
public class BitCoinInfo {
	

	private String stockExchange;
	private String cryptoCurr;
	private String currVal;
	private String currency;
	private String actionRecommended;
//	
//	public BitCoinInfo(String stockExchange,
//							String cryptoCurr,
//							String currVal,
//							String currency,
//							String actionRecommended) {
//		this.stockExchange = stockExchange;
//		this.cryptoCurr = cryptoCurr;
//		this.currVal = currVal;
//		this.currency = currency;
//		this.actionRecommended = actionRecommended;
//	}

	public String getStockExchange() {
		return stockExchange;
	}
	public void setStockExchange(String stockExchange) {
		this.stockExchange = stockExchange;
	}
	public String getCryptoCurr() {
		return cryptoCurr;
	}
	public void setCryptoCurr(String cryptoCurr) {
		this.cryptoCurr = cryptoCurr;
	}
	public String getCurrVal() {
		return currVal;
	}
	public void setCurrVal(String currVal) {
		this.currVal = currVal;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getActionRecommended() {
		return actionRecommended;
	}
	public void setActionRecommended(String actionRecommended) {
		this.actionRecommended = actionRecommended;
	}
	
	
}
