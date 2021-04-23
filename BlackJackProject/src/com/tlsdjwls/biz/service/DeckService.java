package com.tlsdjwls.biz.service;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import com.tlsdjwls.biz.model.DeckVO;

public class DeckService {

	ArrayList<String> cardlist;
	   ArrayList<DeckVO> cardlist2;
	   Random rnd;
	   DeckVO deckVO;
	   Scanner scan;

	  
	   public DeckService() {
	      cardlist = new ArrayList<String>();
	      cardlist2 = new ArrayList<DeckVO>();
	      rnd = new Random();
	      scan = new Scanner(System.in);

	   }
	   public void cardDeck() {

	      String pattern[] = { "heart", "spade", "clover", "dia" };
	      String cardNum[] = { "A", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" };
	      for (int i = 0; i < 3; i++) {
	         for (int j = 0; j < 14; j++) {
	            cardlist.add(pattern[i] + ":" + cardNum[j]);
	         }
	      }
	      this.cardCheck();
	   }

	   public void cardCheck() {
	      int num = rnd.nextInt(52);
	      String card;
	      Integer cardscore;
	      card = cardlist.get(num);
	      cardlist.remove(num);
	      String cardP[] = card.split(":");
	      if (cardP[1].equals("A")) {
	         cardscore = 1;
	      } else if (cardP[1].equals("J")) {
	         cardscore = 10;
	      } else if (cardP[1].equals("Q")) {
	         cardscore = 10;
	      } else if (cardP[1].equals("K")) {
	         cardscore = 10;
	      } else {
	         cardscore = Integer.valueOf(cardP[1]);
	      }
	      DeckVO cardVO = new DeckVO();
	      cardVO.setCardShap(card);
	      cardVO.setScorePoint(cardscore);
	      cardlist2.add(cardVO);
	      
	   }

	   public void sumScore() {

	   }


}
