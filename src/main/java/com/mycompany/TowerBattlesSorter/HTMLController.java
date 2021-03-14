package com.mycompany.TowerBattlesSorter;


import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@org.springframework.stereotype.Controller
public class HTMLController {
    @GetMapping(value = "/TowerSorter", produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String Tower(@RequestParam(value = "repeatTower", defaultValue = "false") String repeatTower,
			@RequestParam(value = "numberOftowers", defaultValue = "5") String numberOftowers,
			@RequestParam(value = "mode", defaultValue = "1") String mode
			) {
		return TowerSorter.Sorteador(Boolean.parseBoolean(repeatTower), Integer.parseInt(numberOftowers), Double.parseDouble(mode));
	}
}