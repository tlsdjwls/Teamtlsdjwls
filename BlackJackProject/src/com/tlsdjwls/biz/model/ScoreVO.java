package com.tlsdjwls.biz.model;

public class ScoreVO {

	  private int win;
	   private int lose;
	   
	   
	   
	   public int getWin() {
	      return win;
	   }
	   public void setWin(int win) {
	      this.win = win;
	   }
	   public int getLose() {
	      return lose;
	   }
	   public void setLose(int lose) {
	      this.lose = lose;
	   }
	   public Float getPersent() {
	      
	      Float persent =(float) this.win / (this.win + this.lose) * 100;
	      
	      return persent;
	   }
	   
	   
	   
	   @Override
	   public String toString() {
	      return " [승리=" + win + ", 패배=" + lose + ", 승률=" + this.getPersent() + "]";
	   }
	   
	   

}
