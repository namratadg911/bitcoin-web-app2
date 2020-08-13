package com.bitcoin.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.bitcoin.Model.BitCoinInfo;

@Service
public class BitCoinService {
	Map<String, BitCoinInfo> bitCoinMap = null;
	
	public BitCoinInfo getBitCoinInfo(String stockExchange, String currencyName) {
		populateDummyData();
		String keyName = stockExchange+"~"+currencyName;
		if(bitCoinMap!=null && bitCoinMap.containsKey(keyName)) {
			return bitCoinMap.get(keyName);
		}
		return null;
	}
	
	public List<BitCoinInfo> getAllCurrencyInfo(){

		BitCoinInfo info1 = getBitCoinInfo("NYSE","Bitcoin");
		BitCoinInfo info2 = getBitCoinInfo("BSE","Bitcoin");
		boolean diff =calcDiff(info1, info2);
		if(diff) {
			info1.setActionRecommended("SELL");
			info2.setActionRecommended("BUY");
		}else {
			info1.setActionRecommended("BUY");
			info2.setActionRecommended("SELL");
		}
		List<BitCoinInfo> bitCoinIntoList = new ArrayList<>();
		bitCoinIntoList.add(info1);
		bitCoinIntoList.add(info2);
		
		info1 = getBitCoinInfo("NYSE","Ethereum");
		info2 = getBitCoinInfo("BSE","Ethereum");
		diff =calcDiff(info1, info2);
		if(diff) {
			info1.setActionRecommended("BUY");
			info2.setActionRecommended("SELL");
		}else {
			info1.setActionRecommended("SELL");
			info2.setActionRecommended("BUY");
		}
		
		bitCoinIntoList.add(info1);
		bitCoinIntoList.add(info2);
		
		return bitCoinIntoList;
		
	}
	
	private boolean calcDiff(BitCoinInfo info1, BitCoinInfo info2) {
		if(info1.getStockExchange().equalsIgnoreCase(info2.getStockExchange())){
			if(info1.getCryptoCurr().equalsIgnoreCase(info2.getCryptoCurr())) {
				if(info1.getCurrency().equalsIgnoreCase(info2.getCurrency())) {
					if(Integer.parseInt(info1.getCurrVal())<(Integer.parseInt(info2.getCurrVal()))){
						return false;
					}else {
						return true;
					}
				}
			}
		}
		return false;
	}
	
	private void populateDummyData() {
		bitCoinMap = new HashMap<String, BitCoinInfo>();
	
		BitCoinInfo bitCoinInfo1 = new BitCoinInfo();
		bitCoinInfo1.setStockExchange("NYSE");
		bitCoinInfo1.setCurrVal("10000");
		bitCoinInfo1.setCurrency("USD");
		bitCoinInfo1.setCryptoCurr("Bitcoin");
		bitCoinInfo1.setActionRecommended("BUY");
		
		BitCoinInfo bitCoinInfo2 = new BitCoinInfo();
		bitCoinInfo2.setStockExchange("BSE");
		bitCoinInfo2.setCurrVal("10050");
		bitCoinInfo2.setCurrency("USD");
		bitCoinInfo2.setCryptoCurr("Bitcoin");
		bitCoinInfo2.setActionRecommended("SELL");
		
		BitCoinInfo bitCoinInfo3 = new BitCoinInfo();
		bitCoinInfo3.setStockExchange("NYSE");
		bitCoinInfo3.setCurrVal("10050");
		bitCoinInfo3.setCurrency("USD");
		bitCoinInfo3.setCryptoCurr("Ethereum");
		bitCoinInfo3.setActionRecommended("SELL");
		
		BitCoinInfo bitCoinInfo4 = new BitCoinInfo();
		bitCoinInfo4.setStockExchange("BSE");
		bitCoinInfo4.setCurrVal("10030");
		bitCoinInfo4.setCurrency("USD");
		bitCoinInfo4.setCryptoCurr("Ethereum");
		bitCoinInfo4.setActionRecommended("BUY");
		
		bitCoinMap.put("NYSE~Bitcoin",bitCoinInfo1);
		bitCoinMap.put("BSE~Bitcoin",bitCoinInfo2);
		
		bitCoinMap.put("NYSE~Ethereum",bitCoinInfo3);
		bitCoinMap.put("BSE~Ethereum",bitCoinInfo4);
		
		
	}
}
