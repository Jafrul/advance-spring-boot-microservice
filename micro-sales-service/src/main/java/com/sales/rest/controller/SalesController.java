package com.sales.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sales.rest.dto.SalesDTO;
import com.sales.rest.service.SalesService;

@RestController
@RequestMapping("/sales")
public class SalesController {

	@Autowired
	private SalesService salesService;

	@GetMapping(value = "/find")
	public ResponseEntity<List<SalesDTO>> getAllSales() {
		List<SalesDTO> list = salesService.findSalesList();
		return new ResponseEntity<List<SalesDTO>>(list, HttpStatus.OK);
	}

	@GetMapping(value = "/find/by-id")
	public ResponseEntity<SalesDTO> getSalesById(@RequestParam Long id) {
		SalesDTO list = salesService.findBySalesId(id);
		return new ResponseEntity<SalesDTO>(list, HttpStatus.OK);
	}
	
	@GetMapping(value = "/find/name/by-id")
	public ResponseEntity<SalesDTO> getSalesNameById(@RequestParam Long id) {
		System.out.println(id+"......................");
		SalesDTO list = salesService.findBySalesId(id);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@PostMapping(value = { "/add", "/update" })
	public ResponseEntity<String> createOrUpdateSales(@RequestBody SalesDTO userDTO) {
		salesService.createOrUpdateSales(userDTO);
		return new ResponseEntity<>("Data Insert sucessfully", HttpStatus.OK);
	}

	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<String> deleteSalesById(@PathVariable("id") Long id) {
		salesService.deleteSales(id);
		return new ResponseEntity<>("Data Delete sucessfully", HttpStatus.OK);
	}

}
