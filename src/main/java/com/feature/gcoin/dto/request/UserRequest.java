package com.feature.gcoin.dto.request;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserRequest implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonProperty("user_send_id")
	private Long userSendId;
	
	@JsonProperty("totalCoin")
	private Long totalCoin;
	
	@JsonProperty("user_receive_id")
	private Long userReceiveId;

	public Long getUserSendId() {
		return userSendId == null ? 0L : userSendId;
	}

	public void setUserSendId(Long userSendId) {
		this.userSendId = userSendId;
	}

	public Long getTotalCoin() {
		return totalCoin == null ? 0L : totalCoin;
	}

	public void setTotalCoin(Long totalCoin) {
		this.totalCoin = totalCoin;
	}

	public Long getUserReceiveId() {
		return userReceiveId == null ? 0L : userReceiveId;
	}

	public void setUserReceiveId(Long userReceiveId) {
		this.userReceiveId = userReceiveId;
	}


}
