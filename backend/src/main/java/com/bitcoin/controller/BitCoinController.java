package com.bitcoin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bitcoin.Model.BitCoinInfo;
import com.bitcoin.service.BitCoinService;

@RestController
public class BitCoinController {
	
	@Autowired
	BitCoinService bitCoinService;

	@GetMapping("getBitCoinInfo")
	public BitCoinInfo getBitCoinInfo(@RequestBody String  exchangeCurr ) {
		String stkExchg = exchangeCurr.split("~")[0];
		String currName = exchangeCurr.split("~")[1];
		return bitCoinService.getBitCoinInfo(stkExchg, currName);
	}
//	getAllCurrencyInfo
	
	@GetMapping("getAllCurrencyInfo")
	public List<BitCoinInfo> getAllCurrencyInfo() {
		return bitCoinService.getAllCurrencyInfo();
	}
}
