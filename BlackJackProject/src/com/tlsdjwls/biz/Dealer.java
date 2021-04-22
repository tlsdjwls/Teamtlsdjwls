package com.tlsdjwls.biz;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import com.tlsdjwls.biz.model.DeckVO;
import com.tlsdjwls.biz.model.ScoreVO;
import com.tlsdjwls.biz.service.DeckService;

public class Dealer extends DeckService {
  protected List<DeckVO> deckList;
  protected List<ScoreVO> scoreList;
  protected Random rnd;
  private static final int card = 16; // 딜러 카드가 16이하일경우 무조건뽑아야함
  private static final String name = "딜러";
  
  
  public Dealer() {
	deckList = new ArrayList<DeckVO>();
	scoreList = new LinkedList<ScoreVO>();
	
	
  }
  public void hit(String name) {
	  // TODO 딜러 카드 드로우
	  System.out.println("=".repeat(50));
	  System.out.println("카드 뽑기");
	  System.out.println("=".repeat(50));
	 
	  
  }
  
  public void prentDealer() {
	  Integer Num = rnd.nextInt(20) + 1;
	  for(int i = 0 ; i < card ; i++) {
	  if(Num > card) {
	   System.out.println(card + "보다 카드가 적습니다 한장뽑아주세요");	  
	  }else if(Num < card + i) {
	   System.out.println("카드를 뽑겠습니까?");
	  }
	   
	  }
  }
  
  
}
