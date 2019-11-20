package com.hib.morningstar;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AccountPaymentCard {
	@Id
	private String accountPaymentCardId;	//Unique Identifier
	private String accountId;				//ID of associated account
	private String cardExpDate;			//Expiration date of card
	private String cardType;			//Card type. Visa, Mastercard, American Express
	private String cardNumber;			//Number on card
	private String cardName;			//Full name on card
	
	public AccountPaymentCard(String accountPaymentCardId, String accountId, String cardExpDate, String cardType,
			String cardNumber, String cardName) {

		this.accountPaymentCardId = accountPaymentCardId;
		this.accountId = accountId;
		this.cardExpDate = cardExpDate;
		this.cardType = cardType;
		this.cardNumber = cardNumber;
		this.cardName = cardName;
	}

	public String getAccountPaymentCardId() {
		return accountPaymentCardId;
	}

	public void setAccountPaymentCardId(String accountPaymentCardId) {
		this.accountPaymentCardId = accountPaymentCardId;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getCardExpDate() {
		return cardExpDate;
	}

	public void setCardExpDate(String cardExpDate) {
		this.cardExpDate = cardExpDate;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getCardName() {
		return cardName;
	}

	public void setCardName(String cardName) {
		this.cardName = cardName;
	}
	
	
}
