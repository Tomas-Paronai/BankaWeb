package com.parohyapp.database.card;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.parohyapp.bank.Card;

public class CardDAOImpl implements CardDAO{
	
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	
	@Override
	public void setDataSource(DataSource ds) {
		dataSource = ds;
		jdbcTemplateObject = new JdbcTemplate(ds);		
	}

	@Override
	public void delete(Integer id) {
		String query = "DELETE FROM cards WHERE CardID=?";
		jdbcTemplateObject.update(query,new Object[]{id});
	}

	@Override
	public Card getCard(Integer id) {
		String query = "SELECT * FROM cards WHERE CardID=?";
		Card result = jdbcTemplateObject.queryForObject(query, new Object[]{id}, new CardRowMapper());
		return result;
	}

	@Override
	public List<Card> getCards(Integer accountID) {
		String query = "SELECT * FROM cards WHERE AccountID=?";
		List<Card> cards = jdbcTemplateObject.query(query, new Object[]{accountID},new CardRowMapper());
		return cards;
	}

	@Override
	public void toggleCard(boolean block, Integer id) {
		String query = "UPDATE cards SET Active=? WHERE CardID=?";
		if(block){
			jdbcTemplateObject.update(query,new Object[]{"b'1'",id});
		}
		else{
			jdbcTemplateObject.update(query,new Object[]{"\0",id});
		}
	}

}
