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
		VilleFranceDAO dao = new VilleFranceDAO();
		List<VilleFranceDTO> liste = dao.getBDD();
		 
		return liste;
	}
	
	@CrossOrigin
	@RequestMapping(value="/getByCP",method=RequestMethod.GET)
	@ResponseBody
	public List<VilleFranceDTO> getbddByCodePostal(@RequestParam(required=false,value="codePostal") String value) {

		VilleFranceDAO dao = new VilleFranceDAO();
		List<VilleFranceDTO> liste = dao.getBDDparCodePostal(value);

		 
		return liste;
	}
	
	@CrossOrigin
	@RequestMapping(value="/post",method=RequestMethod.POST)
	@ResponseBody
	public String post(@RequestParam(required=false,value="codeC") String code_commune,
						@RequestParam(required=false,value="nom") String nom,
						@RequestParam(required=false,value="codeP") String code_postal,
						@RequestParam(required=false,value="lblA") String libelle_acheminement,
						@RequestParam(required=false,value="ligne5") String ligne5,
						@RequestParam(required=false,value="latitude") String latitude,
						@RequestParam(required=false,value="longitude") String longitude) {

		VilleFranceDAO dao = new VilleFranceDAO();
		VilleFranceDTO dto = new VilleFranceDTO();
		if(code_commune!=null) {
			dto.setCode_commune(code_commune);
		}
		if(nom!=null) {
			dto.setNom(nom);
		}
		if(code_postal!=null) {
			dto.setCode_postal(code_postal);
		}
		if(libelle_acheminement!=null) {
			dto.setLibelle_acheminement(libelle_acheminement);
		}else {
			dto.setLibelle_acheminement("");
		}
		if(ligne5!=null) {
			dto.setLigne_5(ligne5);
		}else {
			dto.setLigne_5("");
		}
		if(latitude!=null) {
			dto.setLatitude(latitude);
		}else {
			dto.setLatitude("");
		}
		if(longitude!=null) {
			dto.setLongitude(longitude);
		}else {
			dto.setLongitude("");
		}
		
		
		dao.post(dto);
		return "fonctionne";
	}
	
	@CrossOrigin
	@RequestMapping(value="/put",method=RequestMethod.PUT)
	@ResponseBody
	public void put(@RequestParam(required=true,value="codeC") String code_commune,
					@RequestParam(required=true,value="aChanger") int indiceParamAChanger,
					@RequestParam(required=true,value="param") String param) {
		
		VilleFranceDAO dao = new VilleFranceDAO();
		dao.put(param,indiceParamAChanger,code_commune);	
	}
	
	@CrossOrigin
	@RequestMapping(value="/delete",method=RequestMethod.DELETE)
	@ResponseBody
	public void delete(@RequestParam(required=true,value="codeC") String code_commune) {

		
		VilleFranceDAO dao = new VilleFranceDAO();
		dao.delete(code_commune);	
	}
	
}
