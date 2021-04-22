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
	   
	   public Integer sumScore() {
	         Integer sumScore = 0;
	         for (DeckVO vo ) {
	            sumScore += vo.getUserPoint();
	         }
	         return sumScore;
	      }

	      public void hit() {
	         // user hit
	         System.out.println("유저가 덱에 카드 한장을 추가했습니다");
	         // 덱 추가
//	         mdList.add(pdList.get(1));
//	         pdList.remove(1);

	         // :D 확인용
//	         System.out.println("=".repeat(50));
//	         System.out.println("유저의 덱 현황");
//	         System.out.println("-".repeat(50));
	//
//	         for (DeckVO vo : mdList) {
//	            System.out.println(vo);
//	         }
//	         System.out.println("-".repeat(50));
//	         System.out.println("총점 : " + this.sumScore()); //
	      }

	      public void stay() {

	         System.out.println("유저가 더이상 덱에 카드를 추가하지 않습니다");
	      }

	      public void user() {
	         
	         while (true) {
	            System.out.println("카드를 한장 더 추가하겠습니까? 0 = Hit / 1 = Stay");
	            System.out.print(">> ");
	            String input = scan.nextLine();
	            Integer nInput = null;
	            try {
	               nInput = Integer.valueOf(input);
	            } catch (NumberFormatException e) {
	               // TODO Auto-generated catch block
	               e.printStackTrace();
	            }
	            if (nInput == 0) {
	               this.hit();
	            } else if (nInput == 1) {
	               this.stay();
	            }
	            break;
	         }

	      }
	      
	      public void pointBust() {
	         // TODO 버스트와 승패 확인
	         // VO에 담긴 카드값을 dealer 와 user 변수에 담고
	         // boolean을 이용해 if() 조건식으로 bust인지 참과 거짓으로 판별
	         int dealer = deckVO.getDealerPoint();
	         boolean dealerBust = false;
	         if(dealer > 21) {
	            dealerBust = true;
	         }
	         int user = deckVO.getUserPoint();
	         boolean userBust = false;
	         if(user > 21) {
	            userBust = true;
	         }
	         
	         // 먼저 딜러와 플레이어의 카드값을 공개
	         System.out.println("딜러 : " + dealer );
	         System.out.println("플레이어 : " + user);
	         
	         // if() 사용해서 각 카드값을 비교하고
	         // bust 상태를 확인하고 승패 판별하는 메시지 출력
	         if(dealer == user || dealerBust && userBust) {
	            System.out.println("무승부");
	         }
	         if(dealer < user || dealerBust ) {
	            System.out.println("플레이어 승");
	         } else {
	            System.out.println("딜러 승");
	         }
	         this.printPoint();
	      }

	      public void printPoint() {
	         // TODO 승패 후 카드 출력
	         
	         /*
	          * dealerList와 userList에 담긴 값들을 변수 Size에 담고
	          * for() 반복문으로 리스트에 담긴 값들을 출력
	          */
	         System.out.println("Dealer Deck");
	         int dSize = dealerList.size();
	         for( int i = 0 ; i < dSize ; i++) {
	            System.out.print(dealerList.get(i) +"\t");
	         }
	         
	         System.out.println("=".repeat(50));
	         
	         System.out.println("Player Deck");
	         int uSize = userList.size();
	         int userPoint;
	         for(int i = 0; i < uSize ; i++) {
	            System.out.print(userList.get(i) + "\t");
	         }
	         
	      }

}
