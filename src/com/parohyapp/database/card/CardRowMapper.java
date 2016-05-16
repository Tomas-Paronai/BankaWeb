package com.parohyapp.database.card;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.parohyapp.bank.Card;

public class CardRowMapper implements RowMapper<Card> {

	@Override
	public Card mapRow(ResultSet rs, int rowNum) throws SQLException {
		Card resultCard = new Card(rs.getInt("AccountId"),rs.getBoolean("Active"));
		return resultCard;
	}

}
