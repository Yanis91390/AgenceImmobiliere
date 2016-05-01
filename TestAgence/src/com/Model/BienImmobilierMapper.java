package com.Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class BienImmobilierMapper implements RowMapper<BienImmobilier>
{

	@Override
	public BienImmobilier mapRow(ResultSet rs, int arg1) throws SQLException 
	{
		BienImmobilier bien = new BienImmobilier();
		//bien.setTypeBien(rs.getString(TypeBien.valueOf("typeBien")));
		bien.setDisponible(rs.getBoolean("isDisponible"));
		bien.setPrixAchat(rs.getDouble("prixAchat"));
		bien.setLoyer(rs.getDouble("loyer"));
		bien.setCharge(rs.getDouble("charge"));
		bien.setSuperficie(rs.getInt("superficie"));
		//bien.setStatutBien(rs.getString(4));
		/*psm.setString(1, bien.getTypeBien()+"");
    	 psm.setBoolean(2, bien.isDisponible());
    	 psm.setString(3, bien.getStatutBien().toString());
    	 psm.setString(4, bien.getEtatBien().toString());
    	 psm.setDouble(5, bien.getPrixAchat());
    	 psm.setDouble(6, bien.getLoyer());
    	 psm.setDouble(7, bien.getCharge());
    	 psm.setString(8, bien.getAdresse());
    	 psm.setInt(9, bien.getSuperficie());*/
		return bien;
	}

}
