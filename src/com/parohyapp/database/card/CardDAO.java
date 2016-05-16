package com.parohyapp.database.card;

import java.util.List;

import com.parohyapp.bank.Card;
import com.parohyapp.database.BankDAO;

public interface CardDAO extends BankDAO{
	public Card getCard(Integer id);
	public List<Card> getCards(Integer accountID);
	public void toggleCard(boolean block, Integer id);
}
