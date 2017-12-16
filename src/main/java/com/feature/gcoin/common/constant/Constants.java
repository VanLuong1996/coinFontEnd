package com.feature.gcoin.common.constant;

/**
 * Created by tiennv02 on 11/8/2017.
 */
public interface Constants {
	
	public enum TransactionType{
		ADD_COIN,
		SUBTRACTION_COIN,
		TRANSFER_COIN,
		VOTE
	}
	
	public enum ResponseCode{
		OK(200, "Success");
		
		
		private Integer value;
		private String display;
		
		ResponseCode(Integer value, String display){
			this.value = value;
			this.display = display;
		}
		
		public Integer getValue(){
			return value;
		}
		
		public String getDisplay(){
			return display;
		}
	}
	
	public enum ExceptionCode{
		Unknown(-1000, "");
		
		
		private Integer value;
		private String display;
		
		ExceptionCode(Integer value, String display){
			this.value = value;
			this.display = display;
		}
		
		public Integer getValue(){
			return value;
		}
		
		public String getDisplay(){
			return display;
		}
	}
}
