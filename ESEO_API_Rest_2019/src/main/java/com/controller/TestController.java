package com.controller;

import java.util.ArrayList;
import java.util.List;

import com.dao.VilleFranceDAO;
import com.dto.VilleFranceDTO;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	
	@CrossOrigin
	@RequestMapping(value="/test",method=RequestMethod.GET)
	@ResponseBody
	public String get(@RequestParam(required=false,value="value") String value) {
		System.out.println("Appel GET");
		System.out.println("value : "+value);
		 
		return value;
	}
	
	@CrossOrigin
	@RequestMapping(value="/get",method=RequestMethod.GET)
	@ResponseBody
	public List<VilleFranceDTO> getbdd(@RequestParam(required=false,value="value") String value) {
		System.out.println("Appel GET");
		VilleFranceDAO dao = new VilleFranceDAO();
		List<VilleFranceDTO> liste = dao.getBDD();
		for (int i=0; i<liste.size();i++)
			System.out.println(liste.get(i).getNom());
		 
		return liste;
	}
	
	@CrossOrigin
	@RequestMapping(value="/getByCP",method=RequestMethod.GET)
	@ResponseBody
	public List<VilleFranceDTO> getbddByCodePostal(@RequestParam(required=false,value="codePostal") String value) {
		System.out.println("Appel GET");
		VilleFranceDAO dao = new VilleFranceDAO();
		List<VilleFranceDTO> liste = dao.getBDDparCodePostal(value);
		for (int i=0; i<liste.size();i++)
			System.out.println(liste.get(i).getNom());
		 
		return liste;
	}
	
	@CrossOrigin
	@RequestMapping(value="/post1",method=RequestMethod.POST)
	@ResponseBody
	public String post(@RequestParam(required=false,value="codeC") String code_commune) {

		System.out.println("Appel POST");
		return "fonctionne";
	}
	
	@CrossOrigin
	@RequestMapping(value="/put",method=RequestMethod.PUT)
	@ResponseBody
	public void post(@RequestParam(required=true,value="codeC") String code_commune,
					@RequestParam(required=true,value="aChanger") int indiceParamAChanger,
					@RequestParam(required=true,value="param") String param) {

		System.out.println("Appel PUT");
		
		VilleFranceDAO dao = new VilleFranceDAO();
		dao.put(param,indiceParamAChanger,code_commune);	
	}
	
	@CrossOrigin
	@RequestMapping(value="/delete",method=RequestMethod.DELETE)
	@ResponseBody
	public void delete(@RequestParam(required=true,value="codeC") String code_commune) {

		System.out.println("Appel DELETE");
		
		VilleFranceDAO dao = new VilleFranceDAO();
		dao.delete(code_commune);	
	}
	
}
