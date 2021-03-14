package com.mycompany.TowerBattlesSorter;

import java.awt.BorderLayout;
import java.text.DecimalFormat;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Random;
import java.util.TreeMap;

/**
 *
 * @author Lucas
 */
public class TowerSorter {
    
  static HashMap<String,Double> torres = new HashMap<String,Double>();
  static HashMap<String,Boolean> sorteds = new HashMap<String,Boolean>();
  static String returnString = "";
  
  public static void main(String[]args){
      
    boolean repeatTower = Boolean.parseBoolean(args[0]);
    int numberOftowers = Integer.parseInt(args[1]);
    double mode = Double.parseDouble(args[2]);
    
    trainTorre(mode);
    println("\n############Towers Drawn#############\n");
    for(int i=0;i<numberOftowers;){
      if(sorteiaTorre(repeatTower, numberOftowers)){
          i++;
      }
    }
    println("\n#####################################\n");
    
    println("\nDeveloped by Lucas Lopes Resende\n");

  }
  
  public static String Sorteador(boolean repeatTower, int numberOftowers, double mode) {
	  returnString = "";
	  trainTorre(mode);
	    println("\n############Towers Drawn#############\n");
	    for(int i=0;i<numberOftowers;){
		      if(sorteiaTorre(repeatTower, numberOftowers)){
		          i++;
		      }
	    }
	    println("\n#####################################\n");
	    
	    println("\n<code>Developed by Lucas Lopes Resende</code>\n");
	    return returnString;
  }
  
  static void print(String to_print) {
	  returnString+= to_print;
  }
  
  static void printn(String to_print) {
	  returnString+= to_print+"\n";
  }
  
  static void println(String to_print) {
	  returnString+= to_print+"<br>";
  }
  
  static void trainTorre (double mode){
    
    torres.clear();
    sorteds.clear();
    
    torres.put("Scout",(double)1/250);
    torres.put("Sniper",(double)1/450);
    torres.put("Fragger",(double)1/350);
    torres.put("Farm",(double)1/300);
    torres.put("Tuber",(double)1/800);
    torres.put("Mortar",(double)1/800);
    torres.put("Patrol",(double)1/400);
    torres.put("Enforcer",(double)1/350);
    torres.put("Mercenary",(double)1/850);
    torres.put("MaskMan",(double)1/850);
    torres.put("Commander",(double)1/600);
    torres.put("Shotgunner",(double)1/350);
    torres.put("CyroGunner",(double)1/200);
    torres.put("Soldier",(double)1/450);
    torres.put("Barracks",(double)1/850);
    torres.put("Aviator",(double)1/850);
    torres.put("Flamethower",(double)1/750);
    torres.put("Commando",(double)1/1850);
    torres.put("DJ",(double)1/950);
    torres.put("Railgunner",(double)1/2450);
    torres.put("PlasmaTrooper",(double)1/1100);
    torres.put("Phazer",(double)1/3200);
    torres.put("Zed",(double)1/5650);
    torres.put("Snoowballer",(double)1/100);
    torres.put("Tweeter",(double)1/325);
    torres.put("Sleeter",(double)1/700);
    torres.put("Hallowbommer",(double)1/750);
    torres.put("Graveyard",(double)1/480);
    torres.put("Graveyard",(double)1/690);
    torres.put("Golden Commando",(double)1/4690);
    Random rand = new Random();
    
    TreeMap<String,Double>tower_sorted = new TreeMap<String,Double>(new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return torres.get(s2).compareTo(torres.get(s1)+(rand.nextDouble()*0.000001));
            }
        });
    
    double weight = 0;
    
    for(String torre : torres.keySet()){
      torres.put(torre,Math.pow((double)torres.get(torre),mode));
    }
    
    for(String torre : torres.keySet()){
      weight+=torres.get(torre);
    }
    
    for(String torre : torres.keySet()){
      torres.put(torre,(double)torres.get(torre)/weight);
    }
    
    DecimalFormat format = new DecimalFormat("0.##"); 
    println("\n<h2>Probability of Drawing a Tower</h2>\n");
    
    tower_sorted.putAll(torres);
    print("<textarea rows=\"32\" cols=\"42\" readonly>");
    printn(" ______________________________________");
    for(String torre : tower_sorted.keySet()){
        print("|");
        print(torre);
        for(int j=0; j <20-torre.length();j++){
            print(" ");
        }
        print("\t | \t"+format.format(torres.get(torre)*100)+"%");
        
        for(int j=0; j <6-(format.format(torres.get(torre)*100)).length();j++){
            print(" ");
        }
        printn("|");
    }
    printn(" --------------------------------------");
    print("</textarea><br>");
    for(String torre : torres.keySet()){
        sorteds.put(torre,false);
    }
    
  }
  
  static boolean sorteiaTorre(boolean repeatTower, int numberOftowers){
      
    boolean sorteou = false;
    
    HashMap<String,Double> sorteia = new HashMap<String,Double>();
    sorteia.putAll(torres);
    
    double weight = 0;
    for(String torre: sorteia.keySet()){
      weight+=sorteia.get(torre);
      sorteia.put(torre,weight);
    }
    
    Random sorteador = new Random();
    double valor_sorteado = sorteador.nextDouble();
    
    LinkedList<String> torres_key = new LinkedList<String>(sorteia.keySet());
    
    print("<h3>");
    
    for(int i=0; i<torres_key.size();i++){
      if(i==0){
        double min = 0;
        double max = sorteia.get(torres_key.get(i));
        if(valor_sorteado>=min && valor_sorteado<=max){
            
            if(!sorteds.get(torres_key.get(i))){
                sorteou = true;
                println(torres_key.get(i));
            }
            
            if(!repeatTower){
                sorteds.put(torres_key.get(i),true);
            }
        }
      }else{
        double min = sorteia.get(torres_key.get(i-1));
        double max = sorteia.get(torres_key.get(i));
        if(valor_sorteado>=min && valor_sorteado<=max){
            if(!sorteds.get(torres_key.get(i))){
                sorteou = true;
                println(torres_key.get(i));
            }
            
            if(!repeatTower){
                sorteds.put(torres_key.get(i),true);
            }
        }
      }
    }
    print("</h3>");
    return sorteou;
  } 
  
}