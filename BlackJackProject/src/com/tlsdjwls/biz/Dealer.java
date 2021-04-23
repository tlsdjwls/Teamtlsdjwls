package com.tlsdjwls.biz;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import com.tlsdjwls.biz.model.DeckVO;
import com.tlsdjwls.biz.model.ScoreVO;
import com.tlsdjwls.biz.service.DeckService;

public class Dealer{
  protected List<DeckVO> deckList;
  protected List<ScoreVO> scList;
  protected Random rnd;
  private static final int card = 16; // 딜러 카드가 16이하일경우 무조건뽑아야함
  private static final String name = "딜러"; // 이름 설정 딜러
  
  
	public Dealer() {
		deckList = new ArrayList<DeckVO>(); // 댁 리스트 VO 로 받아오기
		}

	public void hit(String name) {
		// TODO 딜러 카드 드로우
		for (DeckVO vo : deckList) {
		System.out.println("=".repeat(50));
		System.out.println(name + "카드 뽑기");
	    System.out.println("=".repeat(50));
		Integer Num = rnd.nextInt(21) + 1; // 랜덤카드 선택후 카드를 뽑았을때 16이하이면 카드를 무조건 뽑아야함
		for (int i = 0; i < card; i++) {
			if (Num > card) {
				System.out.println(card + "보다 점수가 적습니다 한장뽑아주세요");
			 } else if (Num < card + i) {
				System.out.println("카드를 뽑겠습니까?");
			  }
		}
		vo.getCardShap(); // 딜러 카드를 vo 값에 저장
		vo.getCardNum();
		deckList.add(vo);
		this.hit(name);
	}

	}

	public void stay(String name) {
		System.out.println(name + "더이상 카드를 뽑을수 없습니다");

	}
    public void DealerPoint() {
    // TODO 딜러점수 를 vo에 저장
    	System.out.println("=".repeat(50));
    	System.out.println("딜러 점수");
    	System.out.println("=".repeat(50));
        for(DeckVO voi : deckList) {
    	System.out.println(voi.getDealerPoint());
    	deckList.add(voi);
    	}
        for(ScoreVO vni : scList) {
        System.out.println(vni.getWin());
        System.out.println(vni.getLose());
        scList.add(vni);
        }
    	this.DealerPoint();
    }
    
} 	
    
  
  
  
  

